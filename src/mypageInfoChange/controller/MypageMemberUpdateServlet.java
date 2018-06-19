package mypageInfoChange.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import mypageInfoChange.model.service.UpdateService;

/**
 * Servlet implementation class MypageMemberUpdateServlet
 */
@WebServlet(name="MypageMemberUpdateServlet", urlPatterns="/memberUpdate.do")
public class MypageMemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MypageMemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String memberPw= request.getParameter("memberPwNew");
		String memberName = request.getParameter("memberName");
		//선택사항 입력받은 값들
		
		String memberPhone = request.getParameter("memberPhone");
		String memberEmail = request.getParameter("memberEmail");
		String memberAddress = request.getParameter("memberAddress");
		
		/*//세션에서 가져온 선택사항 원래 값들
		String memberPhone=request.getParameter("OriMemberPhone");
		String memberEmail=request.getParameter("OriMemberEmail");
		String memberAddress=request.getParameter("OriMemberAddress");
		if(newMemberPhone!=null||newMemberPhone.equals("")) {
			memberPhone=newMemberPhone;
		}
		if(newMemberEmail!=null||newMemberEmail.equals("")) {
			memberEmail=newMemberEmail;
		}
		if(newMemberAddress!=null||newMemberEmail.equals("")) {
			memberAddress=newMemberAddress;
		}*/
		
		
		
		Member m = new Member(memberId, memberPw, memberName, memberPhone, memberEmail, memberAddress);
		
		int result=new UpdateService().updateMember(m);
		// 요청에 대한 응답작성/처리
		String view = "";
		String msg = "";
		String loc = "";

		if (result > 0) {
			msg = "성공적으로 회원정보를 수정하였습니다.";
		} else {
			msg = "회원정보 수정에 실패하였습니다.";
		}
		view = "views/common/msg.jsp";
		loc = "/";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

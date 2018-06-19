package mypageMemberDelete.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import mypageMemberDelete.service.MemberDeleteService;

/**
 * Servlet implementation class MypageMemberDeleteEndServlet
 */
@WebServlet(name="MypageMemberDeleteEndServlet", urlPatterns="/delete.do")
public class MypageMemberDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMemberDeleteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("memberPw");
		String pw = new MemberDeleteService().selectPw(memberId);
		String msg ="";
		
		String loc ="";
		String view="/views/common/msg.jsp";
		
		if(pw.equals(memberPw))
		{
			int result=new MemberDeleteService().checkPw(memberId);
			if(result>0)
			{
				msg ="삭제완료";
				request.getSession().invalidate();
				loc="/";
			}
			else {
				msg ="삭제실패";
				loc="/mypageMemberDelete.do";
			}
		}
		else {
			msg ="비밀번호 불일치";
			loc="/mypageMemberDelete.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

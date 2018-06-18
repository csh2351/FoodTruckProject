package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginCheckServlet
 */
@WebServlet("/loginCheck.do")
public class MemberLoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//System.out.println(id);
		//System.out.println(pw);
		
		int result=new MemberService().loginCheck(id, pw);
		//System.out.println(result);
		String view="/";
	    String msg="";
	    String loc="/";
		
		if(result==MemberService.LOGIN_OK)
		{
			Member member=new MemberService().selectOne(id);
			//System.out.println(member);
			
			//session객체를 받아서 login데이터를 삽입
			HttpSession session=request.getSession();
			
			session.setAttribute("memberLoggedIn", member);
			session.setMaxInactiveInterval(3000);			
			
			//request.setAttribute("memberLoggedIn",member);
			view="/";
			
		}
		else
			
		{
			
			if(result==MemberService.WRONG_PASSWORD)
			{
				msg="패스워드를 잘못 입력하셨습니다.";
			}
			else
			{
				msg="존재하지 않는 아이디 입니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/login.do");
			view="views/common/msg.jsp";
			
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

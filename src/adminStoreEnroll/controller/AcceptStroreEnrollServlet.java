package adminStoreEnroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;


/**
 * Servlet implementation class AcceptStroreEnrollServlet
 */
@WebServlet("/acceptStroreEnroll.do")
public class AcceptStroreEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptStroreEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberPk = Integer.parseInt(request.getParameter("memberPk"));
		String truckApprove = request.getParameter("truckApprove");
		
		System.out.println(memberPk);
		System.out.println(truckApprove);
			
		int result = new MemberService().updateLevel(memberPk);
		
		String view="";
		String msg="";
		String loc="";
		
		if(result>0)
		{
			msg="점포가입신청 완료";
		
		}
		else
		{
			msg="점포가입신청 실패";
		}
		view="views/common/msg.jsp";
		loc="/adminStoreEnrollList.do";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

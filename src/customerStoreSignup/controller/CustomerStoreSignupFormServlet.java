package customerStoreSignup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.Member;

/**
 * Servlet implementation class CustomerStoreSignupFormServlet
 */
@WebServlet("/customerStoreSignup.do")
public class CustomerStoreSignupFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerStoreSignupFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedIn=(Member)request.getSession().getAttribute("memberLoggedIn");
	      if(memberLoggedIn==null) {
	         request.setAttribute("msg", "점주 가입 신청은 로그인  후에 이용가능합니다.");
	         request.setAttribute("loc", "/customer.do");
	         request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	         return;
	      }else if(memberLoggedIn.getMemberLevel().equals("2")){
	    	  request.setAttribute("msg", "점주님은 이미 점주 승인을 받으셨습니다.");
		      request.setAttribute("loc", "/customer.do");
		      request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	    	  
	      }
		request.getRequestDispatcher("/views/customer/customerStoreSignup/customerStoreSignupForm.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

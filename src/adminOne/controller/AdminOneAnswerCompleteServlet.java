package adminOne.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminOne.model.service.AdminOneService;

/**
 * Servlet implementation class AdminOneAnswerCompleteServlet
 */
@WebServlet("/adminOneAnswerComplete.do")
public class AdminOneAnswerCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOneAnswerCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String answerTitle=request.getParameter("answerTitle");
		String answerContent=request.getParameter("answerContent");
		String Pk=request.getParameter("qnaPk");
		int qnaPk=Integer.parseInt(Pk);
		
		int result=new AdminOneService().updateAnswer(qnaPk, answerTitle, answerContent);
		
		String msg="";
		String loc="/adminOneForm.do";
		String view="/views/common/msg.jsp";
		
		if(result>0) {
			msg="답변을 완료했습니다.";		
		}else {
			msg="답변에 실패했습니다..";
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

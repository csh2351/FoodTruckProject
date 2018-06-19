package adminOne.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminOne.model.service.AdminOneService;
import mypageQuestion.model.vo.Qna;


/**
 * Servlet implementation class AdminOneContentServlet
 */
@WebServlet("/adminOneContent.do")
public class AdminOneContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOneContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int qnaPk=Integer.parseInt(request.getParameter("qnaPk"));
		
		Qna qna=new AdminOneService().selectOne(qnaPk);
		
		String msg="";
		String view="";
		String loc="";
		
		if(qna!=null) {
			request.setAttribute("qna", qna);
			view="/views/admin/adminOne/adminOneContent.jsp";
		}else {
			msg="해당 내용을 불러오는데 실패했습니다.";
			loc="/adminOneForm.do";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			view="/views/common/msg.jsp";
		}

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

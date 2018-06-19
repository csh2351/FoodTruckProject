package mypageQuestion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypageQuestion.model.service.MypageQuestionService;
import mypageQuestion.model.vo.Qna;

/**
 * Servlet implementation class MypageQuestionContentServlet
 */
@WebServlet("/mypageQuestionContent.do")
public class MypageQuestionContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageQuestionContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int qnaPk=Integer.parseInt(request.getParameter("qnaPk"));
		
		Qna qna=new MypageQuestionService().selectOne(qnaPk);
		
		String msg="";
		String view="";
		String loc="";
		
		if(qna!=null) {
			request.setAttribute("qna", qna);
			view="/views/mypage/mypageQuestion/mypageQuestionContent.jsp";
		}else {
			msg="해당 내용을 불러오는데 실패했습니다.";
			loc="/mypageQuestionForm.do";
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

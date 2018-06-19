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
 * Servlet implementation class MypageQuestionWriterEndServlet
 */
@WebServlet("/mypageQuestionWriteEnd.do")
public class MypageQuestionWriterEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageQuestionWriterEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String qnaTitle=request.getParameter("qnaTitle");
		String qnaContent=request.getParameter("qnaContent");
		String qnaWriter=request.getParameter("qnaWriter");
		
		Qna qna=new Qna(qnaTitle, qnaContent, qnaWriter);
		int result=new MypageQuestionService().insertQna(qna);
		String msg="";
		String loc="/mypageQuestionForm.do";
		String view="/views/common/msg.jsp";
		
		if(result>0) {
			msg="1대1 문의 작성이 완료 되었습니다.";
		}else {
			msg="작성이 실패했습니다.";
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

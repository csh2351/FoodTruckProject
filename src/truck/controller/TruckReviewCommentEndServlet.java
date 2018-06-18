package truck.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;
import truck.vo.TruckReviewComment;

/**
 * Servlet implementation class TruckReviewCommentEndServlet
 */
@WebServlet("/truckReviewCommentEnd")
public class TruckReviewCommentEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckReviewCommentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		TruckReviewComment comment=new TruckReviewComment();
		
		String view="/views/common/msg.jsp";
		if(comment!=null){
			comment.setReviewCommentLevel(Integer.parseInt(request.getParameter("reviewCommentLevel")));
			comment.setReviewCommnetWriter(request.getParameter("reivewCommentWriter"));
			comment.setReviewCommentRef(Integer.parseInt(request.getParameter("reviewCommentRef")));
			comment.setMemberPk(Integer.parseInt(request.getParameter("memberPk")));
			comment.setTruckPk(Integer.parseInt(request.getParameter("truckPk")));
			comment.setReviewCommnetContent(request.getParameter("truckCommentContent"));
			
			System.out.println(comment);
			int result=new TruckService().insertTruckReviewComment(comment);
			if(result>0){
				System.out.println("삽입성공");
				request.setAttribute("msg", "사용자 답글작성완료");
				request.setAttribute("loc", "/managetruck?truckChoice=truckReviewComment");
			}
		}
		
		else{
			view = "/views/common/msg.jsp";
			request.setAttribute("msg", "대댓글삭제오류");
			request.setAttribute("loc", "/");
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

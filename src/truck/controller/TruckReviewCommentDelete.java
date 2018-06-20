package truck.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import truck.service.TruckService;

/**
 * Servlet implementation class TruckReviewCommentDelete
 */
@WebServlet("/truckReviewCommentDelete")//대댓글삭제 truckReviewCommentDelete
public class TruckReviewCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckReviewCommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int reviewCommentPk=Integer.parseInt(request.getParameter("reviewCommentPk"));
		int result=new TruckService().deleteTruckComment(reviewCommentPk);
	
		
		String msg="삭제실패";	
		if(result>0){
			msg="삭제성공";
		}
		
		JSONObject obj= new JSONObject();
		obj.put("msg", msg);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().println(obj);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class TruckRevietDelete
 */
@WebServlet("/truckReviewDelete")
public class TruckReviewDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckReviewDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("진입");
		int reviewCommentPk=Integer.parseInt(request.getParameter("reviewCommentPk"));
		String filename=(String)request.getParameter("fileName");
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		
		String saveDir=getServletContext().getRealPath("/images"+File.separator+"truckReview");
		System.out.println("경로"+saveDir);
		System.out.println("reviewCommentPk : "+reviewCommentPk);

		System.out.println(filename);
		boolean flag=false;
		
		if(filename!=null && filename.length()>0) {
		File deleteFile=new File(saveDir+"/"+filename);
		flag=deleteFile.delete();
		}
		
		
		int result=new TruckService().deleteTruckComment(reviewCommentPk);
		if(result>0){
			flag=true;
		}
		
		String msg="삭제실패";	
		if(result>0&&flag){
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

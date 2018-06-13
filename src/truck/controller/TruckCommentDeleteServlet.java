package truck.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;

/**
 * Servlet implementation class TruckCommentDeleteServlet
 */
@WebServlet("/truckCommentDelete")
public class TruckCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewCommentPk=Integer.parseInt(request.getParameter("reviewCommentPk"));
		String filename=(String)request.getParameter("fileName");

		String saveDir=getServletContext().getRealPath("/images"+File.separator+"truckReview");
		System.out.println(filename);
		boolean flag=false;
		if(filename!=null && filename.length()>0) {
		File deleteFile=new File(saveDir+"/"+filename);
		flag=deleteFile.delete();
		System.out.println(flag);
		}
		
		int result=new TruckService().deleteTruckComment(reviewCommentPk);
		String view="/views/common/msg.jsp";
		if(result>0&&flag){
			request.setAttribute("msg", "삭제완료");
			request.setAttribute("loc", "/noticeList");
		}
		else{
			request.setAttribute("msg", "삭제실패[관리자에게문의하세요]");
			request.setAttribute("loc", "/noticeList");
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

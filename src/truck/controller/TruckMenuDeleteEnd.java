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
 * Servlet implementation class TruckMenuDeleteEnd
 */
@WebServlet("/truckMenuDelete")
public class TruckMenuDeleteEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckMenuDeleteEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menuPk=Integer.parseInt(request.getParameter("menuPk"));
		String fileName=request.getParameter("fileName");
	
		String saveDir=getServletContext().getRealPath("/images"+File.separator+"truckMenu");
		System.out.println("경로"+saveDir);
		System.out.println("menuPk : "+menuPk);
		System.out.println("menuPk : "+fileName);

		boolean flag=false;
		if(fileName!=null && fileName.length()>0) {
			File deleteFile=new File(saveDir+"/"+fileName);
			flag=deleteFile.delete();
		}
		
		int result=new TruckService().deleteTruckMenu(menuPk);
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

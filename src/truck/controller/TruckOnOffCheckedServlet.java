package truck.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class TruckOnOffCheckedServlet
 */
@WebServlet(urlPatterns="/truckOnOff")
public class TruckOnOffCheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckOnOffCheckedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String onoffswitch=request.getParameter("onoffswitch");
		System.out.println("onoffswitch"+onoffswitch);
		
		//메시지로직으로 처리하기
		
		String truckStatus="영업종료";
		if(onoffswitch.equals("t")){
			truckStatus="영업시작";
		}
		
		JSONObject obj= new JSONObject();
		obj.put("truckStatus", truckStatus);
		
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

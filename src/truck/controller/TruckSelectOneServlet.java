package truck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Menu;

import truck.service.TruckService;
import truck.vo.Truck;
import truck.vo.TruckMenu;

/**
 * Servlet implementation class TruckSelectOneServlet
 */
@WebServlet(urlPatterns="/truckSelectOne")
public class TruckSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TruckSelectOneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int truck_Pk=Integer.parseInt(request.getParameter("truck_Pk"));
		System.out.println(truck_Pk);
		Truck truck=new TruckService().selectOne(truck_Pk);
		List<TruckMenu>list=new TruckService().selectMenu(truck_Pk);
		
		
		String view="";
		
		if(truck!=null&&list.size()>0){
			view="/views/truck/truckChoiceMenu.jsp";
			request.setAttribute("truck_Pk", truck_Pk);
			request.setAttribute("truck_Menu", list);
		}
		else {
			view="/views/commom/msg.jsp";
			request.setAttribute("msg","트럭을 찾을수 없습니다[관리자에ㅔ문의]");
			request.setAttribute("loc", "/");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

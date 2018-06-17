package truck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;
import truck.vo.TruckMenu;

/**
 * Servlet implementation class TruckUpdateMenuServlet
 */
@WebServlet("/truckMenuUpdate")
public class TruckUpdateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckUpdateMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		
		String view="";
		if(truckPk>0){
			List<TruckMenu> menuList=new TruckService().selectMenu(truckPk);
			view="/views/truck/truckMenuUpdate.jsp";
			System.out.println("menuList:"+menuList);
	        request.setAttribute("menuList", menuList);
		}
		else{
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "[기본키가 비었습니다.]");
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

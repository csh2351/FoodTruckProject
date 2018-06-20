package truck.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;
import truck.vo.Truck;

/**
 * Servlet implementation class SearchTruckServlet
 */
@WebServlet("/searchTruck.do")
public class SearchTruckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTruckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchType=request.getParameter("searchType");
		String searchName=request.getParameter("searchName");
		String msg="";
		String loc="";
		
		String view="/views/truck/truckSelect.jsp";
		List<Truck> truckList=new ArrayList<>();
		//truck service에서 가져옴
		truckList=new TruckService().selectTruckName(searchType, searchName);
	
		request.setAttribute("List", truckList);
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

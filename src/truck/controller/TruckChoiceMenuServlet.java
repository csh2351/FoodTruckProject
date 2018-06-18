package truck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;
import truck.vo.Truck;
import truck.vo.TruckMenu;
import truck.vo.TruckReviewComment;

@WebServlet("/truckChoiceMenu")
public class TruckChoiceMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TruckChoiceMenuServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		

		
		String view="";
		if(truckPk>0){
			List<TruckMenu> menuList=new TruckService().selectMenu(truckPk);
			view="/views/truck/truckChoiceMenu.jsp";
			System.out.println("reviewList:"+menuList);
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

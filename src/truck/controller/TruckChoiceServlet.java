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
import truck.vo.TruckMenu;

/**
 * Servlet implementation class TruckChoiceServlet
 */
@WebServlet("/truckChoice")
public class TruckChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckChoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String choice=request.getParameter("choice");
			int truckPk=Integer.parseInt(request.getParameter("truckPk"));
			//service~dao다녀와서 
			//관련테이블 객체가져와서 
			
			System.out.println("choice:"+choice);
			System.out.println("truckPk:"+truckPk);
			String view="";
			if(choice.equals("menu")){
				//객체같이 보내기
				List<TruckMenu> menuList=new TruckService().selectMenu(truckPk);
				System.out.println("menuList:"+menuList);
				view="/views/truck/truckChoiceMenu.jsp";
				request.setAttribute("menuList", menuList);
			}
			else if(choice.equals("review")){
				//객체같이 보내기

				view="/views/truck/truckChoiceReview.jsp";
//				List<Truck> reviewList=new TruckService().selectByReviewList(truckPk);
//				System.out.println("reviewList:"+reviewList);
//				request.setAttribute("reviewList", reviewList);
			}
			else {
				//객체같이 보내기
				view="/views/truck/truckChoiceEvent.jsp";
			}
			
			//속성보낼꺼 포함해서보냄~
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

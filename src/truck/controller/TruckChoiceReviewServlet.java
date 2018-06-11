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
 * Servlet implementation class TruckChoiceReviewServlet
 */
@WebServlet("/truckChoiceReview")
public class TruckChoiceReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckChoiceReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String choice=request.getParameter("choice");
		int truckpk=Integer.parseInt(request.getParameter("truckPk"));
		//service~dao다녀와서 
		//관련테이블 객체가져와서 
		
		System.out.println("choice:"+choice);
		System.out.println("truckPk:"+truckpk);
		
		
		String view="";
		if(choice.equals("review")){
			//객체같이 보내기
			view="/views/truck/truckChoiceReview.jsp";
//			List<Truck> reviewList=new TruckService().selectByReviewList(truckPk);
//			System.out.println("reviewList:"+reviewList);
//			request.setAttribute("reviewList", reviewList);
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

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
import truck.vo.TruckReviewComment;

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
		
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		String memberId=request.getParameter("memberId");
		System.out.println(truckPk);
		System.out.println(memberId);
		

		//List<TruckMenu> menuList=new TruckService().selectMenu(truckpk);
		
		String view="";
		if(truckPk>0){
			List<TruckReviewComment> reviewList=new TruckService().selectReviewCommnetList(truckPk);
			view="/views/truck/truckChoiceReview.jsp";
			System.out.println("reviewList:"+reviewList);
			request.setAttribute("memberId", memberId);
	        request.setAttribute("reviewList", reviewList);
	        request.setAttribute("truckPk", truckPk);

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

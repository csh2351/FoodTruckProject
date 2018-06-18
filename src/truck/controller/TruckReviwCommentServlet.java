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
 * Servlet implementation class TruckReviwCommentServlet
 */
@WebServlet("/truckReviewComment")
public class TruckReviwCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckReviwCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));

		String view="";
		if(truckPk>0){
			List<TruckReviewComment> reviewList=new TruckService().selectReviewCommnetList(truckPk);
			view="/views/truck/truckManageComment.jsp";
			System.out.println("reviewList:"+reviewList);
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

package truck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import truck.service.TruckService;
import truck.vo.Truck;
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

		HttpSession session = request.getSession(); // 유지되어 있는 세션이 있으면 가져오고 없으면 null값을 리턴한다.
		Truck truck = null;
	
		if (session != null) {// 세션이 존재할때 (점주가 접근)
			Member member = (Member)session.getAttribute("memberLoggedIn");
			System.out.println("member :  "+member);
			
			int memberPk = member.getMemberPk();
			truck = new TruckService().manageTruck(memberPk);
			System.out.println(truck);
		}
		
		
		String view="";
		if(truckPk>0){
			List<TruckReviewComment> reviewList=new TruckService().selectReviewCommnetList(truckPk);
			view="/views/truck/truckManageComment.jsp";
			System.out.println("reviewList:"+reviewList);
	        request.setAttribute("reviewList", reviewList);
	        request.setAttribute("truck", truck);
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

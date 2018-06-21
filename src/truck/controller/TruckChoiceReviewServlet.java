package truck.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import member.model.vo.Member;
import truck.dao.TruckDao;
import truck.service.TruckService;
import truck.vo.Truck;
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

		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("memberLoggedIn");
		System.out.println("session : "+member);
		String memberId="";
		if(member!=null){
			memberId=member.getMemberId();
		}
		
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		Truck truck=new TruckService().selectOne(truckPk);
		System.out.println(truckPk);
		
		
		String view="";
		if(truckPk>0){
			List<TruckReviewComment> reviewList=new TruckService().selectReviewCommnetList(truckPk);
			view="/views/truck/truckChoiceReview.jsp";

			System.out.println("member 체크체크"+member);
			System.out.println("memberId 체크체크"+memberId);
			System.out.println("truckPk 체크체크"+truckPk);
			
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("member", member);
			request.setAttribute("memberId", memberId);
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

package truck.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import truck.service.TruckService;
import truck.vo.Truck;

/**
 * Servlet implementation class ManageTruck
 */
@WebServlet(urlPatterns = "/managestore.do")
public class ManageTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageTruck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(); // 유지되어 있는 세션이 있으면 가져오고 없으면 null값을 리턴한다.
		Truck truck = null;
		
		//개발자영억->점포관리들어왔을떄 truckPk를보냄
		String truckPk=request.getParameter("truckPk");
		
		 if (truckPk!=null) {// 세션이 존재할때 (점주가 접근)
			int truckPk1=Integer.parseInt(truckPk);
			truck = new TruckService().selectOne(truckPk1);
			Timestamp tot = truck.getTruckOpenTime();
			Timestamp tct = truck.getTruckCloseTime();
			System.out.println(truck);

			if (tot != null || tct != null) {
				String openTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckOpenTime());
				String closeTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckCloseTime());
				request.setAttribute("openTime", openTime);
				request.setAttribute("closeTime", closeTime);
			}

		}
		

		 else if (session != null &&truckPk==null) {// 세션이 존재할때 (점주가 접근)
			Member member = (Member) session.getAttribute("memberLoggedIn");
			System.out.println("member :  " + member);
			int memberPk = member.getMemberPk();
			System.out.println("memberPk" + memberPk);
			truck = new TruckService().manageTruck(memberPk);
			Timestamp tot = truck.getTruckOpenTime();
			Timestamp tct = truck.getTruckCloseTime();
			System.out.println(truck);

			if (tot != null || tct != null) {
				String openTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckOpenTime());
				String closeTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckCloseTime());
				request.setAttribute("openTime", openTime);
				request.setAttribute("closeTime", closeTime);
			}

		}
		
	

		String view = "/";

		String truckChoice = "truckMenuUpdate";

		String temp = request.getParameter("truckChoice");
		System.out.println("temp" + temp);
		if (temp != null) {
			truckChoice = temp;
		}

		if (truck == null) {
			view = "/views/common/msg.jsp";
			String msg = "오류가 발생했습니다. 다시 시도해보시고 \n 관리자에게 문의해주세요 [점주접근오류:managetruck]";
			String loc = "/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}

		else {
			view = "views/truck/manageTruck.jsp";
			request.setAttribute("truck", truck);
			request.setAttribute("truckChoice", truckChoice);

		}
		request.getRequestDispatcher(view).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

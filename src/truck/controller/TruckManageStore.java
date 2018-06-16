package truck.controller;

import java.io.IOException;
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
 * Servlet implementation class TruckManageStore
 */
@WebServlet("/managestore.do")
public class TruckManageStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TruckManageStore() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session=request.getSession();
		Member member=(Member)session.getAttribute("memberLoggedIn");
		System.out.println("session : "+member);
		String view="";
		if(member!=null){
			int memberPk=member.getMemberPk();
			System.out.println(memberPk);
			Truck truck=new TruckService().selectOneManageStore(memberPk);
			System.out.println("truck_session"+truck);
			view="/views/truck/manageTruck.jsp";
			request.setAttribute("truck", truck);
		}
		else{
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "점포관리 트럭을 불러올수 없습니다.");
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

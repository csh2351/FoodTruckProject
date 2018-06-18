package truck.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class TruckSelectOneServlet
 */
@WebServlet(urlPatterns="/truckSelectOne")
public class TruckSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TruckSelectOneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
<<<<<<< HEAD
		String temp=request.getParameter("truckChoice");

		System.out.println(truckPk);
		System.out.println(temp);
		
		//처음은 무조건 menu
		String truckChoice="truckChoiceMenu";
		
		
		//댓글삭제로직~
		
		if(temp!=null){
			truckChoice=temp;
		}
		//댓글삭제로직~
		
		Truck truck=new TruckService().selectOne(truckPk);
		System.out.println(truck);
		System.out.println(truck.getReviewCount());
		String view="";
		
		if(truck!=null){
=======
		Truck truck=new TruckService().selectOne(truckPk);
		List<TruckMenu>list=new TruckService().selectMenu(truckPk);
		String openTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckOpenTime()); 
		String closeTime = new SimpleDateFormat("HH:mm:ss").format(truck.getTruckOpenTime());
		String view="";
		System.out.println("오픈타임"+openTime);
		request.setAttribute("openTime", openTime);
		request.setAttribute("closeTime", closeTime);
		if(truck!=null&&list.size()>0){
>>>>>>> origin/semi_foodtruck_1.9
			view="/views/truck/truckChoice.jsp";
			request.setAttribute("truck", truck);
			request.setAttribute("truckChoice", truckChoice);
		}
		else {
			view="/views/commom/msg.jsp";
			request.setAttribute("msg","트럭을 찾을수 없습니다[관리자에ㅔ문의]");
			request.setAttribute("loc", "/");
		}
		
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

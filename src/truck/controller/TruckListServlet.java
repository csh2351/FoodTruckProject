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

/**
 * Servlet implementation class TruckListServlet
 */
@WebServlet(urlPatterns="/truckList")
public class TruckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TruckListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기본리스트
		
		List<Truck> list=null;
		
		String view="/views/truck/truckList.jsp";
		String selectSort=request.getParameter("select_sort");
		if (selectSort!=null) {
			switch (selectSort) {
			case "grade": 
				list=new TruckService().selectBygradeList();
				break;

			case "onOff": 
				list=new TruckService().selectByonOffList();
				break;
				
			case "review": 
				list=new TruckService().selectByReviewList();
				break;
			}
			System.out.println("영업순:"+selectSort);
			System.out.println(list);
			request.setAttribute("list", list);
		}
		
		else{
			list=new TruckService().selectAllLitst();
		}
			if(list.size()>0){
				request.setAttribute("List", list);
			}
			else{
				view="/views/common/msg.jsp";
				request.setAttribute("msg", "리스트를 불러올수없습니다.[관리자문의]");
				request.setAttribute("loc", "/");
			}
		//dao갔따오는 형식으로~
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

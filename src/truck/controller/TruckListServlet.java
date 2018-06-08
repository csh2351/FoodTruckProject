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
		
		/*List<Truck> list=null;
		
		String view="/views/truck/truckList.jsp";
		String selectSort=request.getParameter("selectSort");
		if (selectSort!=null) {
			switch (selectSort) {
			case "grade": 
				list=new TruckService().selectBygradeList(selectSort);
				break;

			case "onOff": 
				list=new TruckService().selectByonOffList(selectSort);
				break;
				
			case "review": 
				list=new TruckService().selectByReviewList(selectSort);
				break;
			}
			System.out.println(selectSort);
			request.setAttribute("selectlist", list);
		}
		
		else{
			list=new TruckService().selectAllLitst();
		}
			if(list.size()>0){
				request.setAttribute("basiclist", list);
			}
			else{
				view="/views/common/msg.jsp";
				request.setAttribute("msg", "리스트를 불러올수없습니다.[관리자문의]");
				request.setAttribute("loc", "/");
			}
		//dao갔따오는 형식으로~*/
		
		request.getRequestDispatcher("/views/truck/truckList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

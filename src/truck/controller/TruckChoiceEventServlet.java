package truck.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;
import event.model.vo.Event;
import truck.service.TruckService;
import truck.vo.Truck;
import truck.vo.TruckMenu;

/**
 * Servlet implementation class TruckChoiceEventServlet
 */
@WebServlet("/truckChoiceEvent")
public class TruckChoiceEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckChoiceEventServlet() {
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
		//List<TruckMenu> menuList=new TruckService().selectMenu(truckpk);
		System.out.println(truckPk);
		
		//현재 페이지 번호
				int cPage;
				try
				{
					cPage=Integer.parseInt(request.getParameter("cPage"));
				}
				catch(NumberFormatException e)
				{
					cPage=1;
				}
				
				int numPerPage=10;
				
				List<Event> eventList = new EventService().selectOneList(cPage, numPerPage, truckPk);
				System.out.println("eventLIst:"+eventList);
				int totalEvent = new EventService().selectOneCount(truckPk);
				System.out.println("totalEvent :"+totalEvent);
				int totalPage = (int)Math.ceil((double)totalEvent/numPerPage);
				String pageBar = "";
				int pageBarSize=5;
				int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
				//페이지 끝번호
				int pageEnd=pageNo+pageBarSize-1;
				
				//html문  이전버튼
				if(pageNo==1) {
					pageBar+="<li><a><span aria-hidden='true'>«</span></a></li>";
				}else {
					pageBar+="<li><a href='"+request.getContextPath()+"/truckChoiceEvent?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>«</span></a></li>";

				}		
				
				while(!(pageNo>pageEnd||pageNo>totalPage)) {
					if(cPage==pageNo) {
						pageBar+="<li><a>"+pageNo+"</a></li>";
					}else {
						pageBar+="<li><a href='"+request.getContextPath()+"/truckChoiceEvent?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a></li>";
					}
					pageNo++;
				}
				
				if(pageNo>totalPage) {
					pageBar+="<li><a><span aria-hidden='true'>»</span></a></li>";
				}else {
					pageBar+="<li><a href='"+request.getContextPath()+"/truckChoiceEvent?cPage="+pageNo+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>»</span></a></li>";
				}
				
				request.setAttribute("pageBar", pageBar);
				request.setAttribute("cPage", cPage);
				request.setAttribute("numPerPage", numPerPage);
				request.setAttribute("eventList", eventList);
				request.setAttribute("truckPk", truckPk);
				
				request.getRequestDispatcher("/views/truck/truckChoiceEvent.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

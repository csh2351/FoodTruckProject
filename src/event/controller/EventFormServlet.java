package event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;
import event.model.vo.Event;

@WebServlet("/eventForm.do")
public class EventFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EventFormServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		List<Event> eventList = new EventService().selectList(cPage,numPerPage);
		int totalEvent = new EventService().selectCount();
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
			pageBar+="<li><a href='"+request.getContextPath()+"/customer.do?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>«</span></a></li>";

		}		
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<li><a>"+pageNo+"</a></li>";
			}else {
				pageBar+="<li><a href='"+request.getContextPath()+"/customer.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<li><a><span aria-hidden='true'>»</span></a></li>";
		}else {
			pageBar+="<li><a href='"+request.getContextPath()+"/customer.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>»</span></a></li>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("eventList", eventList);

		request.getRequestDispatcher("/views/event/event/eventForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

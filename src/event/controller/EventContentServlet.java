package event.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.model.service.EventService;
import event.model.vo.Event;
import member.model.vo.Member;

/**
 * Servlet implementation class EventContentServlet
 */
@WebServlet("/eventContent.do")
public class EventContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		request.setCharacterEncoding("UTF-8");
		int eventPk=Integer.parseInt(request.getParameter("eventPk"));
		
		Event event=new EventService().selectOne(eventPk);

		String view="/views/common/msg.jsp";
		String msg="";
		String loc="/eventForm.do";
		if(event==null) {
			msg="해당 이벤트에 접속할 수 없습니다.";
			request.setAttribute("loc", loc);
			request.setAttribute("msg", msg);
		}else {
			view="views/event/event/eventContent.jsp";
			request.setAttribute("event", event);
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

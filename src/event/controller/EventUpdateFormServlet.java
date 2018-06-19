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
 * Servlet implementation class EventUpdateFormServlet
 */
@WebServlet("/eventUpdateForm.do")
public class EventUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//관리자가 아닐 경우 페이지 접속을 차단하는 로직
		Member memberLoggedIn=(Member)request.getSession().getAttribute("memberLoggedIn");
		if(memberLoggedIn==null||!"admin".equals(memberLoggedIn.getMemberId())) {
			request.setAttribute("msg", "관리자가 아닙니다 해당 서비스를 이용할 수 없습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
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
			view="views/event/event/eventUpdateForm.jsp";
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

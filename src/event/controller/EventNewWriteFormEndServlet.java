package event.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;



import common.MyFileRenamePolicy;
import event.model.service.EventService;
import event.model.vo.Event;
import member.model.vo.Member;

@WebServlet("/eventNewWriteFormEnd.do")
public class EventNewWriteFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventNewWriteFormEndServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자가 아닐 경우 페이지 접속을 차단하는 로직
		Member memberLoggedIn = (Member) request.getSession().getAttribute("memberLoggedIn");
		if (memberLoggedIn == null || !"admin".equals(memberLoggedIn.getMemberId())) {
			request.setAttribute("msg", "관리자가 아닙니다 해당 서비스를 이용할 수 없습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		RequestDispatcher rd=null;
		//1.작업실시!
		if(!ServletFileUpload.isMultipartContent(request))
		{
			request.setAttribute("msg", "게시판작성 오류");
			request.setAttribute("loc", "/eventForm.do");
			rd=request.getRequestDispatcher("/views/common/msg.jsp");
			rd.forward(request, response);
			return;
		}
		//2. 작업
		String root=getServletContext().getRealPath("/");
		String saveDir=root+"uploadFiles"+File.separator+"event";
		//String saveDir="C:\\Users\\hong\\Desktop\\재홍\\workspace\\semiproject0612\\web\\uploadFiles\\event";
		//3. 작업
		int maxSize=1024*1024*10;//10MB설정		
		
		//4. 작업
		MultipartRequest mpr=new MultipartRequest(request, saveDir,	maxSize, "UTF-8", new MyFileRenamePolicy());
		//5. 작업 데이터 삽입작업(비지니스~)
		Event e=new Event();
		e.setEventTitle(mpr.getParameter("eventTitle"));
		e.setEventContent(mpr.getParameter("eventContent"));
		e.setOriginalFileName(mpr.getOriginalFileName("truck-img")); //사용자가 올린 파일명
		e.setRenameFileName(mpr.getFilesystemName("truck-img"));// Myrename~ 가져오는 것
		e.setEventDate(Date.valueOf(mpr.getParameter("eventDate")));
		e.setEventEndDate(Date.valueOf(mpr.getParameter("eventEndDate")));
		
		
		int result = new EventService().insertEvent(e);
		
		String view="/views/common/msg.jsp";
		String msg="";
		String loc="/eventForm.do";
		if(result>0)
		{
			msg="이벤트 등록성공!!";
		}
		else
		{
			msg="이벤트 등록실패!!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		rd=request.getRequestDispatcher(view);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

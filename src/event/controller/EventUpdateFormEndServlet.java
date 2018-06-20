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
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.MyFileRenamePolicy;
import event.model.service.EventService;
import event.model.vo.Event;
import member.model.vo.Member;

/**
 * Servlet implementation class EventUpdateFormEndServlet
 */
@WebServlet("/eventUpdateFormEnd.do")
public class EventUpdateFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자가 아닐 경우 페이지 접속을 차단하는 로직
				Member memberLoggedIn = (Member) request.getSession().getAttribute("memberLoggedIn");
				if (memberLoggedIn == null || !"admin".equals(memberLoggedIn.getMemberId())) {
					request.setAttribute("msg", "관리자가 아닙니다 해당 서비스를 이용할 수 없습니다.");
					request.setAttribute("loc", "/");
					request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
					return;
				}
				
				RequestDispatcher rd=null;
				
				if(!ServletFileUpload.isMultipartContent(request))
				{
					request.setAttribute("msg", "이벤트수정 오류");
					request.setAttribute("loc", "/eventForm.do");
					rd=request.getRequestDispatcher("/views/common/msg.jsp");
					rd.forward(request, response);
					return;
				}
			
				String root=getServletContext().getRealPath("/");
				String saveDir=root+"uploadFiles"+File.separator+"event";
				
			
				int maxSize=1024*1024*10;//10MB설정		
				
				
				MultipartRequest mpr=new MultipartRequest(request, saveDir,	maxSize, "UTF-8", new MyFileRenamePolicy());
				
				//이전에 디비에 저장된 이미지파일 네임 가져오기
				String oldFile=mpr.getParameter("old_file");
				String oldFileOri=mpr.getParameter("old_file_ori");
				
				
				//새로운 이미지파일가져온 변수
				String newFileOri=mpr.getOriginalFileName("truck-img");
				String newFile=mpr.getFilesystemName("truck-img");
				
				File f=mpr.getFile("truck-img");
				
				if(f!=null && f.length()>0)
				//이전파일을 삭제 
				{
					File deleteFile=new File(saveDir+"/"+oldFile);
					deleteFile.delete();
				}
				else
				{
					//삭제가 안됐을 시 이전파일을 새파일에 덮어 씌움
					newFile=oldFile;
					newFileOri=oldFileOri;
				}
				
				Event e=new Event();
				e.setEventPk(Integer.parseInt(mpr.getParameter("eventPk")));
				e.setEventTitle(mpr.getParameter("eventTitle"));
				e.setEventContent(mpr.getParameter("eventContent"));
				e.setOriginalFileName(newFileOri);
				e.setRenameFileName(newFile);
				e.setEventDate(Date.valueOf(mpr.getParameter("eventDate")));
				e.setEventEndDate(Date.valueOf(mpr.getParameter("eventEndDate")));
				String truckPk=mpr.getParameter("truckPk");
				
				boolean check=false;
				if(truckPk.length()==0&&truckPk.equals("")) {
					check=true;
				}else {
				e.setTruckPk(Integer.parseInt(mpr.getParameter("truckPk")));
				}
				
				int result=new EventService().updateEvent(e, check);
				
				
				String view="/views/common/msg.jsp";
				String msg="";
				String loc="/eventForm.do";
					
				if(result>0)
				{
					msg="이벤트 수정 성공";
				}
				else
				{
					msg="이벤트 수정 실패";
				}
				request.setAttribute("msg", msg);
				request.setAttribute("loc",loc);
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

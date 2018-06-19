package customerNotice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerNotice.model.service.CustomerNoticeService;
import customerNotice.model.vo.Notice;

/**
 * Servlet implementation class CustomerNoticeContentServlet
 */
@WebServlet("/customerNoticeContent.do")
public class CustomerNoticeContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerNoticeContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항을 불러오기위한 pk값 받아오기
				request.setCharacterEncoding("UTF-8");
				int noticePk=Integer.parseInt(request.getParameter("noticePk"));
				//보여줄 공지사항 가져오기
				Notice notice=new CustomerNoticeService().selectOne(noticePk);
				//공지사항 가져오기 성공 여부
				String msg="";
				String view="";
				String loc="";
				
				if(notice!=null) {
					request.setAttribute("notice", notice);
					view="/views/customer/customerNotice/customerContentForm.jsp";
				}else {
					msg="해당 내용을 불러오는데 실패했습니다.";
					loc="/customer.do";
					request.setAttribute("msg", msg);
					request.setAttribute("loc", loc);
					view="/views/common/msg.jsp";
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

package customerNotice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerNotice.model.vo.Notice;
import member.model.vo.Member;

/**
 * Servlet implementation class CustomerNoticeWriteServlet
 */
@WebServlet("/customerNoticeWrite.do")
public class CustomerNoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerNoticeWriteServlet() {
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
	
		request.getRequestDispatcher("/views/customer/customerNotice/customerNewNoticeForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
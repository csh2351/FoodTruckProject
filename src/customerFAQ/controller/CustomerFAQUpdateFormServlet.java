package customerFAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerFAQ.model.service.CustomerFAQService;
import customerFAQ.model.vo.CustomerFAQ;
import customerNotice.model.service.CustomerNoticeService;
import customerNotice.model.vo.Notice;
import member.model.vo.Member;

@WebServlet("/customerFAQUpdateForm.do")
public class CustomerFAQUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerFAQUpdateFormServlet() {
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

		int FAQPK = Integer.parseInt(request.getParameter("FAQPK"));
		CustomerFAQ customerFAQ = new CustomerFAQService().selectOne(FAQPK);
		request.setAttribute("customerFAQ", customerFAQ);
		request.getRequestDispatcher("/views/customer/customerFAQ/customerFAQUpdateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

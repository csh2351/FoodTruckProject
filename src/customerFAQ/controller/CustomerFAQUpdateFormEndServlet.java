package customerFAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerFAQ.model.service.CustomerFAQService;
import customerNotice.model.service.CustomerNoticeService;
import member.model.vo.Member;

@WebServlet("/customerFAQUpdateFormEnd.do")
public class CustomerFAQUpdateFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerFAQUpdateFormEndServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Member memberLoggedIn = (Member) request.getSession().getAttribute("memberLoggedIn");
		if (memberLoggedIn == null || !"admin".equals(memberLoggedIn.getMemberId())) {
			request.setAttribute("msg", "잘못된 접근입니다. 메인화면으로 이동합니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8");
		int FAQPK = Integer.parseInt(request.getParameter("FAQPK"));
		String FAQTitle = request.getParameter("FAQTitle");
		String FAQContent = request.getParameter("FAQContent");

		int result = new CustomerFAQService().updateCustomerFAQ(FAQPK, FAQTitle, FAQContent);

		String msg = "";
		String loc = "/customerFAQForm.do";
		String view = "/views/common/msg.jsp";

		if (result > 0) {
			msg = "자주 묻는 질문을 수정했습니다.";
		} else {
			msg = "자주 묻는 질문을 수정에 실패했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

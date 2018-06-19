package customerFAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerFAQ.model.service.CustomerFAQService;
import customerFAQ.model.vo.CustomerFAQ;
import member.model.vo.Member;




@WebServlet("/customerNewFAQFormEnd.do")
public class CustomerNewFAQFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerNewFAQFormEndServlet() {
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

		request.setCharacterEncoding("UTF-8");
		// faq 제목/내용 받아오기
		String FAQTitle = request.getParameter("FAQTitle");
		String FAQContent = request.getParameter("FAQContent");

		// notice객체에 받은 값 저장하기
		CustomerFAQ customerFAQ = new CustomerFAQ();
		customerFAQ.setFAQTitle(FAQTitle);
		customerFAQ.setFAQContent(FAQContent);
		// db에 받은 값 저장
		int result = new CustomerFAQService().insertCustomerFAQ(customerFAQ);
		// 공지사항 등록 성공여부
		String msg = "";
		String loc = "/customerFAQForm.do";
		String view = "/views/common/msg.jsp";
		if (result > 0) {
			msg = "자주묻는질문 등록에 성공했습니다.";
		} else {
			msg = "자주묻는질문 등록에 실패했습니다.";
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

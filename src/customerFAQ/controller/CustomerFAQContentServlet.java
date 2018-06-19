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

@WebServlet("/customerFAQContent.do")
public class CustomerFAQContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerFAQContentServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항을 불러오기위한 pk값 받아오기
		request.setCharacterEncoding("UTF-8");
		int FAQPK=Integer.parseInt(request.getParameter("FAQPK"));
		//보여줄 공지사항 가져오기
		CustomerFAQ customerFAQ = new CustomerFAQService().selectOne(FAQPK);
		//공지사항 가져오기 성공 여부
		String msg="";
		String view="";
		String loc="";
		
		if(customerFAQ!=null) {
			request.setAttribute("customerFAQ", customerFAQ);
			view="/views/customer/customerFAQ/customerFAQContent.jsp";
		}else {
			msg="해당 내용을 불러오는데 실패했습니다.";
			loc="/customerFAQForm.do";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			view="/views/common/msg.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

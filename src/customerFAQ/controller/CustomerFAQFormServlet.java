package customerFAQ.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerFAQ.model.service.CustomerFAQService;
import customerFAQ.model.vo.CustomerFAQ;


@WebServlet("/customerFAQForm.do")
public class CustomerFAQFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CustomerFAQFormServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 페이지 번호
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e) {
			cPage = 1;
		}
		
		//페이지에 보여줄 리스트 갯수
		int numPerPage = 10;
		//전체 faq 리스트에 받아오기
		List<CustomerFAQ> customerFAQList = new CustomerFAQService().selectList(cPage, numPerPage);
		//전체 customerFAQ 수
		int totalcustomerFAQ = new CustomerFAQService().selectCount();
		//전체 페이지 수
		int totalPage = (int)Math.ceil((double)totalcustomerFAQ/numPerPage);
		//customerFAQForm에 보내줄 html문
		String pageBar="";
		//페이지바 사이즈 5로 고정
		int pageBarSize=5;
		//페이지 시작 번호
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		//패이지 끝 번호
		int pageEnd = pageNo + pageBarSize-1;
		
		//html문 이전 버튼
		if(pageNo==1) {
			pageBar+="<li><a><span aria-hidden='true'>«</span></a></li>";
		}else {
			pageBar+="<li><a href='"+request.getContextPath()+"/customerFAQForm.do?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>«</span></a></li>";

		}		
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<li><a>"+pageNo+"</a></li>";
			}else {
				pageBar+="<li><a href='"+request.getContextPath()+"/customerFAQForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<li><a><span aria-hidden='true'>»</span></a></li>";
		}else {
			pageBar+="<li><a href='"+request.getContextPath()+"/customerFAQForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>»</span></a></li>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("customerFAQList", customerFAQList);
		request.getRequestDispatcher("/views/customer/customerFAQ/customerFAQForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package adminStoreManagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminStoreManagement.model.service.AdminStoreManagementService;
import customerStoreSignup.model.vo.Signup;

/**
 * Servlet implementation class AdminStoreManagementFormServlet
 */
@WebServlet("/adminStoreManagementForm.do")
public class AdminStoreManagementFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStoreManagementFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 페이지 번호
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
			
		}catch(NumberFormatException e) {
			cPage=1;
		}
		//페이지에 보여줄 리스트 갯수
		int numPerPage=10;
		//signup 리스트에 받아오기(adminStoreEnroll 서비스 공유함!)
		List<Signup> signupList=new AdminStoreManagementService().selectApproveList(cPage,numPerPage);
		
		
		//전체 signup 수 (adminStoreEnroll 서비스 공유함!)
		int totalSignup=new AdminStoreManagementService().selectApproveCount();
		//전체 페이지 수
		int totalPage=(int)Math.ceil((double)totalSignup/numPerPage);
		//페이징 처리 내용
		String pageBar="";
		//페이지바 사이즈 5로 고정함
		int pageBarSize=5;
		//페이지 시작번호
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		//페이지 끝번호
		int pageEnd=pageNo+pageBarSize-1;
		
		
		//html문  이전버튼
		if(pageNo==1) {
			pageBar+="<li><a><span aria-hidden='true'>«</span></a></li>";
		}else {
			pageBar+="<li><a href='"+request.getContextPath()+"/adminStoreManagementForm.do?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>«</span></a></li>";

		}
		
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<li><a>"+pageNo+"</a></li>";
			}else {
				pageBar+="<li><a href='"+request.getContextPath()+"/adminStoreManagementForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a></li>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<li><a><span aria-hidden='true'>»</span></a></li>";
		}else {
			pageBar+="<li><a href='"+request.getContextPath()+"/adminStoreManagementForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>»</span></a></li>";
		}
		
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("cPage", cPage);
		request.setAttribute("numPerPage", numPerPage);
		request.setAttribute("signupList", signupList);
		

		request.getRequestDispatcher("/views/admin/adminStoreManagement/adminStoreManagementForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

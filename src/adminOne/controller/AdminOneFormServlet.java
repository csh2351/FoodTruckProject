package adminOne.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminOne.model.service.AdminOneService;
import customerNotice.model.vo.Notice;

import member.model.vo.Member;
import mypageQuestion.model.vo.Qna;

/**
 * Servlet implementation class AdminOneFormServlet
 */
@WebServlet("/adminOneForm.do")
public class AdminOneFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOneFormServlet() {
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
		
		
		//현재 페이지 번호
				int cPage;
				try {
					cPage=Integer.parseInt(request.getParameter("cPage"));
					
				}catch(NumberFormatException e) {
					cPage=1;
				}
				//페이지에 보여줄 리스트 갯수
				int numPerPage=10;
				//전체 notice 리스트에 받아오기
				List<Qna> qnaList=new AdminOneService().selectQNAList(cPage,numPerPage);
				//전체 notice 수
				int totalQNA=new AdminOneService().selectQNACount();
				System.out.println(totalQNA);
				//전체 페이지 수
				int totalPage=(int)Math.ceil((double)totalQNA/numPerPage);
				//noticeForm에 보내줄 html문
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
					pageBar+="<li><a href='"+request.getContextPath()+"/adminOneForm.do?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>«</span></a></li>";

				}
				
				
				while(!(pageNo>pageEnd||pageNo>totalPage)) {
					if(cPage==pageNo) {
						pageBar+="<li><a>"+pageNo+"</a></li>";
					}else {
						pageBar+="<li><a href='"+request.getContextPath()+"/adminOneForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a></li>";
					}
					pageNo++;
				}
				
				if(pageNo>totalPage) {
					pageBar+="<li><a><span aria-hidden='true'>»</span></a></li>";
				}else {
					pageBar+="<li><a href='"+request.getContextPath()+"/adminOneForm.do?cPage="+pageNo+"&numPerPage="+numPerPage+"'><span aria-hidden='true'>»</span></a></li>";
				}
			
				
				request.setAttribute("pageBar", pageBar);
				request.setAttribute("cPage", cPage);
				request.setAttribute("numPerPage", numPerPage);
				request.setAttribute("qnaList", qnaList);

		request.getRequestDispatcher("/views/admin/adminOne/adminOneForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

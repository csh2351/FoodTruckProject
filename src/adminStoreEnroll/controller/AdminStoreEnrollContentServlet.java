package adminStoreEnroll.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminStoreEnroll.model.service.AdminStoreEnrollService;
import customerStoreSignup.model.vo.Signup;

/**
 * Servlet implementation class AdminStoreEnrollContentServlet
 */
@WebServlet("/adminStoreEnrollContent.do")
public class AdminStoreEnrollContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStoreEnrollContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int memberPk=Integer.parseInt(request.getParameter("memberPk"));
		
		Signup signup = new AdminStoreEnrollService().selectOne(memberPk);
		
		
		
		String msg="";
		String view="";
		String loc="";
		
		if(signup!=null) {
			request.setAttribute("signup", signup);
			view="/views/admin/adminStoreEnroll/adminStoreEnrollContent.jsp";
		}else {
			msg="해당 내용을 불러오는데 실패했습니다.";
			loc="/adminStoreEnrollList.do";
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

package customerStoreSignup.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customerStoreSignup.model.service.SignupService;
import customerStoreSignup.model.vo.Signup;

/**
 * Servlet implementation class CustomerStoreSignupWriteServlet
 */
@WebServlet("/storeSignupWrite.do")
public class CustomerStoreSignupWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerStoreSignupWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int truckInfoRegisterNumber = Integer.parseInt(request.getParameter("truckInfoRegisterNumber"));
		String truckInfoName = request.getParameter("truckInfoName");
		String truckLocation = request.getParameter("truckLocation");
		int memberPk = Integer.parseInt(request.getParameter("memberPk"));
		
		Signup signup = new Signup(truckInfoRegisterNumber, truckInfoName, truckLocation,memberPk);
		
		int result = new SignupService().insertSignup(signup);
		
		String msg="";
		String loc="/";
		String view="/views/common/msg.jsp";
		
		if(result>0) {
			msg="점포가입신청 완료되었습니다.";
		}else {
			msg="점포가입신청 실패했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
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

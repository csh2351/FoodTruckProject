package truck.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import truck.service.TruckService;
import truck.vo.Truck;
import truck.vo.TruckMenu;

/**
 * Servlet implementation class TruckInsertServlet
 */
@WebServlet({ "/truckBasicInsert", "/trcukDetailInsert","truckInsert" })
public class TruckInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int truckPk=Integer.parseInt(request.getParameter("truckPk"));
		Truck truck = new TruckService().selectOne(truckPk);
		
		String view="";
		if(truck!=null){
			
		}
		else{
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "[트럭 등록 오류입니다. 관리자에게 문의해주세요.]");
			request.setAttribute("loc", "/");

		}
		request.getRequestDispatcher(view).forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

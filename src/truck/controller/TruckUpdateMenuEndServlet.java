package truck.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import truck.service.TruckService;
import truck.vo.Truck;
import truck.vo.TruckMenu;
import truck.vo.TruckReviewComment;

/**
 * Servlet implementation class TruckUpdateMenuEndServlet
 */
@WebServlet("/truckMenuUpdateEnd")
public class TruckUpdateMenuEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckUpdateMenuEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "사진을불러올수없습니다[관리자에 문의하세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}

		String root = getServletContext().getRealPath("/");
		String saveDir = root + "/images" + File.separator + "truckMenu";
		System.out.println(saveDir);
		
		int maxSize = 1024 * 1024 * 10;

		MultipartRequest mpr = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new MyFileRenamePolicy());
		TruckReviewComment comment = new TruckReviewComment();
		
		//truck_menu테이블에넣어야함으로 필요함.
		int truckPk = Integer.parseInt(mpr.getParameter("truckPk"));
		Truck truck=new TruckService().selectOne(truckPk);
		//메뉴에 다넣고
		TruckMenu menu=new TruckMenu();
		menu.setMenuPk(Integer.parseInt(mpr.getParameter("menuPk")));
		menu.setMenuName(mpr.getParameter("menuName"));
		menu.setMenuPrice(Integer.parseInt(mpr.getParameter("menuPrice")));
		
		//있던파일을 유지하게 ~~~ 로직처리
		if(mpr.getOriginalFileName("up_file") != null) {
			menu.setMenuOimage(mpr.getOriginalFileName("up_file"));
			menu.setMenuRimage(mpr.getFilesystemName("up_file"));
		}
		else {
			menu.setMenuRimage(mpr.getParameter("old_file"));
		}
		
		
		int result=new TruckService().UpdateTruckMenu(menu);
		
		//보안에 위배되는 파일삭제
		String checkFile = mpr.getOriginalFileName("up_file");
		
		if (checkFile != null) {
			if (checkFile.contains(".jsp") || checkFile.contains(".exe") || checkFile.contains(".html")) {
				// 삭제로직
				File deleteFile = new File(saveDir + "/" + checkFile);
				deleteFile.delete();
				request.setAttribute("msg", "올릴수 없는파일입니다.[확장자명 확인]");
				System.out.println("결과" + result);
			}
		}
		
		String view="";
		if (result > 0) {
			view = "/views/truck/manageTruck.jsp";
			request.setAttribute("truck", truck);
			request.setAttribute("truckChoice", "truckMenuUpdate");
		} else {
			view = "/views/common/msg.jsp";
			request.setAttribute("msg", "사진은 크기를 확인하세요");
			request.setAttribute("loc", "/");
		}
		
		
		//insert했을때만...
		//메뉴pk가져와서 
		
		//truck_menu에 넣자~
		
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
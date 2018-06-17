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
 * Servlet implementation class TruckMenuInsertEndServlet
 */
@WebServlet("/truckMenuInsertEnd")
public class TruckMenuInsertEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TruckMenuInsertEndServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		int truckPk = Integer.parseInt(mpr.getParameter("truckPk"));
		Truck truck = new TruckService().selectOne(truckPk);

		TruckMenu menu = new TruckMenu();
		menu.setMenuName(mpr.getParameter("menuName"));
		menu.setMenuPrice(Integer.parseInt(mpr.getParameter("menuPrice")));
		menu.setMenuOimage(mpr.getOriginalFileName("up_file"));
		// menuPk를 찾기위해~//
		String menuRimage = mpr.getFilesystemName("up_file");
		menu.setMenuRimage(menuRimage);

		int result = new TruckService().insertTruckMenu(menu);

		// 보안에 웨배되는 파일삭제
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

		// insert했을때만...
		// 메뉴pk가져와서
		// truck_menu에 넣자~
		String view = "";
		if (result > 0) {
			int menuPk = new TruckService().selectOneMenuPk(menuRimage);
			result = new TruckService().insertTruckMenuForeign(menuPk, truckPk);
			if (result > 0) {
				System.out.println("삽입성공");
				view = "/views/common/msg.jsp";
				request.setAttribute("msg", "메뉴작성완료");
				request.setAttribute("loc", "/managestore.do?truckChoice=truckMenuUpdate");
			} else {
				System.out.println("삽입실패");
			}
		} else {
			view = "/views/common/msg.jsp";
			request.setAttribute("msg", "사진은 크기를 확인하세요");
			request.setAttribute("loc", "/");
		}
		request.getRequestDispatcher(view).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

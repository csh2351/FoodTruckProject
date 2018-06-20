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
import truck.vo.TruckReviewComment;

/**
 * Servlet implementation class TruckCommentInsert
 */
@WebServlet("/truckCommentInsert")
public class TruckCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TruckCommentInsert() {
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
		String saveDir = root + "/images" + File.separator + "truckReview";
		System.out.println(saveDir);

		// 크긱조정
		int maxSize = 1024 * 1024 * 10;

		MultipartRequest mpr = new MultipartRequest(request, saveDir, maxSize, "UTF-8", new MyFileRenamePolicy());
		TruckReviewComment comment = new TruckReviewComment();
		int truckPk = Integer.parseInt(mpr.getParameter("truckPk"));
		Truck truck = new TruckService().selectOne(truckPk);

		// db컬럼순으로 입력했음//
		comment.setReviewCommentLevel(Integer.parseInt(mpr.getParameter("reviewCommentLevel")));
		comment.setReviewCommnetWriter(mpr.getParameter("reviewCommentWriter"));
		comment.setReviewCommnetContent(mpr.getParameter("reviewCommentContent"));
		comment.setReviewCommentRef(Integer.parseInt(mpr.getParameter("reviewCommentRef")));
		comment.setReviewCommentOimage(mpr.getOriginalFileName("up_file"));
		comment.setReviewCommentRimage(mpr.getFilesystemName("up_file"));
		double star;
		if(mpr.getParameter("reviewStar")==null){
			star=0;
		}else {
			star=Double.parseDouble(mpr.getParameter("reviewStar"));
		}
		comment.setReviewStar(star);
		comment.setMemberPk(Integer.parseInt(mpr.getParameter("memberPk")));
		comment.setTruckPk(truckPk);

		int result = new TruckService().insertTruckComment(comment);
		System.out.println("결과 :" + result);

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
		String view = "/views/common/msg.jsp";
		if (result > 0) { 
		request.setAttribute("loc", "/managestore.do?truckChoice=truckChoiceReview");
		
		} else {
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

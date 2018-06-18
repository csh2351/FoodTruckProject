package truck.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import oracle.sql.TIMESTAMP;
import truck.service.TruckService;
import truck.vo.Truck;

/**
 * Servlet implementation class TruckUpdateServlet
 */
@WebServlet("/truckUpdate")
public class TruckUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TruckUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveDir = getServletContext().getRealPath("/") + "/images" + File.separator +"truck";
		int maxSize = 1024*1024*10;
		MultipartRequest mpr =new MultipartRequest(request, saveDir, maxSize,"UTF-8", new MyFileRenamePolicy());
		String CheckDetail = mpr.getParameter("truck-name");
		System.out.println("CheckDetail : "+CheckDetail);
	
		int truckPk = Integer.parseInt(mpr.getParameter("truck-pk"));
		
		Truck truck = new TruckService().selectOne(truckPk);
		int result = 0;// 업데이트 결과값 수신
		String view = "/";
		if(!ServletFileUpload.isMultipartContent(request)) {// 파일 불러오기 실패시
			request.setAttribute("msg", "사진을불러올수없습니다[관리자에 문의하세요]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);	
		}
		if (CheckDetail.equals("detail")) { // 디테일단에서 폼 전송했을시
	
			
			truck.setTruckHoliday(mpr.getParameter("truck-holiday"));
			truck.setTrucklocation(mpr.getParameter("truck-address"));
			
			try {
				Date date = (Date) new SimpleDateFormat("HH:mm").parse(mpr.getParameter("truck-open-date")); 
				Date date2 = (Date) new SimpleDateFormat("HH:mm").parse(mpr.getParameter("truck-close-date"));
				Timestamp time1 = new Timestamp(date.getTime());
				truck.setTruckOpenTime(time1);
				Timestamp sqldate2 = new Timestamp(date2.getTime());
				truck.setTruckCloseTime(sqldate2);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			truck.setLatitude(Double.parseDouble(mpr.getParameter("truck-latitude")));
			truck.setLogitude(Double.parseDouble(mpr.getParameter("truck-logitude")));
			result = new TruckService().updateTruck(truck);
		} else { // 베이직 단에서 폼 전송시
			
			truck.setTruckName(mpr.getParameter("truck-name"));
			truck.setTruckOriginalImage(mpr.getOriginalFileName("truck-img"));
			truck.setTruckRenameImage(mpr.getFilesystemName("truck-img"));
			truck.setTruckContent(mpr.getParameter("truck-content"));
			truck.setTruckPrice(Integer.parseInt(mpr.getParameter("min-price")));
			result = new TruckService().updateTruck(truck);
		}
		if(result>0) {
			view ="/views/truck/truckChoice.jsp";
			request.setAttribute("truck",truck);
			request.setAttribute("truckChoice", "truckChoiceMenu");
		}else {
				view = "/views/common/msg.jsp";
				request.setAttribute("msg", "입력 오류입니다. [관리자에게 문의 error : updateTruck]");
				request.setAttribute("loc", "/");
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

package truck.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static common.JDBCTemplate.*;

import member.model.dao.MemberDao;
import truck.vo.Truck;
import truck.vo.TruckMenu;
import truck.vo.TruckReviewComment;

public class TruckDao {
	private PreparedStatement pstmp;
	private ResultSet rs;
	private Properties prop;
	private List<Truck> list;
	
	public TruckDao() {
		pstmp=null;
		rs=null;
		list=new ArrayList<>();
		prop=new Properties();
		String fileName=MemberDao.class.getResource("/sql/truck/truck-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
	}
	
	
	
	

	public List<Truck> selectAllLitst(Connection conn) {
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectAllList"));
			rs=pstmp.executeQuery();
			while(rs.next()){
				Truck truck=new Truck();
				truck.setTruckPk(rs.getInt("truck_pk"));
				truck.setTruckName(rs.getString("truck_name"));
				truck.setTruckOriginalImage(rs.getString("truck_original_image"));
				truck.setTruckRenameImage(rs.getString("truck_rename_image"));
				truck.setTrucklocation(rs.getString("truck_location"));
				truck.setTruckInfoName(rs.getString("truck_info_name"));
				truck.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				truck.setTruckContent(rs.getString("truck_content"));
				truck.setTruckStatus(rs.getString("truck_status"));
				truck.setTruckOpenTime(rs.getDate("truck_open_time"));
				truck.setTruckCloseTime(rs.getDate("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
			truck.setLatitude(rs.getDouble("truck_latitude"));
			truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckStar(rs.getInt("truck_star"));
			truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				list.add(truck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return list;
	}










	public List<Truck> selectBygradeList(Connection conn) {
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectBygradeList"));
			rs=pstmp.executeQuery();
			while(rs.next()){
				Truck truck=new Truck();
				truck.setTruckPk(rs.getInt("truck_pk"));
				truck.setTruckName(rs.getString("truck_name"));
				truck.setTruckOriginalImage(rs.getString("truck_original_image"));
				truck.setTruckRenameImage(rs.getString("truck_rename_image"));
				truck.setTrucklocation(rs.getString("truck_location"));
				truck.setTruckInfoName(rs.getString("truck_info_name"));
				truck.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				truck.setTruckContent(rs.getString("truck_content"));
				truck.setTruckStatus(rs.getString("truck_status"));
				truck.setTruckOpenTime(rs.getDate("truck_open_time"));
				truck.setTruckCloseTime(rs.getDate("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckStar(rs.getInt("truck_star"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				list.add(truck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return list;
		}





	public List<Truck> selectByonOffList(Connection conn) {
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectByonOffList"));
			rs=pstmp.executeQuery();
			while(rs.next()){
				Truck truck=new Truck();
				truck.setTruckPk(rs.getInt("truck_pk"));
				truck.setTruckName(rs.getString("truck_name"));
				truck.setTruckOriginalImage(rs.getString("truck_original_image"));
				truck.setTruckRenameImage(rs.getString("truck_rename_image"));
				truck.setTrucklocation(rs.getString("truck_location"));
				truck.setTruckInfoName(rs.getString("truck_info_name"));
				truck.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				truck.setTruckContent(rs.getString("truck_content"));
				truck.setTruckStatus(rs.getString("truck_status"));
				truck.setTruckOpenTime(rs.getDate("truck_open_time"));
				truck.setTruckCloseTime(rs.getDate("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckStar(rs.getInt("truck_star"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				list.add(truck);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return list;
		}





	public List<Truck> selectByReviewList(Connection conn) {
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectByReviewList"));
			rs=pstmp.executeQuery();
			while(rs.next()){
				Truck truck=new Truck();
				truck.setTruckPk(rs.getInt("truck_pk"));
				truck.setTruckName(rs.getString("truck_name"));
				truck.setTruckOriginalImage(rs.getString("truck_original_image"));
				truck.setTruckRenameImage(rs.getString("truck_rename_image"));
				truck.setTrucklocation(rs.getString("truck_location"));
				truck.setTruckInfoName(rs.getString("truck_info_name"));
				truck.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				truck.setTruckContent(rs.getString("truck_content"));
				truck.setTruckStatus(rs.getString("truck_status"));
				truck.setTruckOpenTime(rs.getDate("truck_open_time"));
				truck.setTruckCloseTime(rs.getDate("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckStar(rs.getInt("truck_star"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				list.add(truck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return list;
		}





	public Truck selectOne(Connection conn, int truckPk) {
		Truck truck =null;
		try {
			truck =new Truck();
			pstmp=conn.prepareStatement(prop.getProperty("selectOne"));
			pstmp.setInt(1, truckPk);
			rs=pstmp.executeQuery();
			while(rs.next()){
				truck.setTruckPk(rs.getInt("truck_pk"));
				truck.setTruckName(rs.getString("truck_name"));
				truck.setTruckOriginalImage(rs.getString("truck_original_image"));
				truck.setTruckRenameImage(rs.getString("truck_rename_image"));
				truck.setTrucklocation(rs.getString("truck_location"));
				truck.setTruckInfoName(rs.getString("truck_info_name"));
				truck.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				truck.setTruckContent(rs.getString("truck_content"));
				truck.setTruckStatus(rs.getString("truck_status"));
				truck.setTruckOpenTime(rs.getDate("truck_open_time"));
				truck.setTruckCloseTime(rs.getDate("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckStar(rs.getInt("truck_star"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return truck;
	}



	public List<TruckMenu> selectMenuList(Connection conn, int truckPk) {
		List<TruckMenu> list=new ArrayList();
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectMenuList"));
			pstmp.setInt(1, truckPk);
			rs=pstmp.executeQuery();
			while(rs.next()){
				TruckMenu menu=new TruckMenu();
				menu.setMenuPk(rs.getInt("menu_pk"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getInt("menu_price"));
				menu.setMenuOimage(rs.getString("menu_oimage"));
				menu.setMenuRimage(rs.getString("menu_rimage"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}return list;
	}
	//









	public List<TruckReviewComment> selectReviewCommnetList(Connection conn, int truckPk) {
		List<TruckReviewComment> list=new ArrayList();
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectReviewCommnetList"));
			pstmp.setInt(1, truckPk);
			rs=pstmp.executeQuery();
			while(rs.next()){
				TruckReviewComment comment=new TruckReviewComment();
				comment.setReviewCommentPk(rs.getInt("review_comment_pk"));
				comment.setReviewCommentLevel(rs.getInt("review_comment_level"));
				comment.setReviewCommnetWriter(rs.getString("review_comment_writer"));
				comment.setReviewCommnetContent(rs.getString("review_comment_content"));
				comment.setReviewRef(rs.getInt("review_ref"));
				comment.setReviewCommentRef(rs.getInt("review_comment_ref"));
				comment.setReivewCommentDate(rs.getDate("review_comment_date"));
				comment.setReviewCommentOimage(rs.getString("review_comment_oimage"));
				comment.setReviewCommentRimage(rs.getString("review_comment_rimage"));
				comment.setReviewStar(rs.getInt("review_star"));
				comment.setMemberPk(rs.getInt("member_Pk"));
				comment.setTruckPk(rs.getInt("truck_pk"));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}return list;
	}





	public int insertTruckComment(Connection conn, TruckReviewComment comment) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("insertTruckComment"));
			pstmp.setInt(1, comment.getReviewCommentLevel());
			pstmp.setString(2, comment.getReviewCommnetWriter());
			pstmp.setString(3, comment.getReviewCommnetContent());
			pstmp.setString(4, comment.getReviewCommentOimage());
			pstmp.setString(5, comment.getReviewCommentRimage());
			pstmp.setDouble(6, comment.getReviewStar());
			pstmp.setInt(7, comment.getMemberPk());
			pstmp.setInt(8, comment.getTruckPk());
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		
		return result;
	}






	public int deleteTruckComment(Connection conn, int reviewCommentPk) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("deleteTruckComment"));
			pstmp.setInt(1, reviewCommentPk);
			result=pstmp.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}

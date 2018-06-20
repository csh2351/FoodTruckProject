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
	private PreparedStatement pstmp1;
	private ResultSet rs1;
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
	
	
	
	

	public List<Truck> selectAllList(Connection conn) {
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				int truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				int truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				int truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				int truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
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
			int truckpk =0;
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
			}
			pstmp1=conn.prepareStatement(prop.getProperty("updateTruckStar"));
			pstmp1.setInt(1,truck.getTruckStar());
			pstmp1.setInt(2,	 truckpk);
			int result =pstmp1.executeUpdate();
			if(result>0) {
				System.out.println("Truck_Star 업데이트 성공 : ");
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





	public Truck selectOneManageStore(Connection conn, int memberPk) {
		Truck truck =null;
		try {
			truck =new Truck();
			pstmp=conn.prepareStatement(prop.getProperty("selectOneManageStore"));
			pstmp.setInt(1, memberPk);
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
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





	public int updateTruckStatus(Connection conn, String truckStatus, int truckPk) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("updateTruckStatus"));
			pstmp.setString(1, truckStatus);
			pstmp.setInt(2, truckPk);
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}





	public int updateTruck(Connection conn, Truck truck) {
		
		int result =0;
		try {
			pstmp = conn.prepareStatement(prop.getProperty("updateTruck"));
			pstmp.setInt(1, truck.getTruckPk());
			pstmp.setString(2, truck.getTruckName());
			pstmp.setString(3, truck.getTruckOriginalImage());
			pstmp.setString(4, truck.getTruckRenameImage());
			pstmp.setString(5, truck.getTrucklocation());
			pstmp.setString(6, truck.getTruckContent());
			pstmp.setString(7, truck.getTruckStatus());
			pstmp.setTimestamp(8, truck.getTruckOpenTime());
			pstmp.setTimestamp(9, truck.getTruckCloseTime());
			pstmp.setDouble(10, truck.getLatitude());
			pstmp.setDouble(11, truck.getLogitude());
			pstmp.setInt(12,truck.getTruckPrice());
			pstmp.setString(13, truck.getTruckHoliday());
			pstmp.setInt(14, truck.getTruckPk());
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}





	public Truck manageTruck(Connection conn, int memberPk) {
			Truck truck = null;

		try {
			truck =new Truck();
			pstmp=conn.prepareStatement(prop.getProperty("manageTruck"));
			pstmp.setInt(1, memberPk);
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckCategory(rs.getString("truck_category"));
				pstmp1=conn.prepareStatement(prop.getProperty("selectTruckStar"));
				int truckpk = rs.getInt("truck_pk");
				pstmp1.setInt(1, truckpk);
				rs1=pstmp1.executeQuery();
				while(rs1.next()) {
					truck.setTruckStar(rs1.getInt("star"));
				}
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return truck;
	}





	public int UpdateTruckMenu(Connection conn, TruckMenu menu) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("UpdateTruckMenu"));
			pstmp.setString(1, menu.getMenuName());
			pstmp.setInt(2, menu.getMenuPrice());
			pstmp.setString(3, menu.getMenuOimage());
			pstmp.setString(4, menu.getMenuRimage());
			pstmp.setInt(5, menu.getMenuPk());
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}





	public int insertTruckMenu(Connection conn, TruckMenu menu) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("InsertTruckMenu"));
			pstmp.setString(1, menu.getMenuName());
			pstmp.setInt(2, menu.getMenuPrice());
			pstmp.setString(3, menu.getMenuOimage());
			pstmp.setString(4, menu.getMenuRimage());
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}





	public int selectOneMenuPk(Connection conn, String menuRimage) {
		int menuPk=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectOneMenuPk"));
			pstmp.setString(1, menuRimage);
			rs=pstmp.executeQuery();
			if(rs.next()){
				menuPk=rs.getInt("menu_pk");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return menuPk;
	}





	public int insertTruckMenuForeign(Connection conn, int menuPk, int truckPk) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("insertTruckMenuForeign"));
			pstmp.setInt(1, truckPk);
			pstmp.setInt(2, menuPk);
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}





	public int deleteTruckMenu(Connection conn, int menuPk) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("deleteTruckMenu"));
			pstmp.setInt(1, menuPk);
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}





	public int insertTruckReviewComment(Connection conn, TruckReviewComment comment) {
		int result=0;
		try {
			pstmp=conn.prepareStatement(prop.getProperty("insertTruckReviewComment"));
			//INSERT INTO REVIEW_COMMENT VALUES(REVIEW_COMMENT_SEQ.NEXTVAL, 2,?,?,NULL,?,DEFAULT,NULL,NULL,0,?,?);
			pstmp.setInt(1, comment.getReviewCommentLevel());
			pstmp.setString(2, comment.getReviewCommnetWriter());
			pstmp.setString(3, comment.getReviewCommnetContent());
			pstmp.setInt(4, comment.getReviewCommentRef());
			pstmp.setInt(5, comment.getMemberPk());
			pstmp.setInt(6, comment.getTruckPk());
			result=pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmp);
		}
		return result;
	}
	
	public List<Truck> selectTruckName(Connection conn, String searchType, String searchName){
		try {
			if(searchType.equals("location")) {
				pstmp=conn.prepareStatement(prop.getProperty("selectLocation"));
			}else {
				pstmp=conn.prepareStatement(prop.getProperty("selectName"));
			}

			pstmp.setString(1, "%"+searchName+"%");
			rs=pstmp.executeQuery();
			while(rs.next()) {
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
				truck.setTruckOpenTime(rs.getTimestamp("truck_open_time"));
				truck.setTruckCloseTime(rs.getTimestamp("truck_close_time"));
				truck.setTruckApprove(rs.getString("truck_approve"));
				truck.setLatitude(rs.getDouble("truck_latitude"));
				truck.setLogitude(rs.getDouble("truck_logitude"));
				truck.setTruckStar(rs.getInt("truck_star"));
				truck.setTruckPrice(rs.getInt("truck_price"));
				truck.setTruckCategory(rs.getString("truck_category"));
				truck.setTruckHoliday(rs.getString("truck_holiday"));
				truck.setMemberPk(rs.getInt("member_pk"));
				truck.setReviewCount(rs.getInt("count"));
				list.add(truck);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmp);
		}
		return list;
		
	}

	
	

}

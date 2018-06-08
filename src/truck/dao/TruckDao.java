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
				truck.setTruckgeolacation(rs.getString("truck_geoloaction"));
				truck.setTruckgeolacation(rs.getString("truck_category"));
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
				//구현~
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
				//구현~
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}





	public List<Truck> selectByReviewList(Connection conn) {
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectByReviewList"));
			rs=pstmp.executeQuery();
			while(rs.next()){
				Truck truck=new Truck();
				//구현~
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
	

}

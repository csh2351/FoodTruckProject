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

import member.model.dao.MemberDao;
import truck.vo.Truck;

public class TruckDao {
	private PreparedStatement pstmp;
	private Properties prop;
	
	public TruckDao() {
		pstmp=null;
		prop=new Properties();
		String fileName=MemberDao.class.getResource("/sql/truck/truck-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	public List<Truck> selectAllLitst(Connection conn) {
		ResultSet rs=null;
		List<Truck> list=new ArrayList<>();
		try {
			pstmp=conn.prepareStatement(prop.getProperty("selectAllList"));
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





	public List<Truck> selectList(Connection conn, String select_sort) {ResultSet rs=null;
	List<Truck> list=new ArrayList<>();
	try {
		pstmp=conn.prepareStatement(prop.getProperty("selectList"));
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





	public List<Truck> selectBygradeList(Connection conn, String selectSort) {
		// TODO Auto-generated method stub
		return null;
	}





	public List<Truck> selectByonOffList(Connection conn, String selectSort) {
		// TODO Auto-generated method stub
		return null;
	}





	public List<Truck> selectByReviewList(Connection conn, String selectSort) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

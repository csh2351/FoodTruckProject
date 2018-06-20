package adminStoreManagement.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import adminOne.model.dao.AdminOneDao;
import customerStoreSignup.model.vo.Signup;

public class AdminStoreManagementDao {

private Properties prop=new Properties();
	
	public AdminStoreManagementDao() {
		try {
			String fileName=AdminOneDao.class.getResource("/sql/admin/adminStoreEnroll-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	
	public List<Signup> selectApproveList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		ArrayList <Signup> signupList = new ArrayList<>();
		Signup signup = null;
		String sql=prop.getProperty("selectApproveList");
	
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "2");
			pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			pstmt.setInt(3, cPage*numPerPage);
			
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				signup=new Signup();
				signup.setTruckPk(rs.getInt("truck_pk"));
				signup.setMemberPk(rs.getInt("member_pk"));
				signup.setTruckName(rs.getString("truck_name"));
				signup.setTruckInfoName(rs.getString("truck_info_name"));
				signup.setTruckApprove(rs.getString("truck_Approve"));
				signupList.add(signup);
			}
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return signupList;
	}
	
	public int selectApproveCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectApproveCount");
		String level="2";
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, level);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
}

package adminStoreEnroll.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import adminOne.model.dao.AdminOneDao;
import customerStoreSignup.model.vo.Signup;


public class AdminStoreEnrollDao {
	
	private Properties prop=new Properties();
	
	public AdminStoreEnrollDao() {
		try {
			String fileName=AdminOneDao.class.getResource("/sql/admin/adminStoreEnroll-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public List<Signup> selectList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		ArrayList <Signup> signupList = new ArrayList<>();
		Signup signup = null;
		String sql=prop.getProperty("selectList");
	
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				signup=new Signup();
				signup.setTruckPk(rs.getInt("truck_pk"));
				signup.setMemberPk(rs.getInt("member_pk"));
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
	
	public String selectId(Connection conn,int memberPk) {
PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		String memberId="";
		String sql=prop.getProperty("selectId");
	
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberPk);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				memberId=rs.getString("member_id");
			}
				
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return memberId;
		
	}
	
	
	public int selectCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectCount");
		int result=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
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
	
	public Signup selectOne(Connection conn,int memberPk) {
	
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectTruckPk");
		String sql2=prop.getProperty("selectId");
		Signup signup = new Signup();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberPk);
			rs=pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				
				
				signup.setTruckLocation(rs.getString("truck_location"));
				signup.setTruckInfoName(rs.getString("truck_info_name"));
				signup.setTruckInfoRegisterNumber(rs.getInt("truck_info_register_number"));
				signup.setMemberPk(rs.getInt("member_pk"));
				signup.setTruckApprove(rs.getString("truck_approve"));
				
				
				
			}
			
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, memberPk);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				signup.setMemberId(rs.getString("member_id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return signup;
	}
}

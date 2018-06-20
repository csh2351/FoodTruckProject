package customerStoreSignup.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import customerStoreSignup.model.vo.Signup;




public class SignupDao {
	
	private Properties prop=new Properties();
	
	
	public SignupDao() {
		try {
			String fileName=SignupDao.class.getResource("/sql/customer/customerSignup-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	
	public int insertSignup(Connection conn,Signup signup) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertSignup");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, signup.getTruckInfoName());
			pstmt.setString(2, signup.getTruckLocation());
			pstmt.setString(3, signup.getTruckInfoName());
			pstmt.setInt(4, signup.getTruckInfoRegisterNumber());
			pstmt.setInt(5, signup.getMemberPk());
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

}


package mypageInfoChange.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class UpdateDao {
	private Properties prop=new Properties();

	public UpdateDao() {
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int updateMember(Connection conn, Member m)
	{
		
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";

		try
		{
			sql=prop.getProperty("update");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getMemberPhone());
			pstmt.setString(4, m.getMemberEmail());
			pstmt.setString(5, m.getMemberAddress());
			pstmt.setString(6, m.getMemberId());			
			//수정이기때문에 executeUpdate()사용
			result=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;	
		
	}
	
	public boolean memberPwCheck(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="";
		boolean result = false;
	
		try {
			sql=prop.getProperty("selectPw");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String s = rs.getString("member_pw");
				if(s.equals(memberPw)) {
					result = true;
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
}

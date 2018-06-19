package mypageMemberDelete.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MypageDeleteDao {
	
	private Properties prop=new Properties();

	public MypageDeleteDao() {
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int checkPw(Connection conn, String memberId)
	{
		boolean flag=false;
		PreparedStatement pstmt=null;
		int result=0;
		
		String sql=prop.getProperty("checkPw");
		System.out.println(sql);
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
	
			close(pstmt);
		}
		return result;
	}
	
	public String selectPw(Connection conn, String memberId) {
		PreparedStatement pstmt=null;
		String s = null;
		ResultSet rs=null;
		String sql="";
		try
		{
			sql=prop.getProperty("selectPw");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
			   s= rs.getString("member_pw");
			
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs);
			close(pstmt);
		}
		return s;
		
	}

}

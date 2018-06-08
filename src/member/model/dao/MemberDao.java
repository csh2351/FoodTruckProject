package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDao {
	
	private Properties prop=new Properties();

	public MemberDao() {
		try {
			String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public int loginCheck(Connection conn, String id, String pw)
	{
		int result=-1;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try {
			
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("member_id").equals(id)
						&&rs.getString("member_pw").equals(pw))
					return 1;
				else if(rs.getString("member_id").equals(id))
				{
					return 0;
				}	
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
		return result;
	}
	
	public Member selectOne(Connection conn, String id)
	{
		PreparedStatement pstmt=null;
		Member member=null;
		ResultSet rs=null;
		String sql="";
		try
		{
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				member=new Member();
				member.setMemberPk(rs.getInt("member_pk"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberAddress(rs.getString("member_address"));
				member.setMemberLevel(rs.getInt("member_level"));
							
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
		return member;
	}

}

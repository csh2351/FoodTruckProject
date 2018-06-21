package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	
	public int loginCheck(Connection conn, String memberId, String memberPw)
	{
		int result=-1;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try {
			
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("member_id").equals(memberId)
						&&rs.getString("member_pw").equals(memberPw))
					return 1;
				else if(rs.getString("member_id").equals(memberId))
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
	
	public Member selectOne(Connection conn, String memberId)
	{
		PreparedStatement pstmt=null;
		Member member=null;
		ResultSet rs=null;
		String sql="";
		try
		{
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
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
				member.setMemberLevel(rs.getString("member_level"));
							
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

	public int insertMember(Connection conn, Member member)
	{
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insert"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public boolean duplicateId(Connection conn, String memberId)
	   {
	      boolean flag=false;
	      PreparedStatement pstmt=null;
	      ResultSet rs = null;
	      int cnt=0;
	      String sql=prop.getProperty("checkIdDuplicate");
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, memberId);
	         rs=pstmt.executeQuery();
	         
	         if(rs.next())
	         {
	            cnt=rs.getInt("cnt");
	         }
	         if(cnt==0)
	         {
	            flag=true;
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally
	      {
	         close(rs);
	         close(pstmt);
	      }
	      return flag;   
	   }
	
	public int updateLevel(Connection conn, int memberPk) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";
		try
		{
			sql=prop.getProperty("updateLevel");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberPk);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally
		{
			close(pstmt);
		}
		return result;	
	}
	
	public int updateApprove(Connection conn, int memberPk) {
		PreparedStatement pstmt=null;
		int result2=0;
		String sql="";
		try
		{
			sql=prop.getProperty("updateApprove");
			//System.out.println(sql);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberPk);
			
			result2=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally
		{
			close(pstmt);
		}
		
		return result2;
	}
	
	public int refuseApprove(Connection conn, int memberPk) {
		PreparedStatement pstmt=null;
		int result2=0;
		String sql="";
		try
		{
			sql=prop.getProperty("refuseApprove");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, memberPk);
			
			result2=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally
		{
			close(pstmt);
		}
		
		return result2;
	}
	
	public boolean emailCheck(Connection conn, String memberEmail) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean check=false;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("emailCheck"));
			pstmt.setString(1, memberEmail);
			rs=pstmt.executeQuery();
			//중복값 존재
			if(rs.next()) {
				check=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}
	

	public List<Member> selectAllList(Connection conn, int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Member> memberList=new ArrayList<>();
		Member member=null;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectMemberList"));
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				member=new Member();
				member.setMemberPk(rs.getInt("member_pk"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberAddress(rs.getString("member_address"));
				member.setMemberLevel(rs.getString("member_level"));
				memberList.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}
	
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectMemberCount");
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
	
	public Member selectOnePk(Connection conn,String memberPk) {
		PreparedStatement pstmt=null;
		Member member=null;
		ResultSet rs=null;
		
		try
		{
			pstmt=conn.prepareStatement(prop.getProperty("selectOnePk"));
			pstmt.setString(1, memberPk);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				member=new Member();
				member.setMemberPk(rs.getInt("member_pk"));
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberEmail(rs.getString("member_email"));
				member.setMemberAddress(rs.getString("member_address"));
				member.setMemberLevel(rs.getString("member_level"));
							
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

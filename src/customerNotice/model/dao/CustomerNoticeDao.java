package customerNotice.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static common.JDBCTemplate.*;
import customerNotice.model.vo.Notice;

public class CustomerNoticeDao {
	private Properties prop=new Properties();
	
	public CustomerNoticeDao() {
		
		try {
			String fileName=CustomerNoticeDao.class.getResource("/sql/customer/customer-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	//공지사항 배열에 담아 가져오기
	public List<Notice> selectList(Connection conn,int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ArrayList<Notice> noticeList=new ArrayList<>();
		ResultSet rs=null;
	
		String sql=prop.getProperty("selectList");
		Notice notice=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				notice=new Notice();
				notice.setNoticePk(rs.getInt("notice_pk"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
				String s=rs.getString("notice_date");
				String noticeDate=s.substring(0, 19);
				notice.setNoticeDate(noticeDate);
				
				noticeList.add(notice);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return noticeList;
	}
	//공지사항 row수 가져오기
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
	//공지사항 등록
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return result;
	}
	
	//Pk에 따른 공지사항 가져오기
	public Notice selectOne(Connection conn, int noticePk) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectOne");
		Notice notice=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticePk);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				notice=new Notice();
				notice.setNoticePk(rs.getInt("notice_pk"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
				String s=rs.getString("notice_date");
				String noticeDate=s.substring(0, 19);
				notice.setNoticeDate(noticeDate);
			}
				
			
		}catch(Exception e) {
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return notice;
	}
	
	
	//공지사항 갱신
	public int updateNotice(Connection conn, int noticePk, String noticeTitle, String noticeContent) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, noticeTitle);
			pstmt.setString(2, noticeContent);
			pstmt.setInt(3, noticePk);
			
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticePk) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticePk);
			
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}

package adminOne.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mypageQuestion.model.vo.Qna;

import static common.JDBCTemplate.*;


public class AdminOneDao {
	private Properties prop=new Properties();
	
	public AdminOneDao() {
		try {
			String fileName=AdminOneDao.class.getResource("/sql/admin/adminOne-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}
	
	
	
	
	
	public List<Qna> selectQNAList(Connection conn, int cPage, int numPerPage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectQNAList");
		
		ArrayList<Qna> qnaList=new ArrayList<>();
		Qna qna=null;
		
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				qna=new Qna();
				qna.setQnaPk(rs.getInt("qna_pk"));
				qna.setQnaTitle(rs.getString("qna_title"));
				qna.setQnaContent(rs.getString("qna_content"));
				qna.setAnswerTitle(rs.getString("qna_answer_title"));
				qna.setAnswerContent(rs.getString("qna_answer_content"));
				String s=rs.getString("qna_answer_date");
				if(s!=null) {
				String qnaAnswerDate=s.substring(0, 19);
				qna.setQnaAnswerDate(qnaAnswerDate);
				}
				String s1=rs.getString("qna_date");
				String qnaDate=s1.substring(0, 19);
				qna.setQnaDate(qnaDate);
				qna.setQnaWriter(rs.getString("qna_writer"));
				qna.setQnaAnswerCheck(rs.getString("qna_answer_check"));
				qnaList.add(qna);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return qnaList;
	}
	
	
	public int selectQNACount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectQNACount");
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
	
	public Qna selectOne(Connection conn,int qnaPk) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectOne");
		Qna qna=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, qnaPk);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			qna=new Qna();
			qna.setQnaPk(rs.getInt("qna_pk"));
			qna.setQnaTitle(rs.getString("qna_title"));
			qna.setQnaContent(rs.getString("qna_content"));
			qna.setAnswerTitle(rs.getString("qna_answer_title"));
			qna.setAnswerContent(rs.getString("qna_answer_content"));
			String s=rs.getString("qna_answer_date");
			if(s!=null) {
			String qnaAnswerDate=s.substring(0, 19);
			qna.setQnaAnswerDate(qnaAnswerDate);
			}
			String s1=rs.getString("qna_date");
			String qnaDate=s1.substring(0, 19);
			qna.setQnaDate(qnaDate);
			qna.setQnaWriter(rs.getString("qna_writer"));
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return qna;
		
	}
	
	public int updateAnswer(Connection conn, int qnaPk, String answerTitle, String answerContent) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateAnswer");
		String qnaAnswerCheck="답변완료";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, answerTitle);
			pstmt.setString(2, answerContent);
			pstmt.setString(3, qnaAnswerCheck);
			pstmt.setInt(4, qnaPk);
			
			result=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}

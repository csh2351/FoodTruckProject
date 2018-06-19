package adminOne.model.service;

import static common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

import adminOne.model.dao.AdminOneDao;
import common.JDBCTemplate;
import customerNotice.model.dao.CustomerNoticeDao;
import customerNotice.model.vo.Notice;
import mypageQuestion.model.vo.Qna;

public class AdminOneService {

	
	public List<Qna> selectQNAList(int cPage,int numPerPage){
		
		Connection conn=getConnection();
		List<Qna> qnaList=new AdminOneDao().selectQNAList(conn, cPage,numPerPage);
		close(conn);
		return qnaList;
		
	}
	
	public int selectQNACount() {
		Connection conn=getConnection();
		int result=new AdminOneDao().selectQNACount(conn);
		close(conn);
		return result;
	}
	
	public Qna selectOne(int qnaPk) {
		Connection conn=getConnection();
		Qna qna=new AdminOneDao().selectOne(conn,qnaPk);
		close(conn);
		return qna;
	}
	
	public int updateAnswer(int qnaPk, String answerTitle, String answerContent) {
		Connection conn=getConnection();
		int result=new AdminOneDao().updateAnswer(conn,qnaPk,answerTitle,answerContent);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;

	}
}

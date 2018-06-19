package mypageQuestion.model.service;

import java.sql.Connection;
import java.util.List;

import customerNotice.model.dao.CustomerNoticeDao;
import customerNotice.model.vo.Notice;

import static common.JDBCTemplate.*;

import mypageQuestion.model.dao.MypageQuestionDao;
import mypageQuestion.model.vo.Qna;

public class MypageQuestionService {
	public int insertQna(Qna qna) {
		Connection conn=getConnection();
		int result=new MypageQuestionDao().insertQna(conn,qna);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	public List<Qna> selectList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Qna> qnaList=new MypageQuestionDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return qnaList;
	}
	
	
	public int selectCount() {
		Connection conn=getConnection();
		int result=new MypageQuestionDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public Qna selectOne(int qnaPk){
		Connection conn=getConnection();
		Qna qna=new MypageQuestionDao().selectOne(conn,qnaPk);
		close(conn);
		return qna;
	}
}

package customerNotice.model.service;

import java.sql.Connection;
import java.util.List;

import static common.JDBCTemplate.*;

import customerNotice.model.dao.CustomerNoticeDao;
import customerNotice.model.vo.Notice;

public class CustomerNoticeService {
	public List<Notice> selectList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Notice> noticeList=new CustomerNoticeDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return noticeList;
	}
	
	
	public int selectCount() {
		Connection conn=getConnection();
		int result=new CustomerNoticeDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public int insertNotice(Notice notice) {
		Connection conn=getConnection();
		int result= new CustomerNoticeDao().insertNotice(conn,notice);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		
	}
	
	public Notice selectOne(int noticePk) {
		Connection conn=getConnection();
		Notice notice=new CustomerNoticeDao().selectOne(conn,noticePk);
		close(conn);
		return notice;
	}
	
	public int updateNotice(int noticePk, String noticeTitle, String noticeContent) {
		Connection conn=getConnection();
		int result= new CustomerNoticeDao().updateNotice(conn,noticePk, noticeTitle, noticeContent);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
	
	public int deleteNotice(int noticePk) {
		Connection conn=getConnection();
		int result= new CustomerNoticeDao().deleteNotice(conn,noticePk);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
}

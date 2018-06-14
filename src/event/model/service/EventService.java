package event.model.service;

import java.sql.Connection;
import java.util.List;

import static common.JDBCTemplate.*;

import event.model.dao.EventDao;
import event.model.vo.Event;

public class EventService {

	public List<Event> selectList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Event> eventList=new EventDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return eventList;
	}
	
	
	public int selectCount() {
		Connection conn=getConnection();
		int result=new EventDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public int insertEvent(Event event) {
		Connection conn=getConnection();
		int result= new EventDao().insertEvent(conn, event);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		
	}
	
	public Event selectOne(int eventPk) {
		Connection conn=getConnection();
		Event notice=new EventDao().selectOne(conn, eventPk);
		close(conn);
		return notice;
	}
	
	public int updateEvent(int eventPk, String eventTitle, String evnetContent) {
		Connection conn=getConnection();
		int result= new EventDao().updateEvent(conn,eventPk, eventTitle, evnetContent);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
	
	public int deleteEvent(int eventPk) {
		Connection conn=getConnection();
		int result= new EventDao().deleteEvent(conn, eventPk);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
}

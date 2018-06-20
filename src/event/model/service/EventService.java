package event.model.service;

import java.sql.Connection;
import java.util.List;

import event.model.dao.EventDao;
import event.model.vo.Event;

import static common.JDBCTemplate.*;



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
	
	public int insertEvent(Event event, boolean check) {
		Connection conn=getConnection();
		int result= new EventDao().insertEvent(conn, event, check);
			
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
	
	public int updateEvent(Event event, boolean check) {
		Connection conn=getConnection();
		int result= new EventDao().updateEvent(conn,event,check);
			
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
	
	public List<Event> selectOneList(int cPage, int numPerPage,int truckPk){
	      Connection conn=getConnection();
	      List<Event> eventList=new EventDao().selectOneList(conn,cPage,numPerPage,truckPk);
	      close(conn);
	      return eventList;
	   }
	
	public int selectOneCount(int truckPk) {
	      Connection conn=getConnection();
	      int result=new EventDao().selectOneCount(conn,truckPk);
	      close(conn);
	      return result;
	   }
}

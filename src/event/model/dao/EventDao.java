package event.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import event.model.vo.Event;

import static common.JDBCTemplate.*;

public class EventDao {
	
	private Properties prop=new Properties();
	
	public EventDao() {
		
		try 
		{
			String fileName=EventDao.class.getResource("/sql/event/event-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch (Exception e) 
		{			
			e.printStackTrace();
		} 
	}
	

	public List<Event> selectList(Connection conn,int cPage, int numPerPage) {
		PreparedStatement pstmt = null;
		ArrayList<Event> eventList = new ArrayList<>();
		ResultSet rs = null;
	
		String sql = prop.getProperty("selectList");
		Event event = null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				event = new Event();
				event.setEventPk(rs.getInt("event_pk"));
				event.setEventTitle(rs.getString("event_title"));
				event.setEventDate(rs.getDate("event_date"));
				event.setEventContent(rs.getString("event_content"));	
				event.setOriginalFileName(rs.getString("event_original_image"));
				event.setRenameFileName(rs.getString("event_rename_image"));
				event.setTruckPk(rs.getInt("truck_pk"));
				event.setEventEndDate(rs.getDate("event_enddate"));
	
				eventList.add(event);
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
		return eventList;
	}
	
	public int selectCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectCount");
		int result=0;
		try
		{
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				result=rs.getInt("cnt");
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
		
	public int insertEvent(Connection conn, Event event,boolean check)
	{
		PreparedStatement pstmt=null;
		int result=0;
		
		try
		{
			if(check==true) {
				pstmt=conn.prepareStatement(prop.getProperty("insertEvent1"));
			}else {
				pstmt=conn.prepareStatement(prop.getProperty("insertEvent2"));
				pstmt.setInt(7, event.getTruckPk());
			}
			
			pstmt.setString(1, event.getEventTitle());
			pstmt.setDate(2, event.getEventDate());
			pstmt.setString(3, event.getEventContent());
			pstmt.setString(4, event.getOriginalFileName());
			pstmt.setString(5, event.getRenameFileName());
			pstmt.setDate(6, event.getEventEndDate());
			
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
	
	public Event selectOne(Connection conn, int eventPk)
	{
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectOne");
		Event event=null;
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, eventPk);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				event = new Event();
				
				event.setEventPk(rs.getInt("event_pk"));
				event.setEventTitle(rs.getString("event_title"));
				event.setEventDate(rs.getDate("event_date"));
				event.setEventContent(rs.getString("event_content"));	
				event.setOriginalFileName(rs.getString("event_original_image"));
				event.setRenameFileName(rs.getString("event_rename_image"));
				event.setTruckPk(rs.getInt("truck_pk"));
				event.setEventEndDate(rs.getDate("event_enddate"));
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
		return event;
	}
		
	public int updateEvent(Connection conn, Event event) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("updateEvent");
		try
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setDate(3, event.getEventDate());
			pstmt.setDate(4, event.getEventEndDate());
			pstmt.setString(5, event.getOriginalFileName());
			pstmt.setString(6, event.getRenameFileName());
			pstmt.setInt(7, event.getTruckPk());
			pstmt.setInt(8, event.getEventPk());
			
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
	
	public int deleteEvent(Connection conn, int eventPk) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("deleteEvent");		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, eventPk);
			
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
	
	   public List<Event> selectOneList(Connection conn, int cPage, int numPerPage, int truckPk) {
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      List<Event>list=new ArrayList<>();
		      try {
		         pstmt=conn.prepareStatement(prop.getProperty("selectOneList"));
		         pstmt.setInt(1, ((cPage-1)*numPerPage+1));
		         pstmt.setInt(2, cPage*numPerPage);
		         pstmt.setInt(3, truckPk);
		         rs=pstmt.executeQuery();
		         while(rs.next()){
		            Event event=new Event();
		            event.setEventPk(rs.getInt("event_pk"));
		            event.setEventTitle(rs.getString("event_title"));
		            event.setEventDate(rs.getDate("event_date"));
		            event.setEventContent(rs.getString("event_content"));
		            event.setOriginalFileName(rs.getString("event_original_image"));
		            event.setRenameFileName(rs.getString("event_rename_image"));
		            event.setTruckPk(rs.getInt("truck_pk"));
		            list.add(event);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         close(rs);
		         close(pstmt);
		      }
		      return list;
		   }
	   
	   public int selectOneCount(Connection conn, int truckPk) {
       PreparedStatement pstmt=null;
       ResultSet rs=null;
       int result=0;
       String sql=prop.getProperty("selectOneCount");
       try
       {
          pstmt=conn.prepareStatement(sql);
          pstmt.setInt(1, truckPk);
          rs=pstmt.executeQuery();
          if(rs.next())
          {
             result=rs.getInt("cnt");
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
}
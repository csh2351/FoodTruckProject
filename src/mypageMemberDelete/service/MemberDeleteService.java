package mypageMemberDelete.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import mypageMemberDelete.model.dao.MypageDeleteDao;

public class MemberDeleteService {
	
	public int checkPw(String memberId)
	{
		Connection conn=getConnection();
		
		int result=new MypageDeleteDao().checkPw(conn,memberId);
		
		if(result>0)
		{
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public String selectPw(String memberId) {
	
		Connection conn=getConnection();
		String s=new MypageDeleteDao().selectPw(conn, memberId);
		close(conn);
		return s;
	}

}

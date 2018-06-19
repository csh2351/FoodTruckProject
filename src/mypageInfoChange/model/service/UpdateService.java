package mypageInfoChange.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import member.model.vo.Member;
import mypageInfoChange.model.dao.UpdateDao;

public class UpdateService {

	public int updateMember(Member m)
	{
		Connection conn=getConnection();
		
		int result=new UpdateDao().updateMember(conn, m);
		//이작업은 수정이죠! CRUD에 해당! 수정!이면 
		//성공시 commit / 실패시 rollback을 해줘야함.
		//구분은 결과가 1이상이면 commit이고 아니면 rollback
		if(result>0)
		{
			commit(conn);
		}
		else
		{
			rollback(conn);
			
		}
		close(conn);
		return result;
		
	}
	
	public boolean memberPwCheck(String memberId, String memberPw) {
		Connection conn=getConnection();
		
		boolean result = new UpdateDao().memberPwCheck(conn, memberId, memberPw);
		
		close(conn);
		return result;
		
	}

}

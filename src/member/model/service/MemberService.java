package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	
	public static int LOGIN_OK=1;
	public static int WRONG_PASSWORD=0;
	public static int ID_NOT_EXIST=-1;
	
	public int loginCheck(String userId, String password)
	{
		Connection conn=getConnection();
		int result=new MemberDao().loginCheck(conn,userId,password);
		
		close(conn);
		
		return result;
	}
	
	public Member selectOne(String id)
	{
		//1. DB와의 연결 객체를 생성 : connection
		//2. 데이터 CRUD(삽입, 수정, 삭제)가 
		//   발생한 경우 commit, rollback을 통제
		//3. 자신이 생성한 DB연결객체 반환 : connection
		//   **객체 삭제
		
		Connection conn=getConnection();
		Member m=new MemberDao().selectOne(conn, id);
		close(conn);
		return m;
	}

}

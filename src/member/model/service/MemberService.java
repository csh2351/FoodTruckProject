package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	
	public static int LOGIN_OK=1;
	public static int WRONG_PASSWORD=0;
	public static int ID_NOT_EXIST=-1;
	
	public int loginCheck(String memberId, String memberPw)
	{
		Connection conn=getConnection();
		int result=new MemberDao().loginCheck(conn,memberId,memberPw);
		
		close(conn);
		
		return result;
	}
	
	public Member selectOne(String memberId)
	{
		//1. DB와의 연결 객체를 생성 : connection
		//2. 데이터 CRUD(삽입, 수정, 삭제)가 
		//   발생한 경우 commit, rollback을 통제
		//3. 자신이 생성한 DB연결객체 반환 : connection
		//   **객체 삭제
		
		Connection conn=getConnection();
		Member m=new MemberDao().selectOne(conn, memberId);
		close(conn);
		return m;
	}
	
	public int insertMember(Member member)
	{
		Connection conn=getConnection();
		int result=new MemberDao().insertMember(conn, member);
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
	
	public boolean duplicateId(String memberId)
	   {
	      Connection conn=getConnection();
	      
	      boolean flag = new MemberDao().duplicateId(conn, memberId);
	      
	      close(conn);
	      
	      return flag;
	   }
	
	public int updateLevel(int memberPk) {
		Connection conn=getConnection();
		int result= new MemberDao().updateLevel(conn,memberPk);
				
		if(result>0) 
		{
			commit(conn);
			int result2 = new MemberDao().updateApprove(conn, memberPk);
			if(result2>0) {
				commit(conn);
			}
			else {
				rollback(conn);
			}
		}
		else
		{
			rollback(conn);
		}
		close(conn);
		
		return result;
	
	}
	
	public int refuseApprove(int memberPk) {
		Connection conn=getConnection();
		int result= new MemberDao().refuseApprove(conn,memberPk);
		
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
	
	public boolean emailCheck(String memberEmail) {
		 Connection conn=getConnection();
	      
	      boolean check = new MemberDao().emailCheck(conn, memberEmail);
	      
	      close(conn);
	      
	      return check;
	}
	
	public List<Member> selectAllList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Member> memberList=new MemberDao().selectAllList(conn,cPage,numPerPage);
		close(conn);
		return memberList;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int result=new MemberDao().selectMemberCount(conn);
		close(conn);
		return result;
	}
	
	public Member selectOnePk(String memberPk) {
		Connection conn=getConnection();
		Member member=new MemberDao().selectOnePk(conn,memberPk);
		close(conn);
		return member;
	}
	
	

}

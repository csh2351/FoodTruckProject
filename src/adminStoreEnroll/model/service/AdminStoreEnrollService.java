package adminStoreEnroll.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import adminStoreEnroll.model.dao.AdminStoreEnrollDao;
import customerStoreSignup.model.vo.Signup;


public class AdminStoreEnrollService {
	
	public List<Signup> selectList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Signup> signupList=new AdminStoreEnrollDao().selectList(conn,cPage,numPerPage);
		close(conn);
		return signupList;
	}
	
	
	public int selectCount() {
		Connection conn=getConnection();
		int result=new AdminStoreEnrollDao().selectCount(conn);
		close(conn);
		return result;
	}
	
	public Signup selectOne(int memberPk){
		Connection conn=getConnection();
		Signup signup=new AdminStoreEnrollDao().selectOne(conn,memberPk);
		close(conn);
		return signup;
	}
	
	public String selectId(int memberPk) {
		Connection conn=getConnection();
		String memberId=new AdminStoreEnrollDao().selectId(conn, memberPk);
		close(conn);
		return memberId;
	}


}

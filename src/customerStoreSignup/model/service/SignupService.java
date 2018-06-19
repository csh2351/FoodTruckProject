package customerStoreSignup.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import customerStoreSignup.model.dao.SignupDao;
import customerStoreSignup.model.vo.Signup;

public class SignupService {
	
	public int insertSignup(Signup signup) {
		Connection conn=getConnection();
		int result=new SignupDao().insertSignup(conn,signup);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}

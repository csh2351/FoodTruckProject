package adminStoreManagement.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import adminStoreEnroll.model.dao.AdminStoreEnrollDao;
import adminStoreManagement.model.dao.AdminStoreManagementDao;
import customerStoreSignup.model.vo.Signup;

public class AdminStoreManagementService {
	
	public List<Signup> selectApproveList(int cPage, int numPerPage){
		Connection conn=getConnection();
		List<Signup> signupList=new AdminStoreManagementDao().selectApproveList(conn, cPage, numPerPage);
		close(conn);
		return signupList;
	}

	
	public int selectApproveCount() {
		Connection conn=getConnection();
		int result=new AdminStoreManagementDao().selectApproveCount(conn);
		close(conn);
		return result;
	}

}
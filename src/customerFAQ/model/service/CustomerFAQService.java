package customerFAQ.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import customerFAQ.model.dao.CustomerFAQDao;
import customerFAQ.model.vo.CustomerFAQ;
import customerNotice.model.dao.CustomerNoticeDao;


public class CustomerFAQService {

	public List<CustomerFAQ> selectList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<CustomerFAQ> customerFAQList = new CustomerFAQDao().selectList(conn, cPage, numPerPage);
		close(conn);
		return customerFAQList;
	}

	public int selectCount() {
		Connection conn = getConnection();
		int result = new CustomerFAQDao().selectCount(conn);
		close(conn);
		return result;
	}

	public int insertCustomerFAQ(CustomerFAQ customerFAQ) {
		Connection conn = getConnection();
		int result = new CustomerFAQDao().insertCustomerFAQ(conn, customerFAQ);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public CustomerFAQ selectOne(int FAQPK) {
		Connection conn=getConnection();
		CustomerFAQ customerFAQ=new CustomerFAQDao().selectOne(conn,FAQPK);
		close(conn);
		return customerFAQ;
	}
	
	public int updateCustomerFAQ(int FAQPK, String FAQTitle, String FAQContent) {
		Connection conn=getConnection();
		int result= new CustomerFAQDao().updateCustomerFAQ(conn, FAQTitle, FAQContent, FAQPK);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}
	
	public int deleteCustomerFAQ(int FAQPK) {
		Connection conn=getConnection();
		int result= new CustomerFAQDao().deleteCustomerFAQ(conn,FAQPK);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
	}

}

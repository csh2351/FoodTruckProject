package customerFAQ.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import customerFAQ.model.vo.CustomerFAQ;
import customerNotice.model.dao.CustomerNoticeDao;
import customerNotice.model.vo.Notice;

public class CustomerFAQDao {
	
private Properties prop=new Properties();
	
	public CustomerFAQDao() {
		
		try {
			String fileName=CustomerFAQDao.class.getResource("/sql/customer/customerFAQ-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	
		public List<CustomerFAQ> selectList(Connection conn,int cPage, int numPerPage){
			PreparedStatement pstmt=null;
			ArrayList<CustomerFAQ> customerFAQList=new ArrayList<>();
			ResultSet rs=null;
		
			String sql=prop.getProperty("selectList");
			CustomerFAQ customerFAQ=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, ((cPage-1)*numPerPage+1));
				pstmt.setInt(2, cPage*numPerPage);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					customerFAQ=new CustomerFAQ();
					customerFAQ.setFAQPK(rs.getInt("faq_pk"));
					customerFAQ.setFAQTitle(rs.getString("faq_title"));
					customerFAQ.setFAQContent(rs.getString("faq_content"));
					String s=rs.getString("faq_date");
					String faqDate=s.substring(0, 19);
					customerFAQ.setFAQDate(faqDate);
					
					customerFAQList.add(customerFAQ);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return customerFAQList;
		}
		
		
		public int selectCount(Connection conn) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql=prop.getProperty("selectCount");
			int result=0;
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getInt("cnt");
				}				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}
		

		public int insertCustomerFAQ(Connection conn, CustomerFAQ customerFAQ) {
			PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("insertCustomerFAQ");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, customerFAQ.getFAQTitle());
				pstmt.setString(2, customerFAQ.getFAQContent());
				
				result=pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);				
			}
			return result;
		}
		
		
		public CustomerFAQ selectOne(Connection conn, int FAQPK) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql=prop.getProperty("selectOne");
			CustomerFAQ customerFAQ=null;
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, FAQPK);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					customerFAQ=new CustomerFAQ();
					customerFAQ.setFAQPK(rs.getInt("faq_pk"));
					customerFAQ.setFAQTitle(rs.getString("faq_title"));
					customerFAQ.setFAQContent(rs.getString("faq_content"));
					String s=rs.getString("faq_date");
					String faqDate=s.substring(0, 19);
					customerFAQ.setFAQDate(faqDate);
				}
							
			}catch(Exception e) {
				
			}finally {
				close(rs);
				close(pstmt);
			}
			return customerFAQ;
		}
		
		
		public int updateCustomerFAQ(Connection conn,String FAQTitle, String FAQContent, int FAQPK) {
			PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("updateCustomerFAQ");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, FAQTitle);
				pstmt.setString(2, FAQContent);
				pstmt.setInt(3, FAQPK);
				result=pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
		public int deleteCustomerFAQ(Connection conn, int FAQPK) {
			PreparedStatement pstmt=null;
			int result=0;
			String sql=prop.getProperty("deleteCustomerFAQ");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, FAQPK);
				
				result=pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
		
}

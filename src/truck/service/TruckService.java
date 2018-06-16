package truck.service;

import java.sql.Connection;
import java.util.List;

import truck.dao.TruckDao;
import truck.vo.Truck;
import truck.vo.TruckMenu;
import truck.vo.TruckReviewComment;

import static common.JDBCTemplate.*;

public class TruckService {
	private Connection conn;
	public TruckService() {
		conn=getConnection();
	}

	public List<Truck> selectAllLitst() {
		List<Truck> list=new TruckDao().selectAllLitst(conn);
		close(conn);
		return list;
	}
	
	public List<Truck> selectBygradeList() {
		List<Truck> list=new TruckDao().selectBygradeList(conn);
		close(conn);
		return list;
	}
	
	public List<Truck> selectByonOffList() {
		List<Truck> list=new TruckDao().selectByonOffList(conn);
		close(conn);
		return list;
	}
	
	public List<Truck> selectByReviewList() {	//truckReview로 바꾸기 매개변수
		List<Truck> list=new TruckDao().selectByReviewList(conn);
		close(conn);
		return list;
	}

	public Truck selectOne(int truckPk) {
		Truck truck = new TruckDao().selectOne(conn,truckPk);
		close(conn);
		return truck;
	}

	public List<TruckMenu> selectMenu(int truckPk) {	
		List<TruckMenu> list=new TruckDao().selectMenuList(conn,truckPk);
		close(conn);
		return list;
	}

	

	public List<TruckReviewComment> selectReviewCommnetList(int truckpk) {
		List<TruckReviewComment> list=new TruckDao().selectReviewCommnetList(conn,truckpk);
		close(conn);
		return list;
	}

	

	public int insertTruckComment(TruckReviewComment comment) {
		int result=new TruckDao().insertTruckComment(conn, comment);
		if(result>0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		return result;
	}

	

	public int deleteTruckComment(int reviewCommentPk) {
		int result=new TruckDao().deleteTruckComment(conn, reviewCommentPk);
		System.out.println("결과:"+result);
		if(result>0){
			commit(conn);
		}
		else{
			rollback(conn);
		}
		return result;
	}

	public Truck selectOneManageStore(int memberPk) {
		Truck truck = new TruckDao().selectOneManageStore(conn,memberPk);
		close(conn);
		return truck;
	}

}

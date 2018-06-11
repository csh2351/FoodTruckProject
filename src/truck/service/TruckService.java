package truck.service;

import java.sql.Connection;
import java.util.List;

import truck.dao.TruckDao;
import truck.vo.Truck;
import truck.vo.TruckMenu;

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

/*	public List<TruckReview> selectReview(int truckPk) {
		List<TruckReview> list = new TruckDao().selectReview(conn,truckPk);
		close(conn);
		return list;
	}*/

}

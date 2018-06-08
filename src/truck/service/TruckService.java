package truck.service;

import java.sql.Connection;
import java.util.List;

import truck.dao.TruckDao;
import truck.vo.Truck;
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
	
	public List<Truck> selectByReviewList() {
		List<Truck> list=new TruckDao().selectByReviewList(conn);
		close(conn);
		return list;
	}

}

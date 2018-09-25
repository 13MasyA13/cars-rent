package ua.holik.db.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import ua.holik.bl.OrdersBean;
import ua.holik.bl.users.UserBean;

public interface OrdersDBOperations {
	
	public ArrayList<OrdersBean> selectAllOrders();
	
	public OrdersBean selectOrderById(int id);
	
	public boolean insertNewOrder(OrdersBean order, UserBean user) throws SQLException;
	
	public boolean acceptOrderById(int id) throws SQLException;
	
	public boolean notAcceptOrderById(int id) throws SQLException;
	
	public boolean updateDescriptionById(int id, String desc) throws SQLException;
	
	public int getUserIdByOrderId(int id);
	
	public int getPriceByOrderId(int id);
}

package ua.holik.db.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import ua.holik.bl.users.ManagerBean;

public interface ManagerDBOperations {
	
	public ArrayList<ManagerBean> selectAllManagers() throws SQLException;
	
	public boolean insertNewManager(ManagerBean manager, ArrayList<String> logins) throws SQLException;
	
	public ArrayList<String> getAllManagersLogins();
	
	public boolean selectManagerLogPass(String login, String password);
}

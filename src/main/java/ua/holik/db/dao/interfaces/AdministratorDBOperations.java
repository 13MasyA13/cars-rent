package ua.holik.db.dao.interfaces;

public interface AdministratorDBOperations {
	
	public boolean selectAdminByLogPass(String login, String password);
}

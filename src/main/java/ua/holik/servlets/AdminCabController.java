package ua.holik.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ua.holik.bl.users.UserBean;
import ua.holik.db.dao.AbstractDAOFactory;
import ua.holik.db.dao.ManagerDAO;
import ua.holik.db.dao.MySqlDAOFactory;
import ua.holik.db.dao.UserDAO;

/**
 * Servlet implementation class UsersListController
 */
@WebServlet(urlPatterns = {"/AdminOffice"})
public class AdminCabController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger LOG = Logger.getLogger(AdminCabController.class);
	
	static { PropertyConfigurator.configure("D:\\log4j.properties");}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCabController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AbstractDAOFactory factory = MySqlDAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		ManagerDAO managerDAO = factory.getManagerDAO();
		ArrayList<String> logins = managerDAO.getAllManagersLogins();
		ArrayList<UserBean> userList = userDAO.selectAllUsers();
		request.getServletContext().setAttribute("userList", userList);
		request.getServletContext().setAttribute("logins", logins);
		response.sendRedirect("admin_office.jsp");
	}

}

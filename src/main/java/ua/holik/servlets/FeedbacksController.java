package ua.holik.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.holik.bl.FeedbackBean;
import ua.holik.db.dao.AbstractDAOFactory;
import ua.holik.db.dao.FeedbackDAO;
import ua.holik.db.dao.MySqlDAOFactory;

/**
 * Servlet implementation class FeedbacksController
 */
@WebServlet("/FeedbacksController")
public class FeedbacksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbacksController() {
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
		FeedbackDAO feedbackDAO = factory.getFeedbackDAO();
		ArrayList<FeedbackBean> feedbacks = feedbackDAO.selectAllFeedbacks();
		request.getSession().setAttribute("feedbacks", feedbacks);
		response.sendRedirect("feedbacks.jsp");
	}

}

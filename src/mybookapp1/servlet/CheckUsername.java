package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.UserDAO;
import mybookapp1.DTO.User;

public class CheckUsername extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckUsername() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findUserByName(username);
		if(user == null) {
			request.setAttribute("judge", "success");
		} else {
			request.setAttribute("judge", null);
		}
		request.setAttribute("username", username);
		request.getRequestDispatcher("checkUsername.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}

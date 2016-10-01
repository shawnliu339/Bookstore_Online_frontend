package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.AdminDAO;
import mybookapp1.DTO.Admin;
import mybookapp1.message.Message;

public class AdminLogin extends HttpServlet {

	public AdminLogin() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Admin admin = new Admin();
		AdminDAO adminDAO = new AdminDAO();
		admin = adminDAO.findUserByNameAndPassword(username, password);
		if(admin != null) {
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect("adminBook.jsp");
		} else {
			Message.message(request, response, "back", "用户或密码错误，请重新输入！");
		}
		
	}

}

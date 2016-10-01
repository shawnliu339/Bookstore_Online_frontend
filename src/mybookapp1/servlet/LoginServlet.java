package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.CartDAO;
import mybookapp1.DAO.UserDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;
import mybookapp1.message.Message;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		UserDAO userDAO = new UserDAO();

		User user = userDAO.findUserByNameAndPassword(Username, Password);

		List<Cart> cartList = null;
		if (user != null) {
			CartDAO cartDAO = new CartDAO();
			cartList = cartDAO.findCartByUserId(user.getId());
		}
		request.getSession().setAttribute("cartList", cartList);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("index.action");
			return;
		} else {
			Message.message(request, response, "back", "用户或密码错误，请重新输入！");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

	}
}
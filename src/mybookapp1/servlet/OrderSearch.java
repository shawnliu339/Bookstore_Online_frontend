package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.OrderDAO;
import mybookapp1.DTO.Order;
import mybookapp1.DTO.User;

public class OrderSearch extends HttpServlet {

	
	public OrderSearch() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderDAO orderDAO = new OrderDAO();
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect("userNull.jsp");
			return;
		}
		String nusername = user.getUsername();
		List<Order> orderList = orderDAO.findAllByUsername(nusername);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("orderSearch.jsp").forward(request, response);
	}

}

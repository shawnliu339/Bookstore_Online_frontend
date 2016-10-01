package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.CartDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;

public class CartClearServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CartClearServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//数据库中信息删除
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		System.out.println(userId);
		CartDAO cartDAO = new CartDAO();
		cartDAO.deleteAll(userId);
		
		//session中信息删除
		ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cartList");
		cartList.clear();
		Double allMoney = 0.0;
		request.getSession().setAttribute("cartList", cartList);
		request.getSession().setAttribute("allMoney", allMoney);
		response.sendRedirect("cartShow.jsp");
		
	}

}

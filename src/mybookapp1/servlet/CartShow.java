package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DTO.Cart;

public class CartShow extends HttpServlet {

	public CartShow() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Cart> cartList = (List<Cart>) request.getSession().getAttribute(
				"cartList");
		if (cartList == null || cartList.isEmpty()) {
			response.sendRedirect("cartNull.jsp");
			return;
		}
		Double allMoney = this.getAllMoney(cartList);
		request.getSession().setAttribute("allMondy", allMoney);
		response.sendRedirect("cartShow.jsp");
		return;

	}

	/**
	 * 接收购物车中的商品，并返回总金额
	 * 
	 * @param cartList
	 *            购物车中的商品列表
	 */
	private Double getAllMoney(List<Cart> cartList) {

		Double allMoney = 0.0;
		for (Cart cartTemp : cartList) {
			allMoney += cartTemp.getMoney();
		}

		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		allMoney = Double.parseDouble(moneyFormat.format(allMoney));
		return allMoney;

	}

}

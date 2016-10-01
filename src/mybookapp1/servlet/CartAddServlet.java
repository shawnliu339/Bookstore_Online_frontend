package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.BookDAO;
import mybookapp1.DTO.Book;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;

public class CartAddServlet extends HttpServlet {

	/**
	 * <p>
	 * Title:像购物车中添加商品的处理类
	 * </p>
	 * <p>
	 * Description:像购物车中添加商品
	 * </p>
	 * 
	 * @author 刘思远
	 */
	public CartAddServlet() {
		super();
	}

	/**
	 * 接受购买按钮的请求
	 * 
	 * @param request
	 *            页面请求
	 * @param response
	 *            服务器回应
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();

		// 检索购买图书的信息
		book = bookDAO.findBookById(bookId);
		String ISBN = book.getISBN();
		String name = book.getName();
		Double price = book.getPrice();
		Integer amount = 1;
		Double money = price * amount;

		// 在购物车中检查是否存在需要购买的图书，并计算总金额
		List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute(
				"cartList");
		int i = 0, isExistence = 0;
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
		} else {
			for (i = 0; i < cartList.size(); i++) {
				Integer cartBookId = cartList.get(i).getBookId();
				if (cartBookId == bookId) {
					isExistence = 1;
					amount = cartList.get(i).getAmount() + 1;
					money = price * amount;
					break;
				}
			}
		}

		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		money = Double.parseDouble(moneyFormat.format(money));
		// 将图书信息存入购物车对象中
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setBookId(bookId);
		cart.setISBN(ISBN);
		cart.setName(name);
		cart.setPrice(price);
		cart.setAmount(amount);
		cart.setMoney(money);

		// 将购物车对象存入购物车列表中
		if (isExistence == 0) {
			cartList.add(cart);
		} else {
			cartList.set(i, cart);
		}
		
		// 计算购物车中商品的总金额
		Double allMoney = this.getAllMoney(cartList);
		
		request.getSession().setAttribute("cartList", cartList);
		request.getSession().setAttribute("allMoney", allMoney);
		response.sendRedirect("cartShow.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	/**
	 * 接收购物车中的商品，并返回总金额
	 * 
	 * @param cartList 购物车中的商品列表
	 */
	private Double getAllMoney(List<Cart> cartList) {
		
		Double allMoney = 0.0;
		for(Cart cartTemp : cartList){
			allMoney += cartTemp.getMoney();
		}
		
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		allMoney = Double.parseDouble(moneyFormat.format(allMoney));
		return allMoney;
		
	}

}

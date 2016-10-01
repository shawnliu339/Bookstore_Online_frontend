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
import mybookapp1.DAO.OdrDtlDAO;
import mybookapp1.DAO.OrderDAO;
import mybookapp1.DAO.SaleDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.OdrDtl;
import mybookapp1.DTO.Order;
import mybookapp1.DTO.Sale;
import mybookapp1.DTO.User;

/**
 * 订单生成servelet
 * 
 * @author 刘思远
 * 
 */
public class OrderCreate extends HttpServlet {

	public OrderCreate() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 提取订单需要的数据
		User user = (User) request.getSession().getAttribute("user");
		List<Cart> cartList = (ArrayList<Cart>) request.getSession()
				.getAttribute("cartList");
		Integer goodsAmount = cartList.size();
		String username = user.getUsername();
		String truename = user.getTruename();
		String address = user.getAddress();
		Integer ZIP = Integer.parseInt(user.getZIP());
		String tel = user.getTel();
		String email = user.getEmail();
		String payType = request.getParameter("payType");
		String delivery = request.getParameter("delivery");
		String memo = request.getParameter("memo");
		
		// 赋值订单数据
		Order order = new Order();
		order.setGoodsAmount(goodsAmount);
		order.setUsername(username);
		order.setTruename(truename);
		order.setAddress(address);
		order.setZIP(ZIP);
		order.setTel(tel);
		order.setEmail(email);
		order.setPayType(payType);
		order.setDelivery(delivery);
		order.setMemo(memo);
		
		// 订单数据存入数据库
		OrderDAO orderDAO = new OrderDAO();
		Integer orderId = orderDAO.save(order);

		// 提取订单明细需要的数据
		OdrDtlDAO odrDtlDAO = new OdrDtlDAO();
		for (Cart cart : cartList) {
			Integer bookId = cart.getBookId();
			Integer amount = cart.getAmount();
			Double money = cart.getMoney();
			// 赋值订单明细数据
			OdrDtl odrDtl = new OdrDtl();
			odrDtl.setOrderId(orderId);
			odrDtl.setBookId(bookId);
			odrDtl.setAmount(amount);
			odrDtl.setMoney(money);
			// 存入数据库
			odrDtlDAO.save(odrDtl);
		}
		
		//提取销售表所需数据
		SaleDAO saleDAO = new SaleDAO();
		Sale sale = new Sale();
		sale.setOrderId(orderId);
		saleDAO.save(sale);

		// 删除购物车中的商品
		CartDAO cartDAO = new CartDAO();
		Integer userId = user.getId();
		cartDAO.deleteAll(userId);
		cartList.clear();
		request.getSession().setAttribute("cartList", cartList);
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("orderSuccess.jsp").forward(request,
				response);
	}

}

package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.BookDAO;
import mybookapp1.DAO.OdrDtlDAO;
import mybookapp1.DAO.OrderDAO;
import mybookapp1.DTO.Book;
import mybookapp1.DTO.BookOmit;
import mybookapp1.DTO.OdrDtl;
import mybookapp1.DTO.Order;
import mybookapp1.DTO.User;

public class OrderDetail extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderDetail() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("userNull.jsp");
			return;
		}

		// 通过订单号查询订单总览信息
		Integer orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findOrderById(orderId);
		request.setAttribute("order", order);

		// 通过订单号查询订单详细信息
		OdrDtlDAO odrDtlDAO = new OdrDtlDAO();
		List<OdrDtl> odrDtlList = odrDtlDAO.findOrderDetailById(orderId);

		// 根据图书id查询订单中对应图书的详细信息
		List<BookOmit> bookOmitList = new ArrayList<BookOmit>();
		BookDAO bookDAO = new BookDAO();
		BookOmit odrBookOmit = null;
		for (OdrDtl orderDetail : odrDtlList) {
			// 根据订单详单中图书编号，查询所需图书的相关信息
			Integer bookId = orderDetail.getBookId();
			Book book = bookDAO.findBookById(bookId);
			String ISBN = book.getISBN();
			String name = book.getName();
			String publisher = book.getPublisher();
			Double price = book.getPrice();
			Integer amount = orderDetail.getAmount();

			odrBookOmit = new BookOmit();
			odrBookOmit.setISBN(ISBN);
			odrBookOmit.setName(name);
			odrBookOmit.setPublisher(publisher);
			odrBookOmit.setPrice(price);
			odrBookOmit.setAmount(amount);
			bookOmitList.add(odrBookOmit);
		}

		request.setAttribute("bookOmitList", bookOmitList);
		request.getRequestDispatcher("orderDetail.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}

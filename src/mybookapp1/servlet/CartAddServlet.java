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
	 * Title:���ﳵ�������Ʒ�Ĵ�����
	 * </p>
	 * <p>
	 * Description:���ﳵ�������Ʒ
	 * </p>
	 * 
	 * @author ��˼Զ
	 */
	public CartAddServlet() {
		super();
	}

	/**
	 * ���ܹ���ť������
	 * 
	 * @param request
	 *            ҳ������
	 * @param response
	 *            ��������Ӧ
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

		// ��������ͼ�����Ϣ
		book = bookDAO.findBookById(bookId);
		String ISBN = book.getISBN();
		String name = book.getName();
		Double price = book.getPrice();
		Integer amount = 1;
		Double money = price * amount;

		// �ڹ��ﳵ�м���Ƿ������Ҫ�����ͼ�飬�������ܽ��
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
		// ��ͼ����Ϣ���빺�ﳵ������
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setBookId(bookId);
		cart.setISBN(ISBN);
		cart.setName(name);
		cart.setPrice(price);
		cart.setAmount(amount);
		cart.setMoney(money);

		// �����ﳵ������빺�ﳵ�б���
		if (isExistence == 0) {
			cartList.add(cart);
		} else {
			cartList.set(i, cart);
		}
		
		// ���㹺�ﳵ����Ʒ���ܽ��
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
	 * ���չ��ﳵ�е���Ʒ���������ܽ��
	 * 
	 * @param cartList ���ﳵ�е���Ʒ�б�
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

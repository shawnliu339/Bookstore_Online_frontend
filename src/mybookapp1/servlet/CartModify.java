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

import mybookapp1.DTO.Cart;

public class CartModify extends HttpServlet {

	/**
	 * �޸Ĺ��ﳵ����Ʒ����������
	 */
	public CartModify() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post. ������Ʒ�ڹ��ﳵ�е���ţ����Ҹ�����ź��û��޸ĵ������޸Ĺ��ﳵ�й�����Ʒ����Ϣ
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession()
				.getAttribute("cartList");
		int index = Integer.parseInt(request.getParameter("index"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Cart cart = cartList.get(index);

		// ���ݹ������������ܽ��
		Double price = cart.getPrice();
		Double money = price * amount;
		DecimalFormat moneyFormat = new DecimalFormat("#.00");
		money = Double.parseDouble(moneyFormat.format(money));

		// �Թ������Ʒ�����²���
		cart.setAmount(amount);
		cart.setMoney(money);
		cartList.set(index, cart);
		Double allMoney = this.getAllMoney(cartList);
		
		request.getSession().setAttribute("cartList", cartList);
		request.getSession().setAttribute("allMoney", allMoney);
		response.sendRedirect("cartShow.jsp");

	}

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

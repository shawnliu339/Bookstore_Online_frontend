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

import mybookapp1.DAO.CartDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;

public class CartRemoveServlet extends HttpServlet {

	/**
	 * ������ﳵ��ѡ������Ʒ
	 */
	public CartRemoveServlet() {
		super();
	}

	/**
	 * ������ﳵ��ѡ������Ʒ <br>
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ɾ�����ݿ��ж�Ӧ��Ϣ
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		CartDAO cartDAO = new CartDAO();
		cartDAO.delete(userId, bookId);
		
		//ɾ��session�еĶ�Ӧ��Ϣ
		List<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cartList");
		int index = Integer.parseInt(request.getParameter("index"));
		cartList.remove(index);
		Double allMoney = this.getAllMoney(cartList);
		request.getSession().setAttribute("cartList", cartList);
		request.getSession().setAttribute("allMoney", allMoney);
		response.sendRedirect("cartShow.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
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

package mybookapp1.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mybookapp1.DAO.CartDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;

/**
 * 监听用户是否注销，用户注销后将购物车中商品存入数据库
 * 
 * @author 刘思远
 * 
 */

public class UserSessionListner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

		List<Cart> cartList = (ArrayList<Cart>) arg0.getSession().getAttribute(
				"cartList");
		User user = (User) arg0.getSession().getAttribute("user");
		CartDAO cartDAO = new CartDAO();

		Integer userId = user.getId();
		//如果用户登录，且购物车中有商品则将购物车列表存入购物车
		if (user != null && cartList != null) {
			cartDAO.save(userId, cartList);
		}
	}

}

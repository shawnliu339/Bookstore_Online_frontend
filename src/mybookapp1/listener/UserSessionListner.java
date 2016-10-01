package mybookapp1.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mybookapp1.DAO.CartDAO;
import mybookapp1.DTO.Cart;
import mybookapp1.DTO.User;

/**
 * �����û��Ƿ�ע�����û�ע���󽫹��ﳵ����Ʒ�������ݿ�
 * 
 * @author ��˼Զ
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
		//����û���¼���ҹ��ﳵ������Ʒ�򽫹��ﳵ�б���빺�ﳵ
		if (user != null && cartList != null) {
			cartDAO.save(userId, cartList);
		}
	}

}

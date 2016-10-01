package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mybookapp1.DTO.Cart;
import mybookapp1.factory.ConnectionFactory;

public class CartDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	/**
	 * �����ﳵ�е���Ʒ�б�������ݿ�
	 * 
	 * @param userId
	 *            �û�id
	 * @param cartList
	 *            ���ﳵ�б�
	 */
	public void save(Integer userId, List<Cart> cartList) {

		CartDAO cartDAO = new CartDAO();
		for (Cart cart : cartList) {
			if (cartDAO.update(userId, cart) == 0) {
				cartDAO.insert(cart);
			}
		}
	}

	/**
	 * �����ﳵ�е�һ����Ʒ�������ݿ�
	 * 
	 * @param cart
	 *            ���ﳵ�е�һ����Ʒ
	 * @return ���ش������ݵ�����
	 */
	public int insert(Cart cart) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cart ");
			sql.append("VALUES(?, ?, ?, ?, ?, ?, ?) ");
			pstm = conn.prepareStatement(sql.toString());

			// ��ȡ���ﳵ�б���ÿ����Ʒ����Ϣ
			Integer userId = cart.getUserId();
			Integer bookId = cart.getBookId();
			String ISBN = cart.getISBN();
			String name = cart.getName();
			Double price = cart.getPrice();
			Integer amount = cart.getAmount();
			Double money = cart.getMoney();

			// ����Ʒ��Ϣ��ֵ�����ݿ����
			pstm.setInt(1, userId);
			pstm.setInt(2, bookId);
			pstm.setString(3, ISBN);
			pstm.setString(4, name);
			pstm.setDouble(5, price);
			pstm.setInt(6, amount);
			pstm.setDouble(7, money);
			int row = pstm.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	/**
	 * �����û�id��ɾ�����û����ﳵ��������Ʒ����Ϣ
	 * 
	 * @param userId
	 *            �û�id
	 * @return ɾ���ɹ�����true ɾ��ʧ�ܷ���false
	 */
	public boolean delete(Integer userId, Integer bookId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_cart ");
			sql.append("WHERE cart_userId = ? AND cart_bookId = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, userId);
			pstm.setInt(2, bookId);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	/**
	 * �����û�id��ɾ�����û����ﳵ��������Ʒ����Ϣ
	 * 
	 * @param userId
	 *            �û�id
	 * @return ɾ���ɹ�����true ɾ��ʧ�ܷ���false
	 */
	public boolean deleteAll(Integer userId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_cart ");
			sql.append("WHERE cart_userId = " + userId);
			pstm = conn.prepareStatement(sql.toString());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	/**
	 * �����û�id��ͼ��id���޸����ݿ��ж�Ӧ����Ʒ��Ϣ
	 * 
	 * @param userId
	 *            �û�id
	 * @param cartsList
	 *            ���ﳵ�е�һ����Ʒ
	 * @return �����޸����ݵ�����
	 */
	public int update(Integer userId, Cart cart) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cart ");
			sql.append("SET cart_userId = ?, ");
			sql.append("cart_bookId = ?, ");
			sql.append("cart_ISBN = ?, ");
			sql.append("cart_name = ?, ");
			sql.append("cart_price = ?, ");
			sql.append("cart_amount = ?, ");
			sql.append("cart_money = ? ");
			sql.append("WHERE cart_userId = ? AND cart_bookId = ? ");
			pstm = conn.prepareStatement(sql.toString());

			// ��ȡ��Ʒ����Ϣ
			Integer bookId = cart.getBookId();
			String ISBN = cart.getISBN();
			String name = cart.getName();
			Double price = cart.getPrice();
			Integer amount = cart.getAmount();
			Double money = cart.getMoney();

			// ����Ʒ��Ϣ��ֵ�����ݿ����
			pstm.setInt(1, userId);
			pstm.setInt(2, bookId);
			pstm.setString(3, ISBN);
			pstm.setString(4, name);
			pstm.setDouble(5, price);
			pstm.setInt(6, amount);
			pstm.setDouble(7, money);
			pstm.setInt(8, userId);
			pstm.setInt(9, bookId);
			int row = pstm.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	/**
	 * ͨ���û�id��ѯ���û��Ĺ��ﳵ�б�
	 * 
	 * @param userId
	 *            �û�id
	 * @return ���ﳵ����Ʒ�б�
	 */
	public List<Cart> findCartByUserId(Integer userId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tb_cart ");
			sql.append("WHERE cart_userId = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, userId);
			rs = pstm.executeQuery();

			List<Cart> cartList = new ArrayList<Cart>();
			while (rs.next()) {
				Cart cart = new Cart();
				Integer cartUserId = rs.getInt("cart_userId");
				Integer cartBookId = rs.getInt("cart_bookId");
				String cartISBN = rs.getString("cart_ISBN");
				String cartName = rs.getString("cart_name");
				Double cartPrice = rs.getDouble("cart_price");
				Integer cartAmount = rs.getInt("cart_amount");
				Integer cartMoney = rs.getInt("cart_money");

				cart.setUserId(cartUserId);
				cart.setBookId(cartBookId);
				cart.setISBN(cartISBN);
				cart.setName(cartName);
				cart.setPrice(cartPrice);
				cart.setAmount(cartAmount);
				cart.setMoney(cartPrice);
				cartList.add(cart);
			}
			return cartList;
		} catch (Exception e) {
			System.out.println("find cart by user id error!");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {
		Integer userId = 1;
		Integer bookId = 1;
		CartDAO cartDAO = new CartDAO();
		cartDAO.delete(userId, bookId);
	}
}

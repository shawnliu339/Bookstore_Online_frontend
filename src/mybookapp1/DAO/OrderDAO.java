package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mybookapp1.DTO.Order;
import mybookapp1.factory.ConnectionFactory;

public class OrderDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public Integer save(Order order) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_order ");
			sql.append("(order_goodsAmount, order_username, order_truename, order_address, order_ZIP, order_tel, order_email, order_payType, order_delivery, order_memo) ");
			sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			pstm = conn.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			Integer goodsAmount = order.getGoodsAmount();
			String username = order.getUsername();
			String truename = order.getTruename();
			String address = order.getAddress();
			Integer ZIP = order.getZIP();
			String tel = order.getTel();
			String email = order.getEmail();
			String payType = order.getPayType();
			String delivery = order.getDelivery();
			String memo = order.getMemo();

			pstm.setInt(1, goodsAmount);
			pstm.setString(2, username);
			pstm.setString(3, truename);
			pstm.setString(4, address);
			pstm.setInt(5, ZIP);
			pstm.setString(6, tel);
			pstm.setString(7, email);
			pstm.setString(8, payType);
			pstm.setString(9, delivery);
			pstm.setString(10, memo);
			pstm.executeUpdate();

			// 检索由此statement对象而自动生成的键
			rs = pstm.getGeneratedKeys();
			Integer orderId = null;
			if (rs.next()) {
				orderId = rs.getInt(1);
			}

			return orderId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public Order findOrderById(Integer orderId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT order_id, order_truename, order_address, order_ZIP, order_tel, order_email, order_payType, order_delivery, order_date, order_memo, order_state ");
			sql.append("FROM tb_order ");
			sql.append("WHERE order_id = " + orderId);
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			Order order = null;
			if (rs.next()) {
				order = new Order();
				Integer id = rs.getInt("order_id");
				String truename = rs.getString("order_truename");
				String address = rs.getString("order_address");
				Integer ZIP = rs.getInt("order_ZIP");
				String tel = rs.getString("order_tel");
				String email = rs.getString("order_email");
				String payType = rs.getString("order_payType");
				String delivery = rs.getString("order_delivery");
				String date = rs.getString("order_date");
				String memo = rs.getString("order_memo");
				Integer state = rs.getInt("order_state");

				order.setId(id);
				order.setTruename(truename);
				order.setAddress(address);
				order.setZIP(ZIP);
				order.setTel(tel);
				order.setEmail(email);
				order.setPayType(payType);
				order.setDelivery(delivery);
				order.setDate(date);
				order.setMemo(memo);
				order.setState(state);
			}
			return order;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<Order> findAll() {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT order_id, order_goodsAmount, order_truename, order_payType, order_delivery, order_date ");
			sql.append("FROM tb_order ");
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<Order> orderList = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				Integer id = rs.getInt("order_id");
				Integer goodsAmount = rs.getInt("order_goodsAmount");
				String truename = rs.getString("order_truename");
				String payType = rs.getString("order_payType");
				String delivery = rs.getString("order_delivery");
				String date = rs.getString("order_date");

				order.setId(id);
				order.setGoodsAmount(goodsAmount);
				order.setTruename(truename);
				order.setPayType(payType);
				order.setDelivery(delivery);
				order.setDate(date);
				orderList.add(order);
			}
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<Order> findAllByUsername(String username) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT order_id, order_goodsAmount, order_truename, order_payType, order_delivery, order_date, order_state ");
			sql.append("FROM tb_order ");
			sql.append("WHERE order_username = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, username);
			rs = pstm.executeQuery();

			List<Order> orderList = new ArrayList<Order>();
			while (rs.next()) {
				Order order = new Order();
				Integer id = rs.getInt("order_id");
				Integer goodsAmount = rs.getInt("order_goodsAmount");
				String truename = rs.getString("order_truename");
				String payType = rs.getString("order_payType");
				String delivery = rs.getString("order_delivery");
				String date = rs.getString("order_date");
				Integer state = rs.getInt("order_state");

				order.setId(id);
				order.setGoodsAmount(goodsAmount);
				order.setTruename(truename);
				order.setPayType(payType);
				order.setDelivery(delivery);
				order.setDate(date);
				order.setState(state);
				orderList.add(order);
			}
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {

		OrderDAO orderDAO = new OrderDAO();
		System.out.println(orderDAO.findOrderById(1));

	}
}

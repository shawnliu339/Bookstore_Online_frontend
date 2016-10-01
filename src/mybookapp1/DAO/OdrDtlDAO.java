package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mybookapp1.DTO.OdrDtl;
import mybookapp1.DTO.Order;
import mybookapp1.DTO.BookOmit;
import mybookapp1.factory.ConnectionFactory;

public class OdrDtlDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public boolean save(OdrDtl odrDtl) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_orderDetail ");
			sql.append("(odrDtl_orderId, odrDtl_bookId, odrDtl_amount, odrDtl_money) ");
			sql.append("VALUES(?, ?, ?, ?) ");
			pstm = conn.prepareStatement(sql.toString());

			Integer orderId = odrDtl.getOrderId();
			Integer bookId = odrDtl.getBookId();
			Integer amount = odrDtl.getAmount();
			Double money = odrDtl.getMoney();
			pstm.setInt(1, orderId);
			pstm.setInt(2, bookId);
			pstm.setInt(3, amount);
			pstm.setDouble(4, money);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<BookOmit> getRanking() {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT TOP 10 book_id, book_name, book_publisher, book_price, allAmount ");
			sql.append("FROM (");
			sql.append("SELECT odrDtl_bookId, SUM(odrDtl_amount) AS allAmount ");
			sql.append("FROM tb_orderDetail ");
			sql.append("GROUP BY odrDtl_bookId ");
			sql.append(") ranking ");
			sql.append("INNER JOIN tb_book ");
			sql.append("ON ranking.odrDtl_bookId = tb_book.book_id ");
			sql.append("ORDER BY allAmount DESC ");
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<BookOmit> rankList = new ArrayList<BookOmit>();
			BookOmit ranking = null;
			while (rs.next()) {
				Integer bookId = rs.getInt("book_id");
				String name = rs.getString("book_name");
				String publisher = rs.getString("book_publisher");
				Double price = rs.getDouble("book_price");
				Integer allAmount = rs.getInt("allAmount");

				ranking = new BookOmit();
				ranking.setBookId(bookId);
				ranking.setName(name);
				ranking.setPublisher(publisher);
				ranking.setPrice(price);
				ranking.setAmount(allAmount);
				rankList.add(ranking);
			}

			return rankList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<OdrDtl> findOrderDetailById(Integer orderId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT odrDtl_bookId, odrDtl_amount, odrDtl_money ");
			sql.append("FROM tb_orderDetail ");
			sql.append("WHERE odrDtl_orderId = " + orderId);
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<OdrDtl> odrDtlList = new ArrayList<OdrDtl>();
			OdrDtl odrDtl = null;
			while (rs.next()) {
				Integer bookId = rs.getInt("odrDtl_bookId");
				Integer amount = rs.getInt("odrDtl_amount");
				Double money = rs.getDouble("odrDtl_money");

				odrDtl = new OdrDtl();
				odrDtl.setBookId(bookId);
				odrDtl.setAmount(amount);
				odrDtl.setMoney(money);
				odrDtlList.add(odrDtl);
			}
			return odrDtlList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {
		OdrDtlDAO odrDtlDAO = new OdrDtlDAO();
		OdrDtl odrDtl = new OdrDtl();

		List<BookOmit> books = new ArrayList<BookOmit>();
		books = odrDtlDAO.getRanking();
		System.out.println(books);
	}

}

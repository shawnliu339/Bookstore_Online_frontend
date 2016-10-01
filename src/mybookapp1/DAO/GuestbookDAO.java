package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mybookapp1.DTO.Guestbook;
import mybookapp1.factory.ConnectionFactory;

public class GuestbookDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public boolean save(Guestbook guestbook) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_guestbook ");
			sql.append("(guestbook_userId, guestbook_title, guestbook_content) ");
			sql.append("VALUES(?, ?, ?) ");
			pstm = conn.prepareStatement(sql.toString());

			Integer userId = guestbook.getUserId();
			String title = guestbook.getTitle();
			String content = guestbook.getContent();
			pstm.setInt(1, userId);
			pstm.setString(2, title);
			pstm.setString(3, content);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public boolean deleteById(Integer id) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_guestbook ");
			sql.append("WHERE guestbook_id = " + id);
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
	
	public Guestbook findGuestbookById(Integer guestbookId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tb_guestbook ");
			sql.append("WHERE guestbook_id = " + guestbookId);
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();
			
			Guestbook guestbook = null;
			if(rs.next()) {
				Integer id = rs.getInt("guestbook_id");
				String title = rs.getString("guestbook_title");
				String content = rs.getString("guestbook_content");
				String reply = rs.getString("guestbook_reply");
				String date = rs.getString("guestbook_date");
				Integer replyFlag = rs.getInt("guestbook_replyFlag");

				guestbook = new Guestbook();
				guestbook.setId(id);
				guestbook.setTitle(title);
				guestbook.setContent(content);
				guestbook.setReply(reply);
				guestbook.setDate(date);
				guestbook.setReplyFlag(replyFlag);
			}
			return guestbook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public List<Guestbook> findAllByUserId(Integer userId) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM tb_guestbook ");
			sql.append("WHERE guestbook_userId = " + userId);
			pstm = conn.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			List<Guestbook> guestbookList = new ArrayList<Guestbook>();
			Guestbook guestbook = null;
			while (rs.next()) {
				Integer id = rs.getInt("guestbook_id");
				String title = new String();
				if(rs.getString("guestbook_title").length()>6) {
					StringBuilder str = new StringBuilder();
					str.append(rs.getString("guestbook_title").substring(0, 5)).append("...");
					title = str.toString();
				} else {
					title = rs.getString("guestbook_title");
				}
				String content = new String();
				if(rs.getString("guestbook_content").length()>10) {
					StringBuilder str = new StringBuilder();
					str.append(rs.getString("guestbook_content").substring(0, 9)).append("...");
					content = str.toString();
				} else {
					content = rs.getString("guestbook_content");
				}
				String reply = rs.getString("guestbook_reply");
				String date = rs.getString("guestbook_date");
				Integer replyFlag = rs.getInt("guestbook_replyFlag");

				guestbook = new Guestbook();
				guestbook.setId(id);
				guestbook.setTitle(title);
				guestbook.setContent(content);
				guestbook.setReply(reply);
				guestbook.setDate(date);
				guestbook.setReplyFlag(replyFlag);
				guestbookList.add(guestbook);
			}
			return guestbookList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		Guestbook guestbook = new Guestbook();
		System.out.println(guestbookDAO.findGuestbookById(1));
	}

}

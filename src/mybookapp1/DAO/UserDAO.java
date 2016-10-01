package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mybookapp1.DTO.User;
import mybookapp1.factory.ConnectionFactory;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public boolean save(User user) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_user ");
			sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getNickname());
			pstm.setString(4, user.getTruename());
			pstm.setString(5, user.getCardType());
			pstm.setString(6, user.getCardNum());
			pstm.setString(7, user.getSex());
			pstm.setString(8, user.getTel());
			pstm.setString(9, user.getEmail());
			pstm.setString(10, user.getCity());
			pstm.setString(11, user.getZIP());
			pstm.setString(12, user.getAddress());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("save error");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public boolean delete(Integer id) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM tb_user ");
			sql.append("WHERE id = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setObject(1, id);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("delete error");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	
	public boolean update(User user) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_user ");
			sql.append("SET nickname = ?, truename = ?, cardType = ?, cardNum = ?, sex = ?, tel = ?, city = ?, ZIP = ?, address = ? ");
			sql.append("WHERE id = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, user.getNickname());
			pstm.setString(2, user.getTruename());
			pstm.setString(3, user.getCardType());
			pstm.setString(4, user.getCardNum());
			pstm.setString(5, user.getSex());
			pstm.setString(6, user.getTel());
			pstm.setString(7, user.getCity());
			pstm.setString(8, user.getZIP());
			pstm.setString(9, user.getAddress());
			pstm.setInt(10, user.getId());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("update error");
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	
	public User findUserByName(String username){
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT username ");
			sql.append("FROM tb_user ");
			sql.append("WHERE username = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			User User = null;
			if(rs.next()){
				User = new User();
				User.setUsername(username);
			}
			return User;
		} catch (Exception e) {
			System.out.println("find user by username error");
			e.printStackTrace();
			return null;
		}finally{
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public User findUserByNameAndPassword(String username, String password) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM tb_user ");
			sql.append("WHERE username = ? ");
			sql.append("AND password = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			User User = null;
			if (rs.next()) {
				User = new User();
				User.setId(rs.getInt("id"));
				User.setUsername(rs.getString("username"));
				User.setPassword(rs.getString("password"));
				User.setNickname(rs.getString("nickname"));
				User.setTruename(rs.getString("truename"));
				User.setCardType(rs.getString("cardType"));
				User.setCardNum(rs.getString("cardNum"));
				User.setSex(rs.getString("sex"));
				User.setTel(rs.getString("tel"));
				User.setEmail(rs.getString("email"));
				User.setCity(rs.getString("city"));
				User.setZIP(rs.getString("ZIP"));
				User.setAddress(rs.getString("address"));
			}
			return User;
		} catch (Exception e) {
			System.out.println("find user by username and password error");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}

	public static void main(String[] args) {
		UserDAO UserDAO = new UserDAO();
		User User = new User();
		User = UserDAO.findUserByNameAndPassword("admin", "liusiyuan");
		User.setNickname("刘思远");
		User.setTel("18600699330");
		UserDAO.update(User);
		System.out.println(User.toString());
	}
}

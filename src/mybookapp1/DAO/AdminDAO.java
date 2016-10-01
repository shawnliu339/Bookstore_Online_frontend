package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mybookapp1.DTO.Admin;
import mybookapp1.factory.ConnectionFactory;

public class AdminDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public Admin findUserByNameAndPassword(String username, String password) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM tb_admin ");
			sql.append("WHERE admin_username = ? ");
			sql.append("AND admin_password = ? ");
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			Admin admin = null;
			if (rs.next()) {
				admin = new Admin();
				Integer adminId = rs.getInt("admin_id");
				admin.setId(adminId);
				admin.setUsername(username);
				admin.setPassword(password);
			}
			return admin;
		} catch (Exception e) {
			System.out.println("find user by username and password error");
			e.printStackTrace();
			return null;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
	
	public static void main(String[] args) {
		AdminDAO adminDAO = new AdminDAO();
		System.out.println(adminDAO.findUserByNameAndPassword("admin", "liusiyuan"));
	}
}

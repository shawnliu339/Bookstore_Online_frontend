package mybookapp1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mybookapp1.DTO.Sale;
import mybookapp1.factory.ConnectionFactory;

public class SaleDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public boolean save(Sale sale) {
		try {
			conn = ConnectionFactory.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO tb_sale ");
			sql.append("(orderId) ");
			sql.append("VALUES(?)");
			pstm = conn.prepareStatement(sql.toString());
			
			Integer orderId = sale.getOrderId();
			
			pstm.setInt(1, orderId);
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ConnectionFactory.close(conn, pstm, rs);
		}
	}
}

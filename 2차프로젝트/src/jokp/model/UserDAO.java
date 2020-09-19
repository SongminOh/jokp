package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	// �α��� ���
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	static {
		try { // DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	//****DB ������****
	public Connection getConn() { // ���� ��ü
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "jokp";
		String password = "1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}
	
	//****�α��α��**** : id�� �ش��ϴ� pw�� return
	public String login(String user_id) {
		
		conn = getConn();
		String sql = "select pw from users where user_id = ?";
		String pw = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
			pw = rs.getString(1);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return pw;
	}
	
	
	
	
	//****DB CLOSE���****
	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}

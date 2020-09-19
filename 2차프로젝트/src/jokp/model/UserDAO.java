package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {
	// 1. 로그인 기능
	// 2. 수정 기능(선호 카테고리, 설정 영상 재생 시간)
	
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

	//****DB 연결기능****
	public Connection getConn() { // 연결 객체
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
	
	//****로그인기능**** : id에 해당하는 pw값 return
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
	
	//****선호 카테고리 수정기능****
	public int usersUpdate(UsersVO vo) {
		conn = getConn();
		int cnt = 0;
		String sql = "update users set preference = ? where user_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getPreference());
			pst.setString(2, vo.getUser_id());
			cnt = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return cnt;
		
	}
	
	//****선호 재생 시간 수정기능****
		public int settimeUpdate(UsersVO vo) {
			conn = getConn();
			int cnt = 0;
			String sql = "update users set set_time = ? where user_id = ?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, vo.getPreference());
				pst.setString(2, vo.getUser_id());
				cnt = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return cnt;
			
		}
	
	//****DB CLOSE기능****
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

package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {
	// 1. 로그인 기능 : login
	// 2. 수정 기능(선호 카테고리, 설정 영상 재생 시간) preferenceUpdate, settimeUpdate
	// 3. 사용자 정보 전체보기 userinfoList
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
		
			System.out.println("출력");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "jokp";
			String password = "1234";

			try {
				conn = DriverManager.getConnection(url, user, password);
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("왜에러???2");
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
	public int preferenceUpdate(UsersVO vo) {
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
				pst.setString(1, vo.getSet_time());
				pst.setString(2, vo.getUser_id());
				cnt = pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return cnt;
			
		}
		
		//****사용자 정보 보기 기능****
		public UsersVO userinfoList(String user_id) {
			UsersVO vo = null;
			conn = getConn();
			String sql = "select * from users where user_id = ?";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, user_id);
				rs = pst.executeQuery();
				if (rs.next()) {
					user_id = rs.getString(1);
					String pw = rs.getString(2);
					String name = rs.getString(3);
					int age = rs.getInt(4);
					String job = rs.getString(5);
					String preference = rs.getString(6);
					String set_time = rs.getString(7);
					vo = new UsersVO(user_id, pw, name, age, job, preference, set_time);
					

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}

			return vo;
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

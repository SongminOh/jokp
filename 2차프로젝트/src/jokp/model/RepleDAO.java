package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class RepleDAO {
	//1. ��� �ޱ� : repleInsert
	//2. ���� �ش��ϴ� ��� ��ü ���� : repleList
	
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
	//****��� �߰� ���****
	public int repleInsert(String user_id, String media_id, String content) {
		conn = getConn();
		int cnt = 0;
		//DB�� reple_id �� ������ �����
		String sql = "insert into reple values(seq_reple.nextval,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user_id);
			pst.setString(2, media_id);
			pst.setString(3, content);

			cnt = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}

		return cnt;

	}
	
	//****���� �ش��ϴ� ��� ���� ���****
	public ArrayList<RepleVO> repleList(String media_id) {
		ArrayList<RepleVO> list = new ArrayList<RepleVO>();
		conn = getConn();
		String sql = "select * from reple where media_id = ? order by reple_id desc";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, media_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String reple_id = rs.getString(1);
				String user_id = rs.getString(2);
				media_id = rs.getString(3);
				String content = rs.getString(4);
				RepleVO vo = new RepleVO(reple_id, user_id, media_id, content);
				list.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}

		return list;
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

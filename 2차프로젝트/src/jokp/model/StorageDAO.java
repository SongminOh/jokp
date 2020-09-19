package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StorageDAO {
		// ������ ����ǰų� ������ ������ ������ storage db�� �߰���.
		// ���� ����� ���ƿ並 ������ upcheck�� 1, ������ ������ 0�� ��.
	
		//0. �����Կ� ���� �ֱ�
	//0-1. ������  0-2. �����丮/ ���ƿ� 
		//1. �����丮 �ֽż� 5�� ���� �����ֱ� ���
		//2. ���ƿ� ������ �����ֱ� ���
		//3. ���� ������(+)�� ���� ���� �����ֱ� ���
	
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
	
		//**** ���� �����Կ� �߰� ****
		public int storageInsert(StorageVO vo) {
			conn = getConn();
			int cnt = 0;
			String sql = "insert into storage values(?,?,?,?,?)";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, vo.getUser_id());
				pst.setString(2, vo.getMedia_id());
				pst.setTimestamp(3, vo.getPlaytime());
				pst.setLong(4, vo.getUpcheck());
				pst.setTimestamp(5, vo.getVisit_time());

				cnt = pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}

			return cnt;

		}
		
		//****�����丮 �ֽż����� 5�� �����ֱ� : ���� id 5�� ���� ****
//		public ArrayList<StorageVO> HistoryList(String user_id) {
//			ArrayList<StorageVO> list = new ArrayList<StorageVO>();
//			conn = getConn();
//			String sql = "select media_id from storage where user_id = ?, 
//		playtime is not null, order by ��û��¥ desc limit 5";
//			try {
//				pst = conn.prepareStatement(sql);
//				pst.setString(1, media_id);
//				rs = pst.executeQuery();
//				while (rs.next()) {
//					String reple_id = rs.getString(1);
//					String user_id = rs.getString(2);
//					media_id = rs.getString(3);
//					String content = rs.getString(4);
//					RepleVO vo = new RepleVO(reple_id, user_id, media_id, content);
//					list.add(vo);
//
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close();
//			}
//
//			return list;
//		}
		
		
		
		
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

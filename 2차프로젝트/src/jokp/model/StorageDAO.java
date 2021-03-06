package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StorageDAO {
		// 영상이 재생되거나 보관함 저장을 누르면 storage db에 추가됨.
		// 영상 재생시 좋아요를 누르면 upcheck에 1, 누르지 않으면 0이 들어감.
	
		//0. 보관함에 영상 넣기
	//0-1. 보관함  0-2. 히스토리/ 좋아요 
		//1. 히스토리 최신순 5개 영상 보여주기 기능
		//2. 좋아요 누른거 보여주기 기능
		//3. 영상 보관함(+)에 넣은 영상 보여주기 기능
	
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
	
		//**** 영상 보관함에 추가 ****
		public int storageInsert(StorageVO vo) {
			conn = getConn();
			int cnt = 0;
			String sql = "insert into storage values(?,?,?,?,?)";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, vo.getUser_id());
				pst.setString(2, vo.getMedia_id());
				pst.setString(3, vo.getPlaytime());
				pst.setString(4, vo.getVisit_time());
				pst.setLong(5, vo.getUpcheck());

				cnt = pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}

			return cnt;

		}
		
		//****히스토리 최신순으로 5개 보여주기 : 영상 id 5개 추출 ****
		public ArrayList<StorageVO> HistoryList(String user_id) {
			ArrayList<StorageVO> list = new ArrayList<StorageVO>();
			conn = getConn();
			String sql = "select media_id from storage where user_id = ? and playtime is not null order by 시청날짜 desc limit 5";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, user_id);
				rs = pst.executeQuery();
				while (rs.next()) {
					user_id = rs.getString(1);
					String media_id = rs.getString(2);
					String playtime = rs.getString(3);
					String upcheck = rs.getString(4);
					String visit_time = rs.getString(5);
					StorageVO vo = new StorageVO();
					list.add(vo);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}

			return list;
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

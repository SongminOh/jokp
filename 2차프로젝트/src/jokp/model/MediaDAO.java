package jokp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class MediaDAO {
	// ����id�� ������ ��� ���� �������� : mediainfoList
	// ���ƿ䳪 �Ⱦ�� �������� �ö󰡴°� : upcntUpdate, downcntUpdate
	// ��ȸ�� �ö󰡴°� : viewcntUpdate
	// Ű���� ��� �˻� : mediaSearch
	// ��� ���� ���� : mediaAllList
	//
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	static {
		try { // DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ֿ���???1");
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
	
	//****���� id�� ���� ���� ���****
			public MediaVO mediainfoList(String media_id) {
				MediaVO vo = null;
				conn = getConn();
				String sql = "select * from media where media_id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, media_id);
					rs = pst.executeQuery();
					if (rs.next()) {
						
						media_id = rs.getString(1);
						String title = rs.getString(2);
						String channel = rs.getString(3);
						int up = rs.getInt(4);
						int down = rs.getInt(5);
						int views = rs.getInt(6);
						String running_time = rs.getString(7);
						Date dates = rs.getDate(8);
						String hashtag = rs.getString(9);
						String url = rs.getString(10);
						String thumbnails = rs.getString(11);
						String category = rs.getString(12);
						
						vo = new MediaVO(media_id, title, channel, up, down, views, running_time, dates, hashtag, url, thumbnails, category);
						

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}

				return vo;
			}	
			
			//****��ü ���� ����****
			public ArrayList<MediaVO> mediaAllList() {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media order by media_id";
				try {
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					while (rs.next()) {
						
						String media_id = rs.getString(1);
						String title = rs.getString(2);
						String channel = rs.getString(3);
						int up = rs.getInt(4);
						int down = rs.getInt(5);
						int views = rs.getInt(6);
						String running_time = rs.getString(7);
						Date dates = rs.getDate(8);
						String hashtag = rs.getString(9);
						String url = rs.getString(10);
						String thumbnails = rs.getString(11);
						String category = rs.getString(12);
						
						MediaVO vo = new MediaVO(media_id, title, channel, up, down, views, running_time, dates, hashtag, url, thumbnails, category);
						list.add(vo);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}

				return list;
			}	
			
			//****Ű����� ���ϴ� ���� �˻�****
			public ArrayList<MediaVO> mediaSearch(String keyword) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where title like '%"+keyword+"%' or channel like '%"+keyword+"%'";
				try {
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					while (rs.next()) {
						
						String media_id = rs.getString(1);
						String title = rs.getString(2);
						String channel = rs.getString(3);
						int up = rs.getInt(4);
						int down = rs.getInt(5);
						int views = rs.getInt(6);
						String running_time = rs.getString(7);
						Date dates = rs.getDate(8);
						String hashtag = rs.getString(9);
						String url = rs.getString(10);
						String thumbnails = rs.getString(11);
						String category = rs.getString(12);
						
						MediaVO vo = new MediaVO(media_id, title, channel, up, down, views, running_time, dates, hashtag, url, thumbnails, category);
						list.add(vo);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}

				return list;
			}	
			
			
			
			//****���ƿ� ++ ****
			public int upcntUpdate(String media_id) {
				conn = getConn();
				int cnt = 0;
				String sql = "update media set up = up + 1 where media_id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, media_id);
					cnt = pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				return cnt;
				
			}		
			
			//****�Ⱦ�� ++ ****
			public int downcntUpdate(String media_id) {
				conn = getConn();
				int cnt = 0;
				String sql = "update media set down = down + 1 where media_id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, media_id);
					cnt = pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				return cnt;
				
			}
			
			//****��ȸ�� ++ ****
			public int viewcntUpdate(String media_id) {
				conn = getConn();
				int cnt = 0;
				String sql = "update media set views = views + 1 where media_id = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, media_id);
					cnt = pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				return cnt;
				
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

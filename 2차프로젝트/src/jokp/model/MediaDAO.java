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
	// 영상id로 영상의 모든 정보 가져오기 : mediainfoList
	// 좋아요나 싫어요 눌렀을때 올라가는거 : upcntUpdate, downcntUpdate
	// 조회수 올라가는거 : viewcntUpdate
	// 키워드 기반 검색 : mediaSearch
	// 모든 영상 정보 : mediaAllList
	//
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	static {
		try { // DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("왜에러???1");
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
	
	//****영상 id로 정보 보기 기능****
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
			
			//****전체 영상 정보****
			public ArrayList<MediaVO> mediaAllList() {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from (select * from media order by dbms_random.value)";
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
			
			//****키워드로 원하는 영상 검색****
			public ArrayList<MediaVO> mediaSearch(String keyword) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where title like '%"+keyword+"%' or channel like '%"+keyword+"%' or category like '%"+keyword+"%' or hashtag like '%"+keyword+"%'";
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
			
			
			
			//****좋아요 ++ ****
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
			
			//****싫어요 ++ ****
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
			
			//****조회수 ++ ****
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
			
			
			
			
			
			
			//****전체 영상 정보****
			public ArrayList<MediaVO> MyMediaList1(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where media_id in (select media_id from temp where user_id = ? and list = 0) order by media_id";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			//****전체 영상 정보****
			public ArrayList<MediaVO> MyMediaList2(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where media_id in (select media_id from temp where user_id = ? and list = 1) order by media_id";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			//****전체 영상 정보****
			//****전체 영상 정보****
			public ArrayList<MediaVO> MyMediaList3(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from (select * from media where media_id in (select media_id from temp where user_id = ?) order by dates) where rownum <= 3";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			
			public ArrayList<MediaVO> MyHistoryList(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from (select * from media where media_id in (select media_id from (select * from storage where user_id = ? and upcheck not like '1' order by visit_time desc) where rownum<=5))";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			public ArrayList<MediaVO> MyLikeList(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where media_id in (select media_id from storage where upcheck='1' and user_id = ?)";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			//****전체 영상 정보****
			public ArrayList<MediaVO> MyMediaListM(String user_id) {
				ArrayList<MediaVO> list = new ArrayList<MediaVO>();
				conn = getConn();
				String sql = "select * from media where media_id in (select media_id from temp where user_id = ? and list = 2) order by media_id";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,user_id);
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
			
			
			//****싫어요 눌렀을 때 다른 영상 추천****
			public MediaVO othermediainfoList(String media_id) {
				MediaVO vo = null;
				conn = getConn();
				String sql = "select * from(select * from media where category not like (select category from media where media_id = ?) order by dbms_random.random) where rownum = 1";
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
			
			//****좋아요 누를때 비슷 영상 추천****
			public MediaVO simmediainfoList(String media_id) {
				MediaVO vo = null;
				conn = getConn();
				String sql = "select * from(select * from media where category like (select category from media where media_id = ?) order by dbms_random.random) where rownum = 1";
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

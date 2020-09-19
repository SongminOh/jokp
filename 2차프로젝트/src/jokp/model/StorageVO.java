package jokp.model;

import java.sql.Timestamp;

public class StorageVO {
	
	private String user_id;
	private String media_id;
	private Timestamp playtime;
	private char upcheck;
	private Timestamp visit_time;
	//재생했던 날짜 저장하는게 없다...db에 컬럼추가해야된다...!
	
	
	
	public StorageVO() {
	}
	public StorageVO(String user_id, String media_id, Timestamp playtime, char upcheck, Timestamp visit_time) {
		this.user_id = user_id;
		this.media_id = media_id;
		this.playtime = playtime;
		this.upcheck = upcheck;
		this.visit_time = visit_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public Timestamp getPlaytime() {
		return playtime;
	}
	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}
	public char getUpcheck() {
		return upcheck;
	}
	public void setUpcheck(char upcheck) {
		this.upcheck = upcheck;
	}
	public Timestamp getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Timestamp visit_time) {
		this.visit_time = visit_time;
	}
	
	
	
	
	
	
}

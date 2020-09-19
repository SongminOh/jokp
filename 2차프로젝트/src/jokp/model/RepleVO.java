package jokp.model;

public class RepleVO {
	
	private String reple_id;
	private String user_id;
	private String media_id;
	private String content;
	
	
	
	public RepleVO() {
	}


	public RepleVO(String reple_id, String user_id, String media_id, String content) {
		this.reple_id = reple_id;
		this.user_id = user_id;
		this.media_id = media_id;
		this.content = content;
	}
	
	
	public String getReple_id() {
		return reple_id;
	}
	public void setReple_id(String reple_id) {
		this.reple_id = reple_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

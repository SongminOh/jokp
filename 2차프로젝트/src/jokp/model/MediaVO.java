package jokp.model;

public class MediaVO {
	private String media_id;
	private String title;
	private String channel;
	private int up;
	private int down;
	private int views;
	private String running_time;
	private String dates;
	private String hashtag;
	private String url;
	private String thumbnails;
	private String category;
	
	
	
	public MediaVO() {
	}
	
	public MediaVO(String media_id, String title, String channel, int up, int down, int views, String running_time,
			String dates, String hashtag, String url, String thumbnails, String category) {
		this.media_id = media_id;
		this.title = title;
		this.channel = channel;
		this.up = up;
		this.down = down;
		this.views = views;
		this.running_time = running_time;
		this.dates = dates;
		this.hashtag = hashtag;
		this.url = url;
		this.thumbnails = thumbnails;
		this.category = category;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getRunning_time() {
		return running_time;
	}
	public void setRunning_time(String running_time) {
		this.running_time = running_time;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}

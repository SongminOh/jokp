package jokp.model;

public class UsersVO {
	private String user_id;
	private String pw;
	private String name;
	private int age;
	private String job;
	private String preference;
	private String set_time;
	
	
	public UsersVO() {
	}
	
	public UsersVO(String user_id, String pw, String name, int age, String job, String preference, String set_time) {
		this.user_id = user_id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.job = job;
		this.preference = preference;
		this.set_time = set_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getSet_time() {
		return set_time;
	}
	public void setSet_time(String set_time) {
		this.set_time = set_time;
	}
	
	
	
}
package ywy.chapter3.mydb;

public class LoginInfo {
	private String id;
	private String password;
	private String passwordErrorCount;
	private String passwordErrorDate;
	private UserInfo userInfo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordErrorCount() {
		return passwordErrorCount;
	}
	public void setPasswordErrorCount(String passwordErrorCount) {
		this.passwordErrorCount = passwordErrorCount;
	}
	public String getPasswordErrorDate() {
		return passwordErrorDate;
	}
	public void setPasswordErrorDate(String passwordErrorDate) {
		this.passwordErrorDate = passwordErrorDate;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}

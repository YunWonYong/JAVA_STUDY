package ywy.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;

//SOLID => SRP, OCP, LSP, ISP, DIP
public class JDBCManager {
	public static class Builder { //SRP ==> Single Responsibility Principle ==> 높은 응집도 유도할 수 있음., DIR ==> Don't your self repeat
		private String driver;
		private String url;
		private String userName;
		private String password;
		
		public Builder setDriver(String driver) {
			this.driver = driver;
			return this;
		}
		
		public Builder setUrl(String url) {
			this.url = url;
			return this;
		}
		
		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}
		
		public Builder setPassword(String password ) {
			this.password = password;
			return this;
		}
		
		public JDBCManager build() throws Exception {
			initArgumentValidate();
			Class.forName(driver);
			return new JDBCManager(DriverManager.getConnection(url, userName, password));
		}
		
		private void initArgumentValidate() {
			String[] arguements = new String[] {this.driver, this.url, this.userName, this.password};
			for (String arguement : arguements) {
				if (Utility.isNullOrBlank(arguement)) {
					throw new IllegalArgumentException(String.format("not init variable: %s", arguement));
				}
			}
		}
		
	}
	
	private Connection conn = null;
	
	private JDBCManager(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}

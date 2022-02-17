package ywy.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;

//SOLID => SRP, OCP, LSP, ISP, DIP
public class JDBCManager {
	public static class Builder { //SRP ==> Single Responsibility Principle ==> 높은 응집도 유도할 수 있음., DIR ==> Don't your self repeat
		private final String DEFAULT_DRIVER;
		private String driver;
		private String url;
		private String userName;
		private String password;
		
		public Builder() {
			DEFAULT_DRIVER = null;
		}
		public Builder(DBMS dbms) {
			DEFAULT_DRIVER = dbms.getDefaultDriver();
		}
		
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
			return initArgumentValidate().driverLoad().managerInstance();
		}
		
		private String getDriver() {
			return Utility.isNullOrBlank(driver) ? DEFAULT_DRIVER: driver; 
		}
		
		private Builder initArgumentValidate() {
			String[] arguements = new String[] {getDriver(), this.url, this.userName, this.password};
			for (String arguement : arguements) {
				if (Utility.isNullOrBlank(arguement)) {
					throw new IllegalArgumentException(String.format("not init variable: %s", arguement));
				}
			}
			return this;
		}
		
		private Builder driverLoad() throws Exception {
			Class.forName(Utility.isNullOrBlank(driver) ? DEFAULT_DRIVER : driver);
			return this;
		}
		
		private JDBCManager managerInstance() throws Exception {
			return new JDBCManager(DriverManager.getConnection(url, userName, password));
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

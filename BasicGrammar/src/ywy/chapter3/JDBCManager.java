package ywy.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//SOLID => SRP, OCP, LSP, ISP, DIP
public class JDBCManager {
	public static class Builder { // SRP ==> Single Responsibility Principle ==> 높은 응집도 유도할 수 있음., DIR ==> Don't your self repeat
		private final String DEFAULT_DRIVER;
		String driver;
		String url;
		String userName;
		String password;
		String dbmsNm;

		public Builder() {
			DEFAULT_DRIVER = null;
		}

		public Builder(DBMS dbms) {
			DEFAULT_DRIVER = dbms.getDefaultDriver();
			dbmsNm = dbms.getDbmsNm();
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

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public JDBCManager build() throws Exception {
			return initArgumentValidate().driverLoad().attemptToConnect().managerInstance();
		}

		private String getDriver() {
			return Utility.isNullOrBlank(driver) ? DEFAULT_DRIVER : driver;
		}

		private Builder initArgumentValidate() {
			String[] arguements = new String[] { getDriver(), this.url, this.userName, this.password };
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

		private Builder attemptToConnect() throws Exception {
			Connection conn = DriverManager.getConnection(url, userName, password);
			if (conn == null) {
				throw new Exception();
			}
			conn.close();
			return this;
		}

		private JDBCManager managerInstance() throws Exception {

			return new JDBCManager(this);
		}

	}

	private final Builder info;

	private JDBCManager(Builder info) {
		this.info = info;
	}
	
	public String getLoadDriver() {
		return this.info.getDriver();
	}

	public String getLoadDbmsNm() {
		return this.info.dbmsNm;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(info.url, info.userName, info.password);
	}
	
	public void close(Object...objs) throws Exception {
		for (Object obj: objs) {
			if (obj instanceof ResultSet) {
				((ResultSet) obj).close();
			} else if (obj instanceof PreparedStatement) {
				((PreparedStatement) obj).close();
			} else if (obj instanceof Connection) {
				((Connection) obj).close();
			}
		}
	}
}

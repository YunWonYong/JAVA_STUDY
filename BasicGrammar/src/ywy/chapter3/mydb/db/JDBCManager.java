package ywy.chapter3.mydb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ywy.chapter3.Utility;

//SOLID => SRP, OCP, LSP, ISP, DIP
public class JDBCManager {
	static class Builder { // SRP ==> Single Responsibility Principle ==> 높은 응집도 유도할 수 있음., DIR ==> Don't your self repeat
		private final String DEFAULT_DRIVER;
		String driver;
		String url;
		String userName;
		String password;
		String dbmsNm;

		Builder() {
			DEFAULT_DRIVER = null;
		}

		Builder(DBMS dbms) {
			DEFAULT_DRIVER = dbms.getDefaultDriver();
			dbmsNm = dbms.getDbmsNm();
		}

		Builder setDriver(String driver) {
			this.driver = driver;
			return this;
		}

		Builder setUrl(String url) {
			this.url = url;
			return this;
		}

		Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}

		Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		JDBCManager build() throws Exception {
			return initArgumentValidate().driverLoad().attemptToConnect().managerInstance();
		}

		String getDriver() {
			return Utility.isNullOrBlank(driver) ? DEFAULT_DRIVER : driver;
		}

		Builder initArgumentValidate() {
			String[] arguements = new String[] { getDriver(), this.url, this.userName, this.password };
			for (String arguement : arguements) {
				if (Utility.isNullOrBlank(arguement)) {
					throw new IllegalArgumentException(String.format("not init variable: %s", arguement));
				}
			}
			return this;
		}

		Builder driverLoad() throws Exception {
			Class.forName(Utility.isNullOrBlank(driver) ? DEFAULT_DRIVER : driver);
			return this;
		}

		Builder attemptToConnect() throws Exception {
			Connection conn = DriverManager.getConnection(url, userName, password);
			if (conn == null) {
				throw new Exception();
			}
			conn.close();
			return this;
		}

		JDBCManager managerInstance() throws Exception {
			return new JDBCManager(this);
		}

	}

	private final Builder INFO;

	private JDBCManager(Builder info) {
		this.INFO = info;
	}
	
	public String getLoadDriver() {
		return this.INFO.getDriver();
	}

	public String getLoadDbmsNm() {
		return this.INFO.dbmsNm;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(INFO.url, INFO.userName, INFO.password);
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

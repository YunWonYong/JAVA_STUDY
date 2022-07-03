package ywy.chapter3.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.InvalidPathException;
import java.util.Properties;

import javax.naming.OperationNotSupportedException;

public abstract class JDBCManagerFactory {
	
	private static String ROOT = System.getProperty("user.dir");
	
	public static JDBCManager getJDBCManager(String propertisePath) throws Exception {
		Properties properties = null;
		try {
			properties = getProperties(propertisePath);
			String driver = getDBDriver(properties.getProperty("DB"));
			return new JDBCManager.Builder()
							 	  .setDriver(driver)
								  .setUrl(properties.getProperty("URL"))
								  .setUserName(properties.getProperty("USER_NAME"))
								  .setPassword(properties.getProperty("PASSWORD"))
								  .build();
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static Properties getProperties(String propertiesPath) throws Exception {
		InputStream inputStream = null;
		Properties properties = null;
		try {
			String path = ROOT + propertiesPath;
			File file = new File(path);
			if (!file.exists()) {
				throw new InvalidPathException(path, "not found");
			}
			
			inputStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inputStream);
			return properties;
		} catch(Exception e) {
			throw e;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	private static String getDBDriver(String dbName) throws Exception {
		DBMS driver = null;
		switch (dbName) {
		case "MY_SQL":
			driver = DBMS.MY_SQL;
			break;
		case "ORACLE":
			driver = DBMS.ORACLE;
			break;
		case "MS_SQL":
			driver = DBMS.MS_SQL;
			break;
		case "POSTGRE_SQL":
			driver = DBMS.POSTGRE_SQL;
			break;
		default:
			throw new OperationNotSupportedException(String.format("not supproted %s", dbName));
		}
		return driver.getDefaultDriver();
	}
	

}

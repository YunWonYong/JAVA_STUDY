package ywy.chapter3;

public enum DBMS {
	ORACLE("oracle.jdbc.OracleDriver"),
	MY_SQL("com.mysql.cj.jdbc.Driver"),
	MS_SQL("");
	
	private String defaultDriver;
	DBMS(String driver) {
		defaultDriver = driver;
	}
	
	public String getDefaultDriver() {
		return defaultDriver;
	}
}

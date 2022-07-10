package ywy.chapter3.mydb.db;

public enum DBMS {
	ORACLE("oracle.jdbc.OracleDriver"),
	MY_SQL("com.mysql.cj.jdbc.Driver"),
	MS_SQL(""),
	POSTGRE_SQL("org.postgresql.Driver");
	
	private String defaultDriver;
	DBMS(String driver) {
		defaultDriver = driver;
	}
	
	public String getDefaultDriver() {
		return this.defaultDriver;
	}
	
	public String getDbmsNm() {
		return this.name();
	}
}

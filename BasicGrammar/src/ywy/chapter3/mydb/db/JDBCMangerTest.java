package ywy.chapter3.mydb.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

public class JDBCMangerTest {

	@Test(expected = IllegalArgumentException.class)
	public void testBuilderIllegalArgumentsException() throws Exception{
		new JDBCManager.Builder().build();
	}
	
	@Test
	public void testGetOracleJDBCManager() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.ORACLE)
				 .setUrl("jdbc:oracle:thin:@localhost:1521:oracle")
				 .setUserName("ywy")
				 .setPassword("921107")
				 .build();
		assertTrue(jdbcManager != null);
	}
	
	@Test
	public void testGetMySqlJDBCManager() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.MY_SQL)
				 .setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=UTC")
				 .setUserName("root")
				 .setPassword("921107")
				 .build();
		assertTrue(jdbcManager != null);
	}
	
//	@Test
//	public void testGetPostgresqlJDBCManager() throws Exception {
//		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.POSTGRESQL)
//				 .setUrl("jdbc:postgresql://localhost:5432")
//				 .setUserName("postgres")
//				 .setPassword("921107")
//				 .build();
//		assertTrue(jdbcManager != null);
//	}
//	
	
	@Test
	public void testGetLoadDriver() throws Exception {
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.ORACLE)
				 .setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=UTC")
				 .setUserName("root")
				 .setPassword("921107")
				 .build();
		assertEquals(jdbcManager.getLoadDbmsNm(), DBMS.ORACLE.getDbmsNm());
	}

	@Test
	public void testGetConnection() throws Exception {
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.ORACLE)
				 .setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=UTC")
				 .setUserName("root")
				 .setPassword("921107")
				 .build();
		assertTrue(jdbcManager.getConnection() instanceof Connection);
	}
	
}

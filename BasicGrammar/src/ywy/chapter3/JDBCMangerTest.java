package ywy.chapter3;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

public class JDBCMangerTest {

	@Test(expected = IllegalArgumentException.class)
	public void testBuilderIllegalArgumentsException() throws Exception{
		new JDBCManager.Builder(DBMS.ORACLE).setDriver(null).build();
	}
	
	@Test
	public void testGetOracleJDBCManager() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.ORACLE)
										 .setUrl("jdbc:oracle:thin:@localhost:1521:oracle")
										 .setUserName("ywy")
										 .setPassword("921107")
										 .build();
		assertTrue(jdbcManager != null);
		assertTrue(jdbcManager.getConnection() != null);
		assertTrue(jdbcManager.getConnection() instanceof Connection);
	}
	
	@Test
	public void testGetMySqlJDBCManager() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder(DBMS.MY_SQL)
										 .setUrl("jdbc:mysql://localhost:3306/world?serverTimezone=UTC")
										 .setUserName("root")
										 .setPassword("921107")
										 .build();
		assertTrue(jdbcManager != null);
		assertTrue(jdbcManager.getConnection() != null);
		assertTrue(jdbcManager.getConnection() instanceof Connection);
		
	}
	
}

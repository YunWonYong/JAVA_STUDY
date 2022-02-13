package ywy.chapter3;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.Test;

public class JDBCMangerTest {

	@Test(expected = IllegalArgumentException.class)
	public void testBuilderIllegalArgumentsException() throws Exception{
		new JDBCManager.Builder().setDriver(null).build();
	}
	
	@Test
	public void testGetJDBCManager() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder()
										 .setDriver("oracle.jdbc.OracleDriver")
										 .setUrl("jdbc:oracle:thin:@localhost:1521:oracle")
										 .setUserName("ywy")
										 .setPassword("921107")
										 .build();
		assertTrue(jdbcManager != null);
	}
	
	@Test
	public void testGetConnection() throws Exception { //AAA => 준비, 실행, 단언
		JDBCManager jdbcManager = new JDBCManager.Builder()
										 .setDriver("oracle.jdbc.OracleDriver")
										 .setUrl("jdbc:oracle:thin:@localhost:1521:oracle")
										 .setUserName("ywy")
										 .setPassword("921107")
										 .build();
		assertTrue(jdbcManager.getConnection() != null);
		assertTrue(jdbcManager.getConnection() instanceof Connection);
	}
	
}

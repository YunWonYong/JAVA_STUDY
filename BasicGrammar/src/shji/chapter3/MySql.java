package shji.chapter3;

import java.sql.*;

public class MySql {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		String url = "jdbc:mysql://localhost:3306/ex?serverTimezone=UTC";
		String id = "shji";
		String password = "010723";		// root password도 동일함
		Connection con = DriverManager.getConnection(url, id, password);
		System.out.println(con);
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT 1 AS DUAL ")
//		   .append("FROM DUAL ");
		sql.append("INSERT INTO _TDAEmp(EmpSeq, EmpName, Age) ")
		   .append("VALUES(?, ?, ?) ");
		PreparedStatement pstm = con.prepareStatement(sql.toString());
		pstm.setString(1, "2");
		pstm.close();
		con.close();
		
		
	}

}

package ywy.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	// GOD Class, 스파게티 코드, KISS
	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String url = "jdbc:oracle:thin:@localhost:1521:oracle";
		String id = "ywy";
		String password = "921107";
		Connection con = DriverManager.getConnection(url, id, password);
		System.out.println(con);
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT  1 AS NS")
//		   .append("  FROM  DUAL");
		sql.append("INSERT INTO STUDENT(ID, NAME, AGE, GENDER) ")
		   .append("VALUES(?, ?, ?, ?)");
//		sql.append("DELETE FROM STUDENT ")
//		   .append("WHERE ID = ?");
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, "V000");
		pstmt.setString(2, "윤원용");
		pstmt.setInt(3, 31);
		pstmt.setString(4, "M");
		if (pstmt.executeUpdate() > 0) {
			sql.replace(0, sql.length(), "")
			   .append("SELECT  A.ID ")
			   .append("     ,  A.NAME ")
			   .append("     ,  A.AGE ")
			   .append("     ,  A.GENDER ")
			   .append("  FROM  STUDENT A")
			   .append(" WHERE  A.ID = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "V000");
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs.next());
			System.out.println(rs.getString("ID"));
			System.out.println(rs.getString("NAME"));
			System.out.println(rs.getInt("AGE"));
			System.out.println(rs.getString("GENDER"));
			rs.close();
			return;
		}
		System.out.println("생성 실패");
		pstmt.close();
		con.close();
	}

}

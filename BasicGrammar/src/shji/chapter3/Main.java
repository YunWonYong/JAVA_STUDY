package shji.chapter3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) throws Exception {
		String driver  = "oracle.jdbc.OracleDriver";
		Class.forName(driver);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##shji";
		String password = "010723";
		Connection con = DriverManager.getConnection(url, id, password);
		System.out.println(con);
		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT 1 AS NS")
//		   .append(" FROM DUAL");	
		sql.append("INSERT INTO STUDENT(ID, NAME, AGE, GENDER) ")
		   .append("VALUES(?, ?, ?, ?) ");
//		sql.append("DELETE FROM STUDENT ")
//		   .append("WHERE ID = ? ");
		PreparedStatement psts = con.prepareStatement(sql.toString());
		psts.setString(1, "V000");
		psts.setString(2, "서향");
		psts.setInt(3, 22);
		psts.setString(4, "W");
		if(psts.executeUpdate() > 0) {
			sql.replace(0, sql.length(), "")
				.append("SELECT A.ID ")
				.append("	   ,A.NAME ")
				.append(" 	   ,A.AGE ")
				.append("      ,A.GENDER ")
				.append("  FROM STUDENT A ")
				.append(" WHERE A.ID = ? ");
			psts = con.prepareStatement(sql.toString());
			psts.setString(1, "V000");
			ResultSet rs = psts.executeQuery();
				System.out.println(rs.next());
				System.out.println(rs.getString("ID"));
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getInt("AGE"));
				System.out.println(rs.getString("GENDER"));
				rs.close();
			return;
		}
		System.out.println("삭제 실패");
		psts.close();
		con.close();		
	//	psts.execute();
	//	ResultSet rs = psts.executeQuery();
	//	System.out.println(rs.next());
	//	System.out.println(rs.getString("NS"));
	}

}

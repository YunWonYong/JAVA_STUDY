package ywy.chapter3.mydb.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.db.JDBCManager;
import ywy.chapter3.mydb.users.UserDAO;

public class LoginDAO {

	public Model login(JDBCManager db, String id, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			StringBuffer sb = new StringBuffer();
			String query = sb.append("SELECT  1 AS SUCCESS ")
					         .append("  FROM  login_info")
					         .append(" WHERE  ID = ?")
					         .append("   AND  PASSWORD = ?")
					         .toString();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("SUCCESS").equals("1")) {
					return new UserDAO().getInfo(db, id);
				}
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 		return null;
	}
}

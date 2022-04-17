package ywy.chapter3.mydb.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ywy.chapter3.JDBCManager;

public class UserDAO {
	
	public UserModel getInfo(JDBCManager db, String id) {
		UserModel user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String query = new StringBuffer()
						   .append("SELECT  ID")
						   .append("     ,  NAME")
						   .append("     ,  ENG_NAME")
						   .append("     ,  GENDER")
						   .append("     ,  BIRTH_DATE")
						   .append("     ,  REAL_NUMBER")
						   .append("     ,  ZIP_CODE")
						   .append("     ,  ADDRESS")
						   .append("     ,  ADDRESS_DTL")
						   .append("     ,  EMAIL")
						   .append("     ,  EMAIL_ADDRESS")
						   .append("     ,  PHONE_NUMBER")
						   .append("  FROM  user_info")
						   .append(" WHERE  ID = ?")
						   .toString();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserModel();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setEngName(rs.getString("ENG_NAME"));
				user.setGender(rs.getString("GENDER"));
				user.setBirthDate(rs.getString("BIRTH_DATE"));
				user.setRealNumber(rs.getString("REAL_NUMBER"));
				user.setZipCode(rs.getString("ZIP_CODE"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setAddressDtl(rs.getString("ADDRESS_DTL"));
				user.setEmail(rs.getString("EMAIL"));
				user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
				user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(rs, pstmt, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return user;
	}
}

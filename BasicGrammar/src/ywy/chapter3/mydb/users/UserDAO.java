package ywy.chapter3.mydb.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ywy.chapter3.JDBCManager;
import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.login.LoginModel;

public class UserDAO {

	public UserModel getInfo(JDBCManager db, String id) {
		UserModel user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String query = new StringBuffer().append("SELECT  uinfo.ID").append("     ,  uinfo.NAME")
					.append("     ,  uinfo.ENG_NAME").append("     ,  uinfo.GENDER").append("     ,  uinfo.BIRTH_DATE")
					.append("     ,  uinfo.REAL_NUMBER").append("     ,  uinfo.ZIP_CODE")
					.append("     ,  uinfo.ADDRESS").append("     ,  uinfo.ADDRESS_DTL").append("     ,  uinfo.EMAIL")
					.append("     ,  uinfo.EMAIL_ADDRESS").append("     ,  uinfo.PHONE_NUMBER").append("     ,  CASE")
					.append("            WHEN NOT pinfo.PROFESSOR_CODE IS NULL THEN '교수'")
					.append("            WHEN NOT sinfo.STUDENT_CODE IS NULL THEN '학생'").append("            ELSE NULL")
					.append("        END AS GRADE").append("  FROM  user_info uinfo").append("  LEFT  OUTER")
					.append("  JOIN  professor pinfo").append("    ON  pinfo.ID = uinfo.ID").append("  LEFT  OUTER")
					.append("  JOIN  student sinfo").append("    ON  sinfo.ID = uinfo.ID")
					.append(" WHERE  uinfo.ID = ?").toString();
			System.out.println(query);
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
				user.setDiv(rs.getString("GRADE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(rs, pstmt, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public Model userRegister(Scanner sc, JDBCManager db, UserModel user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			String id = null;
			while(true) {
				System.out.println("사용하실 아이디를 입력해 주세요.");
				id = sc.nextLine();	
				if (userDuplicate(id, db)) {
					break;
				}
				System.out.println("중복입니다.");
			}
			System.out.println("비밀번호를 입력해 주세요.");
			String pw = sc.nextLine();
			String query = new StringBuffer()
						   .append("INSERT INTO login_info(ID, PASSWORD)")
						   .append("VALUES(?, ?)")
					       .toString();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			int result = pstmt.executeUpdate();
			if (result != 1) {
				System.out.println("login info insert fail!!!");
				return null;
			}

			query = new StringBuffer()
						   .append("INSERT INTO user_info(ID, NAME, ENG_NAME, GENDER, BIRTH_DATE, REAL_NUMBER, ZIP_CODE, ADDRESS, ADDRESS_DTL, EMAIL, EMAIL_ADDRESS, PHONE_NUMBER)")
						   .append("VALUES(?, ?, ?, ?, ?, ?, 1, ?, ?, ?, ?, ?)")
					       .toString();
			pstmt.executeUpdate(query);
			pstmt.setString(1, id);
			System.out.println("성명을 입력해주세요.");
			String name = sc.nextLine();
			pstmt.setString(2, name);
			System.out.println("영문 성명을 입력해주세요.");
			String engName = sc.nextLine();
			pstmt.setString(3, engName);
			System.out.println("1. 남성, 2. 여성");
			String gender = sc.nextLine();
			pstmt.setString(4, gender);

			System.out.println("생년월일을 입력해주세요. ex) 19921107");
			String birth = sc.nextLine();
			pstmt.setString(5, birth);
			
			System.out.println("주민번호를 입력해주세요.");
			String realNumber = sc.nextLine();
			pstmt.setString(6, realNumber);
			
			System.out.println("우편번호를 입력해주세요.");
			String zipCode = sc.nextLine();
			pstmt.setInt(7, Integer.parseInt(zipCode));
			
			pstmt.setString(8, "");
			pstmt.setString(9, "");
			pstmt.setString(10, "");
			pstmt.setString(11, "");
			pstmt.setString(12, "");
			result = pstmt.executeUpdate();
			if(result != 1) {
				return null;
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		} finally {
			try {
				db.close(pstmt, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return user;
	}
	
	public boolean userDuplicate(String id, JDBCManager db) {
		String query = new StringBuffer()
					   .append("SELECT  1")
					   .append("  FROM  login_info")
					   .append(" WHERE  ID = ?")
				       .toString();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				db.close(rs, pstmt, conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}

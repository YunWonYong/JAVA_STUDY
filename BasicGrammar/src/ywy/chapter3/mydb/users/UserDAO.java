package ywy.chapter3.mydb.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.db.JDBCManager;
import ywy.chapter3.mydb.major.MajorModel;

public class UserDAO {
	
	private String id; 
	
	public UserModel getInfo(JDBCManager db, String id) {
		UserModel user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String query = new StringBuffer()
						   .append("SELECT  uinfo.ID")
						   .append("     ,  uinfo.NAME")
					       .append("     ,  uinfo.ENG_NAME")
					       .append("     ,  uinfo.GENDER")
					       .append("     ,  uinfo.BIRTH_DATE")
					       .append("     ,  uinfo.REAL_NUMBER")
					       .append("     ,  uinfo.ZIP_CODE")
					       .append("     ,  uinfo.ADDRESS")
					       .append("     ,  uinfo.ADDRESS_DTL")
					       .append("     ,  uinfo.EMAIL")
					       .append("     ,  uinfo.EMAIL_ADDRESS")
					       .append("     ,  uinfo.PHONE_NUMBER")
					       .append("     ,  CASE")
					       .append("            WHEN NOT pinfo.PROFESSOR_CODE IS NULL THEN '교수'")
					       .append("            WHEN NOT sinfo.STUDENT_CODE IS NULL THEN '학생'")
					       .append("            ELSE NULL")
					       .append("        END AS GRADE")
					       .append("  FROM  user_info uinfo")
					       .append("  LEFT  OUTER")
					       .append("  JOIN  professor pinfo")
					       .append("    ON  pinfo.ID = uinfo.ID")
					       .append("  LEFT  OUTER")
					       .append("  JOIN  student sinfo")
					       .append("    ON  sinfo.ID = uinfo.ID")
					       .append(" WHERE  uinfo.ID = ?")
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
	
	public Model studentRegister(Scanner sc, JDBCManager db, UserModel user) {
		Connection conn = null;
		PreparedStatement pstmtStudent = null;
		PreparedStatement pstmtStudentGrade = null;
		try {
			conn = userRegister(sc, db);
			String query = new StringBuffer()
							   .append("INSERT INTO student(STUDENT_CODE, ID, ENT_DATE, GRADE)")
							   .append("VALUES(  ?")
							   .append("       , ?")
							   .append("       , (SELECT  DATE_FORMAT(NOW(), '%Y%m%d'))")
							   .append("       , '1'")
							   .append("      )")
						       .toString();
			pstmtStudent = conn.prepareStatement(query);
			String studentCode = getNextStudentCode(db);
			pstmtStudent.setString(1, studentCode);
			pstmtStudent.setString(2, id);
			int result = pstmtStudent.executeUpdate();
			if (result != 1) {
				System.out.println("학생 등록 실패!!!");
				return null;
			}
			
			List<MajorModel> list = getMajor(db);
			if(list == null || list.size() == 0) {
				return null;
			}
			
			StringBuffer sb = new StringBuffer();
			int index = 0;
			int range = list.size();
			while (index < range) {
				sb.append(++index)
				  .append(". ")
				  .append(list.get(index - 1).getMajorName());
				if (index == range) {
					break;
				}
				sb.append(" ");
			}
			System.out.println(sb.toString());
			int myMajor = Integer.parseInt(sc.nextLine());
			MajorModel major = list.get(myMajor - 1);
			query = new StringBuffer()
					.append("INSERT INTO student_grade(GRADE, STUDENT_CODE, MAJOR_CODE)")
					.append("VALUES('1', ?, ?)")
					.toString();
			pstmtStudentGrade = conn.prepareStatement(query);
			pstmtStudentGrade.setString(1, studentCode);
			pstmtStudentGrade.setString(2, major.getMajorCode());
			result = pstmtStudentGrade.executeUpdate();
			if (result != 1) {
				System.out.println("학과 생성 실패!!!");
				return null;
			}
			conn.commit();
			return user;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					db.close(pstmtStudent, pstmtStudentGrade, conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Connection userRegister(Scanner sc, JDBCManager db) throws Exception {
		Connection conn = null;
		PreparedStatement pstmtLogin = null;
		PreparedStatement pstmtUser = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			while(true) {
				System.out.println("사용하실 아이디를 입력해 주세요.");
				id = sc.nextLine();	
				if (userDuplicate(id, db) == false) {
					System.out.println("사용하셔도 좋은 아이디입니다.");
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
			pstmtLogin = conn.prepareStatement(query);
			pstmtLogin.setString(1, id);
			pstmtLogin.setString(2, pw);
			
			int result = pstmtLogin.executeUpdate();
			if (result != 1) {
				System.out.println("login info insert fail!!!");
				return null;
			}

			query = new StringBuffer()
						   .append("INSERT INTO user_info(ID, NAME, ENG_NAME, GENDER, BIRTH_DATE, REAL_NUMBER, ZIP_CODE, ADDRESS, ADDRESS_DTL, EMAIL, EMAIL_ADDRESS, PHONE_NUMBER)")
						   .append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
					       .toString();
			pstmtUser = conn.prepareStatement(query);
			pstmtUser.setString(1, id);
			System.out.println("성명을 입력해주세요.");
			String name = sc.nextLine();
			pstmtUser.setString(2, name);
			System.out.println("영문 성명을 입력해주세요.");
			String engName = sc.nextLine();
			pstmtUser.setString(3, engName);
			System.out.println("1. 남성, 2. 여성");
			String gender = sc.nextLine();
			pstmtUser.setString(4, gender);

			System.out.println("생년월일을 입력해주세요. ex) 19921107");
			String birth = sc.nextLine();
			pstmtUser.setString(5, birth);
			
			System.out.println("주민번호를 입력해주세요.");
			String realNumber = sc.nextLine();
			pstmtUser.setString(6, realNumber);
			
			System.out.println("우편번호를 입력해주세요.");
			String zipCode = sc.nextLine();
			pstmtUser.setInt(7, Integer.parseInt(zipCode));
			
			pstmtUser.setString(8, "");
			pstmtUser.setString(9, "");
			pstmtUser.setString(10, "");
			pstmtUser.setString(11, "");
			pstmtUser.setString(12, "");
			result = pstmtUser.executeUpdate();
			if(result != 1) {
				System.out.println("사용자 등록 실패!!!");
				return null;
			}
			return conn;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				db.close(pstmtLogin, pstmtUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getNextStudentCode(JDBCManager db) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String query = new StringBuffer() 
					   .append("SELECT  CONCAT('S', A.CODE) AS STUDENT_CODE")
					   .append("  FROM  (")
					   .append("         SELECT  LPAD(IFNULL(MAX(CAST(SUBSTRING(STUDENT_CODE, 2, 10) AS unsigned)),0) + 1, 9, 0) AS CODE")
					   .append("           FROM  student")
					   .append("        ) as A")
				       .toString();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("STUDENT_CODE");
			}
		} catch(Exception e) {
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
			if(rs.next()) {
				return true;
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
		return false;
	}
	
	public List<MajorModel> getMajor(JDBCManager db) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MajorModel> list = new ArrayList<MajorModel>();
		MajorModel major = null;
		try {
			conn = db.getConnection();
			String query = new StringBuffer()
						   .append("SELECT  MAJOR_CODE")
						   .append("     ,  PROFESSOR_HEAD_USER_CODE")
						   .append("     ,  MAJOR_NAME")
						   .append("     ,  MAJOR_PHONE_NUMBER")
						   .append("     ,  USE_YN")
						   .append("  FROM  major")
						   .append(" WHERE  USE_YN = 'Y'")
						   .toString();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				major = new MajorModel();
				major.setMajorCode(rs.getString("MAJOR_CODE"));
				major.setProfessorHeadUserCode(rs.getString("PROFESSOR_HEAD_USER_CODE"));
				major.setMajorName(rs.getString("MAJOR_NAME"));
				major.setMajorPhoneNumber(rs.getString("MAJOR_PHONE_NUMBER"));
				list.add(major);
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
		return list;
	}
}

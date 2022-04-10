package ywy.chapter3.mydb;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import ywy.chapter3.DBMS;
import ywy.chapter3.JDBCManager;

public class Main {
	
	public static void main(String[] args) throws Exception {
		JDBCManager db = null;
		String resource = "D:\\github\\JAVA_STUDY\\BasicGrammar/src/ywy/chapter3/DB.properties";
		Properties p = new Properties();


		try {
			FileInputStream fis = new FileInputStream(resource);
			p.load(new BufferedInputStream(fis));
			db = new JDBCManager.Builder(DBMS.MY_SQL)
							    .setUserName(p.getProperty("USER_NAME"))
							    .setPassword(p.getProperty("PASSWORD"))
							    .setUrl(p.getProperty("URL"))
							    .build();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("어서오세요. 이직 대학입니다.");
		Scanner sc = new Scanner(System.in);
		String cursor = null;
		while(true) {
			System.out.println("1. 로그인, 2. 대학등록, 3. 탈퇴, 4. 종료");
			cursor = sc.nextLine();
			switch(cursor) {
			case "1":
				if (login(sc, db)) {
					System.out.println("로그인 성공");
					sc.close();
					return;
				}
				System.out.println("아이디와 비밀번호가 다릅니다.");
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				System.out.println("1. 다시 선택, 2. 종료");
				cursor = sc.nextLine();
				if (cursor.equals("1")) {
					continue;
				}

				System.out.println("잘 못 입력하셨습니다. 시스템을 종료합니다.");
				sc.close();
				return;
			}
		}
	}
	
	private static boolean login(Scanner sc, JDBCManager db) throws Exception {
		System.out.println("아이디를 입력해 주세요.");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해 주세요.");
		String pw = sc.nextLine();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		StringBuffer sb = null;
		try {
			conn = db.getConnection();
			sb = new StringBuffer();
			sb.append("SELECT  1 AS SUCCESS")
			  .append("  FROM  login_info")
			  .append(" WHERE  ID = ?")
			  .append("   AND  PASSWORD = ?");
			   
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result = pstmt.executeQuery();
			if (result.next()) {
				if (result.getString("SUCCESS").equals("1")) {
					return true;
				}
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn, pstmt, result);
		}
		return true;
	}
	
}

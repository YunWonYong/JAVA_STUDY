package ywy.chapter3.mydb;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import ywy.chapter3.DBMS;
import ywy.chapter3.JDBCManager;

public class Main {
	
	public static void main(String[] args) {
		JDBCManager db = null;
		String resource = "D:\\github\\JAVA_STUDY\\BasicGrammar/src/ywy/chapter3/DB.properties";
		String root = System.getProperty("java.class.path");
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
				login(sc);
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
	
	private static void login(Scanner sc) {
		String id = sc.nextLine();
		String pw = sc.nextLine();
		LoginInfo login = null;
		
	}
	
}

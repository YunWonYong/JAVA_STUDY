package ywy.chapter3.mydb;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import ywy.chapter3.DBMS;
import ywy.chapter3.JDBCManager;
import ywy.chapter3.mydb.login.LoginRouter;
import ywy.chapter3.mydb.users.UserRouter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		JDBCManager db = null;
		String resource = new StringBuffer(System.getProperty("user.dir"))
						  .append("/src/ywy/chapter3/DB.properties").toString();
		Properties p = null;		
		try {
			p = new Properties();
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
		Router[] routers = new Router[] {new LoginRouter(), new UserRouter()};
		Router router = null;
		Model user = null;
		while(true) {
			System.out.println("1. 로그인, 2. 대학등록, 3. 탈퇴, 4. 종료");
			cursor = sc.nextLine();
			router = routers[getRouterIndex(cursor)];
			switch(cursor) {
			case "1":
				user = router.execute(sc, db, "1");
				if (user != null) {
					System.out.println("로그인 성공");
					routers[getRouterIndex("2")].execute(sc, db, user);
					break;
				}
				System.out.println("아이디와 비밀번호가 다릅니다.");
				break;
			case "2":
				user = router.execute(sc, db, "2");
				if (user == null) {
					System.out.println("회원 가입 실패");
					return;
				}
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
	
	private static int getRouterIndex(String cursor) throws Exception {
		int index = -1;
		try {
			index = Integer.parseInt(cursor) - 1;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return index;
	}
	
}

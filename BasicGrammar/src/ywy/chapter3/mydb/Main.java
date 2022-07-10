package ywy.chapter3.mydb;

import java.util.Scanner;

import ywy.chapter3.mydb.db.JDBCManager;
import ywy.chapter3.mydb.db.JDBCManagerFactory;
import ywy.chapter3.mydb.login.LoginRouter;
import ywy.chapter3.mydb.navigation.Navigation;
import ywy.chapter3.mydb.navigation.Navigator;
import ywy.chapter3.mydb.users.UserRouter;

public class Main {
	private static final String PROPERTIES_PATH = "/src/ywy/chapter3/MySQL.properties";
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		JDBCManager jdbcManager = JDBCManagerFactory.getJDBCManager(PROPERTIES_PATH);
		
		System.out.println("어서오세요. 이직 대학입니다.");
		String cursor = null;
		Router[] routers = new Router[] { new LoginRouter(), new UserRouter() };
		Router router = null;
		Model user = null;
		while(true) {
			System.out.println("1. 로그인, 2. 대학등록, 3. 탈퇴, 4. 종료");
			cursor = sc.nextLine();
			router = routers[getRouterIndex(cursor)];
			switch(cursor) {
			case "1":
				user = router.execute(sc, jdbcManager, "1");
				if (user != null) {
					System.out.println("로그인 성공");
					routers[getRouterIndex("2")].execute(sc, jdbcManager, user);
					break;
				}
				System.out.println("아이디와 비밀번호가 다릅니다.");
				break;
			case "2":
				user = router.execute(sc, jdbcManager, "2");
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

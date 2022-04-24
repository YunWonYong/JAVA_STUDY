package ywy.chapter3.mydb.users;

import java.util.Scanner;

import ywy.chapter3.JDBCManager;
import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.Router;

public class UserRouter implements Router {

	@Override
	public Model execute(Scanner sc, JDBCManager db, String path) {
		switch (path) {
		case "1":

			break;
		case "2":
			UserModel user = new UserModel();
			return new UserDAO().userRegister(sc, db, user);
		default:
			return null;
		}
		return null;
	}

	public Model execute(Scanner sc, JDBCManager db, Model model) {
		if (!(model instanceof UserModel)) {
			System.out.println("로그인 후 이용 가능합니다.");
			return null;
		}

		UserModel user = (UserModel) model;
		String div = user.getDiv();
		System.out.println(String.format("안녕하세요. %s %s님.", user.getName(), div));
		if (div == null) {
			System.out.println("학생 및 교수만 이용 가능합니다.");
			return null;
		} else if (div.equals("교수")) {
			return professorMenus(sc, db, user);
		}
		return studentMenus(sc, db, user);
	
	}
	
	private Model professorMenus(Scanner sc, JDBCManager db, UserModel user) {
		while (true) {

			System.out.println("1. 학과 정보, 2. 담당 학생 정보, 3. 과제 평가, 4. 로그아웃");
			String path = sc.nextLine();
			switch (path) {
			case "1":
				
				break;
			case "2":
				break;
			case "4":
			default:
				return null;
			}

		}
	}
	
	private Model studentMenus(Scanner sc, JDBCManager db, UserModel user) {
		while (true) {
			System.out.println("1. 학과 정보, 2. 학기 점수 정보, 3. 과제 재출, 4. 수강신청, 5. 로그아웃");
			String path = sc.nextLine();
			switch (path) {
			case "1":
				
				break;
			case "2":
				break;
			case "4":
			default:
				return null;
			}

		}
	}
}

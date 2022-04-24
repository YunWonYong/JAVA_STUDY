package ywy.chapter3.mydb.login;

import java.util.Scanner;

import ywy.chapter3.JDBCManager;
import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.Router;

public class LoginRouter implements Router {

	@Override
	public Model execute(Scanner sc, JDBCManager db, String path) {
		LoginDAO dao = new LoginDAO();
		switch (path) {
		case "1":
			System.out.println("아이디를 입력해 주세요.");
			String id = sc.nextLine();
			System.out.println("비말번호를 입력해 주세요.");
			String password = sc.nextLine();
			return dao.login(db, id, password);
		default:
			break;
		}
		return null;
	}

	@Override
	public Model execute(Scanner sc, JDBCManager db, Model model) {
		return null;
	}

}

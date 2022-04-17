package ywy.chapter3.mydb.users;

import java.util.Scanner;

import ywy.chapter3.JDBCManager;
import ywy.chapter3.mydb.Model;
import ywy.chapter3.mydb.Router;

public class UserRouter implements Router {

	@Override
	public Model execute(Scanner sc, JDBCManager db, String path) {
		Model user = new UserModel();
		switch (path) {
		case "1":
			
			break;

		default:
			return null;
		}
		return null;
	}

}

package ywy.chapter3.mydb.navigation.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LoginMenu extends AbstractMenu {
	public LoginMenu(boolean subMenuFlag, boolean inputFlag, Scanner sc) {
		super(subMenuFlag, inputFlag, sc);
	}

	@Override
	public boolean isSubMenu() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getMenuList() {
		return Arrays.asList("아이디를 입력해 주세요.", "비밀번호를 입력해 주세요.");
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public Object execute() throws Exception {
		return null;
	}

}

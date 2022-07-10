package ywy.chapter3.mydb.navigation.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.naming.OperationNotSupportedException;

public class LobbyMenu extends AbstractMenu {
	private Menu[] subMenu;
	public LobbyMenu(Scanner sc) {
		super(true, true, sc);
		subMenu = new Menu[] {
				new LoginMenu(false, true, sc),
		};
	}

	@Override
	public List<String> getMenuList() {
		return Arrays.asList("1. 로그인, 2. 대학등록, 3. 탈퇴, 4. 종료");
	}

	@Override
	public boolean isAction() {
		return false;
	}

	@Override
	public Object execute() throws Exception {
		throw new OperationNotSupportedException();
	}

}

package ywy.chapter3.mydb.navigation;

import java.util.Scanner;

import ywy.chapter3.mydb.navigation.menu.LobbyMenu;

public abstract class Navigator {
	private static Navigation NAVIGATION = null;
	
	public static Navigation getInstance(Scanner sc) {
		if (NAVIGATION == null) {
			NAVIGATION = new NavigationImpl();
			NAVIGATION.nextMenu(new LobbyMenu(sc));
		}
		return NAVIGATION;
	}
}

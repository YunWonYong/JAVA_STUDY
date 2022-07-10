package ywy.chapter3.mydb.navigation;

import java.util.Stack;

import ywy.chapter3.mydb.navigation.menu.Menu;

public class NavigationImpl implements Navigation {
	private Stack<Menu> history;
	
	public NavigationImpl() {
		history = new Stack<Menu>();
	}
	
	@Override
	public Menu getCurrent() {
		return history.peek();
	}

	@Override
	public void nextMenu(Menu menu) {
		history.push(menu);
	}

	@Override
	public void backHistory() {
		history.pop();
	}
}

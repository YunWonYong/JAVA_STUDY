package ywy.chapter3.mydb.navigation;

import ywy.chapter3.mydb.navigation.menu.Menu;

public interface Navigation {
	public abstract Menu getCurrent();
	public abstract void nextMenu(Menu menu);
	public abstract void backHistory();
}

package ywy.chapter3.mydb.navigation.menu;


public interface Menu {
	public abstract boolean isSubMenu();
	public abstract boolean isAction();
	public abstract Object execute() throws Exception; 
}

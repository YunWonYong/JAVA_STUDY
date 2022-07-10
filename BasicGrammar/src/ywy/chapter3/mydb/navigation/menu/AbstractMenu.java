package ywy.chapter3.mydb.navigation.menu;

import java.util.List;
import java.util.Scanner;

public abstract class AbstractMenu implements Menu {

	private boolean inputFlag = false;
	private boolean subMenuFlag = false;
	private Scanner sc;
	
	public AbstractMenu(boolean subMenuFlag, boolean inputFlag, Scanner sc) {
		this.subMenuFlag = subMenuFlag;
		this.inputFlag = inputFlag;
		this.sc = sc;
	} 
	
	public boolean isSubMenu() {
		return subMenuFlag;
	}
	
	
	protected int safeStrToInt(String str) {
		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return i;
	}
	
	public abstract List<String> getMenuList();
	public abstract boolean isAction();
	public abstract Object execute() throws Exception;
}

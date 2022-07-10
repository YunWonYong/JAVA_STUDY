package ywy.chapter3.mydb;

import java.util.List;
import java.util.Scanner;

import ywy.chapter3.mydb.db.JDBCManager;
import ywy.chapter3.mydb.db.JDBCManagerFactory;
import ywy.chapter3.mydb.navigation.Navigation;
import ywy.chapter3.mydb.navigation.Navigator;
import ywy.chapter3.mydb.navigation.menu.Menu;

public class SchoolSystem {
	private final String PROPERTIES_PATH = "/src/ywy/chapter3/MySQL.properties";
	private JDBCManager jdbcManager;
	private Navigation navigation;
	private Scanner sc;
	
	public SchoolSystem() {
		// TODO Auto-generated constructor stub
	}
	
	public void setup() throws Exception {
		try {
			sc = new Scanner(System.in);
			jdbcManager = JDBCManagerFactory.getJDBCManager(PROPERTIES_PATH);
			navigation = Navigator.getInstance(sc);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void start() {
		System.out.println("어서오세요. 이직 대학입니다.");
		Menu menu = null;
		List<String> inputs = null;
		while(true) {
			menu = navigation.getCurrent();
		}
	}
}

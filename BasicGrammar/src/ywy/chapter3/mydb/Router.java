package ywy.chapter3.mydb;

import java.util.Scanner;

import ywy.chapter3.JDBCManager;

public interface Router {
	public abstract Model execute(Scanner sc, JDBCManager db, String path);
	
	public abstract Model execute(Scanner sc, JDBCManager db, Model model);
}

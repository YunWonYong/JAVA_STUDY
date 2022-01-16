package ywy.chapter2.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ywy.chapter2.Unary;

public class UnaryTest {
	private static Scanner INPUT;
	private int n;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		INPUT = new Scanner(System.in);
	}

	@Test
	public void testPlus() {
		System.out.println("plus 양수 n을 입력하세요.");
		n = INPUT.nextInt();
		INPUT.nextLine();
		assertTrue(Unary.plus(n) == n);
	}
	
	@Test
	public void testMinus() {
		System.out.println("minus 음수 n을 입력하세요.");
		n = INPUT.nextInt();
		INPUT.nextLine();
		assertTrue(Unary.minus(n) != n);
	}
	
	@Test
	public void testIncrement() {
		System.out.println("increment 양수 n을 입력하세요.");
		n = INPUT.nextInt();
		INPUT.nextLine();
		assertTrue(Unary.increment(n) == n + 1);
	}

	@Test
	public void testDecrement() {
		System.out.println("decrement 양수 n을 입력하세요.");
		n = INPUT.nextInt();
		INPUT.nextLine();
		assertTrue(Unary.decrement(n) == n - 1);
	}
	
	@Test
	public void testTwoComplement() {
		System.out.println("twoComplement 양수 n을 입력하세요.");
		n = INPUT.nextInt();
		INPUT.nextLine();
		assertTrue(Unary.twoComplement(n) == ~n);
	}
	
	@Test
	public void testNot() {
		System.out.println("not true또는 false를 입력하세요.");
		boolean flag = INPUT.nextBoolean();
		INPUT.nextLine();
		assertTrue(Unary.not(flag) == !flag);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		INPUT.close();
	}
}

package ywy.chapter2.test;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ywy.chapter2.Arithmetic;

public class ArithmeticTest {
	private static Scanner INPUT;
	private int left;
	private int right;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		INPUT = new Scanner(System.in);
	}

	@Test
	public void testAdditive() {
		System.out.println("additive");
		System.out.print("left: ");
		left = INPUT.nextInt();
		INPUT.nextLine();
		System.out.print("right: ");
		right = INPUT.nextInt();
		assertTrue(Arithmetic.additive(left, right) == left + right);
		System.out.println("result: " + (left + right));
		System.out.println("=======================");
	}
	
	@Test
	public void testSubtraction() {
		System.out.println("subtraction");
		System.out.print("left: ");
		left = INPUT.nextInt();
		INPUT.nextLine();
		System.out.print("right: ");
		right = INPUT.nextInt();
		assertTrue("fail",Arithmetic.subtraction(left, right) == left - right);
		System.out.println("result: " + (left - right));
		System.out.println("=======================");
	}
	
	@Test
	public void testMultiplication() {
		System.out.println("multiplication");
		System.out.print("left: ");
		left = INPUT.nextInt();
		INPUT.nextLine();
		System.out.print("right: ");
		right = INPUT.nextInt();
		assertTrue("fail", Arithmetic.multiplication(left, right) == left * right);
		System.out.println("result: " + left * right);
		System.out.println("=======================");
	}

	@Test
	public void testDivision() {
		System.out.println("division");
		System.out.print("left: ");
		left = INPUT.nextInt();
		INPUT.nextLine();
		System.out.print("right: ");
		right = INPUT.nextInt();
		assertTrue(Arithmetic.division(left, right) == left / right);
		System.out.println("result: " + left / right);
		System.out.println("=======================");
	}
	
	@Test
	public void testRemainder() {
		System.out.println("remainder");
		System.out.print("left: ");
		left = INPUT.nextInt();
		INPUT.nextLine();
		System.out.print("right: ");
		right = INPUT.nextInt();
		assertTrue(Arithmetic.remainder(left, right) == left % right);
		System.out.println("result: " + left % right);
		System.out.println("=======================");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		INPUT.close();
	}
}

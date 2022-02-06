package chapter3.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

import chapter3.Calc;

public class CalcTest {
	@Test
	public void testArithmetic() { //산술연산자
		Scanner scanner = new Scanner(System.in);
		int a;
		int b;
		System.out.print("첫번째 숫자 a를 입력하세요>> ");
		a = scanner.nextInt();
		System.out.print("두번째 숫자 b를 입력하세요>> ");
		b = scanner.nextInt();
		//int result = a + b;
		assertEquals(a + b, Calc.add(a, b));
		assertEquals(a - b, Calc.sub(a, b));
		assertEquals(a * b, Calc.mul(a, b));
		assertEquals(a / b, Calc.div(a, b));
		assertEquals(a % b, Calc.rem(a, b));
		scanner.close();
	}
	
	@Test
	public void testUnary() { // 단항연산자
		Scanner scanner = new Scanner(System.in);
		int a;
		System.out.print("숫자 a를 입력하세요>> ");
		a = scanner.nextInt();
		//int result = a + b;
		//System.out.println("+a는 " + +a);
		assertEquals(+a, Calc.plus(a));
		assertEquals(-a, Calc.minus(a));
		assertEquals(a++, Calc.inc(a));
		assertEquals(a--, Calc.dec(a));
		assertEquals(~a, Calc.til(a));
		scanner.close();
	}
}

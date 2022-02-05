package chapter3;

public class Calc {
	// 산술연산자
	public static int add (int a, int b) {
		return a + b;
	}
	public static int sub (int a, int b) {
		return a - b;
	}
	public static int mul (int a, int b) {
		return a * b;
	}
	public static int div (int a, int b) {
		return a / b;
	}
	public static int rem (int a, int b) {
		return a % b;
	} 
	
	//단항연산자
	public static int plus (int a) {
		return +a;
	}
	public static int minus (int a) {
		return -a;
	}
	public static int inc (int a) {
		return a++;
	}
	public static int dec (int a) {
		return a--;
	}
	public static int til (int a) {
		return ~a;
	}
	public static boolean exc (boolean a) {
		return !a;
	}
}

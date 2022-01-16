package ywy.chapter2;

public class Unary {
	
	public static final int plus(int n) {
		return +n;
	}
	
	public static final int minus(int n) {
		return -n;
	}
	
	public static final int increment(int n) {
		return ++n;
	}
	
	public static final int decrement(int n) {
		return --n;
	}
	
	public static final int twoComplement(int n) {
		return ~n;
	}
	
	public static final boolean not(boolean flag) {
		return !flag;
	}
}

package ywy.chapter2;

public class Equality {
	
	public static final boolean isNull(Object obj) {
		return obj == null;
	}
	
	public static final boolean isNotNull(Object obj) {
		return obj != null;
	}
	
	public static final boolean compareTo(int left, int right) {
		return left == right;
	}
	
}

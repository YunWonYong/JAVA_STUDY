package ywy.chapter3;

public final class Utility {
	
	public static final boolean isNullOrBlank(String str) {
		return isNull(str) || str.isEmpty();
	}
	
	public static final boolean isNull(Object obj) {
		return obj == null;
	}
	
}

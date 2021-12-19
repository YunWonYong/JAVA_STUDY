package chapter1.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.BeforeClass;
import org.junit.Test;

import chapter1.Variables;

public class VariablesTest {
	
	private static Variables variables;
	
	@BeforeClass
	public static void setUp() {
		variables = new Variables();
	}
	

	@Test
	public void initValueTest() {
		assertTrue(variables.bl == false);
		assertTrue(variables.b == 0);	
		assertTrue(variables.s == 0);	
		assertTrue(variables.c == '0'); // 숙제 1
		assertTrue(variables.i == 0);
		assertTrue(variables.l == 0l); // 숙제 2
		assertTrue(variables.f == 0.0f);
		assertTrue(variables.d == 0.0);
	}
	

	@Test
	public void initMaxValueTest() { // 숙제 3
		assertTrue(variables.bT == Boolean.TRUE);
		assertTrue(variables.bMax == Byte.MAX_VALUE);	
	}
	

	@Test
	public void initMinValueTest() { // 숙제 3
		assertTrue(variables.bF == Boolean.FALSE);
		assertTrue(variables.bMin == Byte.MIN_VALUE);	
	}
	
	@Test
	public void molTest() {
		byte b = Byte.MAX_VALUE; // 127 + 1 = 128? 2의 보수   
		b = (byte) (b + 1); // 의미없는 값! 
		assertFalse(String.format("this b variable: %d", b), b == 128);
		
		byte b1 = 100;
		byte b2 = 28;
		b = (byte)(b1 + b2);
		assertFalse(String.format("this b variable: %d", b), b == 128);
		int i1 = Integer.MAX_VALUE;
		int i2 = 1000;
		int i3 = i1 + i2;
		long l1 = 0;
		if (i3 < Integer.MAX_VALUE) {
			l1 = ((long)i1) + i2;
			assertTrue(String.format("this b variable: %d, reuslt: %d", l1, (((long)Integer.MAX_VALUE) + 1000)), l1 == (((long)Integer.MAX_VALUE) + 1000));
			return;
		}
		assertTrue(String.format("this b variable: %d, reuslt: %d", i3, (((long)Integer.MAX_VALUE) + 1000)), i3 == (((long)Integer.MAX_VALUE) + 1000));
	}


}

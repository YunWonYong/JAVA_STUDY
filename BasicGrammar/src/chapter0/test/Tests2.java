package chapter0.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests2 {

	@Test
	public void test() {
		assertTrue(new chapter0.Test() instanceof Test);
	}

}

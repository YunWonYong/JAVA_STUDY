package chapter3.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chapter3.Dog1;

public class Dog1Test {

	@Test
	public void testDefaultConstructInstance() {
		Dog1 해피 = new Dog1();
		assertTrue(해피 != null);
	}
	
	@Test
	public void testUseConstructInsteance() {
		Dog1 해피1 = new Dog1("해피", 10, "우우", "흰색", "소형");
		Dog1 해피2 = new Dog1("해피", 10, "흰색", "우우", "소형");
		assertNotEquals("같음", 해피1.getSound(), 해피2.getSound());
		assertNotEquals("같음", 해피1.getColor(), 해피2.getColor());
	}
	
	@Test
	public void testUseConstructorInstance2() {
		Dog1 해피1 = new Dog1();
		해피1.setName("해피");
		해피1.setAge(10);
		System.out.println(해피1);
	}

}

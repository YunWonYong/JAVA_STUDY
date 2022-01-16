package chapter3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chapter3.Dog2;

public class Dog2Test {

	@Test
	public void testDog2InstanceBuildPatten() {
		Dog2 해피 = new Dog2
				.Build()
				.name("해피")
				.age(10)
				.sound("월월")
				.build();
		assertEquals(해피.getName(), "해피");
		assertTrue(해피.getAge() == 10);
		assertEquals(해피.getSound(), "월월");
		Dog2 해피2 = new Dog2
				.Build()
				.name("해피2")
				.age(100)
				.sound("월윌")
				.build();
		assertEquals(해피2.getName(), "해피2");
		assertTrue(해피2.getAge() == 100);
		assertEquals(해피2.getSound(), "월윌");
		
		System.out.println(해피);
		System.out.println(해피2);
		
		assertNotEquals("같음", 해피, 해피2);
	}
	
}

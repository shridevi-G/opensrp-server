package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ServiceProviderTypeTest {
	
	private ServiceProviderType serviceProviderType;
	
	@Before
	public void setUp(){
		String type = null;
		serviceProviderType = new ServiceProviderType(type);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = serviceProviderType.id();
		assertEquals(w,s);
	}
	
	@Test
	public void typeTest(){
		String s = null;
		String w = serviceProviderType.type();
		assertEquals(w,s);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= serviceProviderType.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		serviceProviderType.hashCode();
	}

	@Test
	public void toStringTest() {
		serviceProviderType.toString();
	}

}

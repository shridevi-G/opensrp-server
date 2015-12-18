package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ANMTest {
	
private ANM anm;
	
	@Before
	public void setUp(){
		String anmIdentifier = null;
		Integer id = null;
		anm = new ANM(id, anmIdentifier);
	}
	
	@Test
	public void idTest(){
		Integer s = null;
		Integer w = anm.id();
		assertEquals(w,s);
	}
	
	@Test
	public void anmIdentifierTest(){
		String s = null;
		String w = anm.anmIdentifier();
		assertEquals(w,s);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= anm.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		anm.hashCode();
	}

	@Test
	public void toStringTest() {
		anm.toString();
	}

}

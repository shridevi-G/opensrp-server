package org.ei.drishti.form.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SubFormDataTest {
	
private SubFormData subFormData;
	
	@Before
	public void setUp(){
		subFormData = new SubFormData();
	}
	
	@Test
	public void nameTest(){
		String t= subFormData.name();
		String x="";
		assertEquals(t,x);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= subFormData.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}
	
	@Test
	public void hashCodeTest(){
		subFormData.hashCode();
	}
	
	@Test
	public void toStringTest(){
		subFormData.toString();
	}

}

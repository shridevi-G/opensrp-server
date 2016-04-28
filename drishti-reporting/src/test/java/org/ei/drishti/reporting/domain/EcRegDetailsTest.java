package org.ei.drishti.reporting.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EcRegDetailsTest {
	
private EcRegDetails ecRegDetails;
	
	@Before
	public void setUp(){
		int id = 0;
		String entityid = null;
		String phonenumber = null;
		ecRegDetails = new EcRegDetails(id, entityid,phonenumber);
	}
	
	@Test
	public void idTest(){
		Integer s = 0;
		Integer w = ecRegDetails.id();
		assertEquals(w,s);
	}
	
	@Test
	public void setentityidTest(){
		ecRegDetails.setentityid("entityid");
	}
	
	@Test
	public void entityidTest(){
		String s = null;
		String w = ecRegDetails.entityid();
		assertEquals(w,s);
	}
	
	@Test
	public void phonenumberTest(){
		String s = null;
		String w = ecRegDetails.phonenumber();
		assertEquals(w,s);
	}
	
	@Test
	public void setphonenumberTest(){
		ecRegDetails.setphonenumber("phonenumber");
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= ecRegDetails.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		ecRegDetails.hashCode();
	}

	@Test
	public void toStringTest() {
		ecRegDetails.toString();
	}

}

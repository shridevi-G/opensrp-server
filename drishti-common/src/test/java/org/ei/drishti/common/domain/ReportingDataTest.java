package org.ei.drishti.common.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReportingDataTest {

	private ReportingData reportingData;

	@Before
	public void setUp() {
		reportingData = new ReportingData(null, null);
		reportingData = new ReportingData(null);
	}

	@Test
	public void typetest() throws Exception {
		String m = reportingData.type();
		String a = null;
		assertEquals(m, a);

	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= reportingData.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		reportingData.hashCode();
	}

	@Test
	public void toStringTest() {
		reportingData.toString();
	}

}

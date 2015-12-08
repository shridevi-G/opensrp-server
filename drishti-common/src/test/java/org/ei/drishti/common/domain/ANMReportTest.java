package org.ei.drishti.common.domain;

import org.junit.Before;
import org.junit.Test;

public class ANMReportTest {
	
	private ANMReport anmReport;
	
	@Before
	public void setUp(){
		anmReport = new ANMReport(null, null);
	}
	
	@Test
	public void summariesTest(){
		anmReport.summaries();
	}
	
	@Test
	public void anmIdentifierTest(){
		anmReport.anmIdentifier();
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		anmReport.equals(o);
	}
	
	@Test
	public void hashCodeTest(){
		anmReport.hashCode();
	}
	
	@Test
	public void toStringTest(){
		anmReport.toString();
	}

}

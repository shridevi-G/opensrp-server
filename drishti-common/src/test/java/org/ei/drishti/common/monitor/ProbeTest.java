package org.ei.drishti.common.monitor;

import org.junit.Before;
import org.junit.Test;

public class ProbeTest {
	
	private Probe probe;
	
	@Before 
	public void setUp(){
		probe = new Probe(null);
	}
	
	@Test
	public void probeTest(){
		probe.metric();
	}
	
	@Test
	public void valueTest(){
		probe.value();
	}
		

}

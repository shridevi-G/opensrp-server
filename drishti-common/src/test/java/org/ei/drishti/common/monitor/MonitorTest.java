package org.ei.drishti.common.monitor;

import org.junit.Before;
import org.junit.Test;

public class MonitorTest {
	
	private Monitor monitor;
	
	@Before
	public void setUp(){
		monitor = new Monitor();
	}
	
	@Test
	public void startTest(){
		Metric metric = null;
		monitor.start(metric);
	}
	
	/*@Test
	public void endTest(){
		Probe probe = null;
		monitor.end(probe);
	}*/
	
	/*@Test
	public void addObservationForTest(){
		Metric metric = null;
		long value = 0;
		monitor.addObservationFor(metric, value);
	}*/

}

package org.ei.drishti.common.monitor;

import org.junit.Before;
import org.junit.Test;

public class MetricTest {
	
	private Metric metric;
	
	@Test
	public void metricTest(){
		assertThat(Metric.valueOf("REPORTING_ANM_REPORTS_CACHE_TIME"), is(notNullValue()));
	}

	private void assertThat(Metric valueOf, Object object) {
		// TODO Auto-generated method stub
		
	}

	private Object is(Object notNullValue) {
		// TODO Auto-generated method stub
		return null;
	}

	private Object notNullValue() {
		// TODO Auto-generated method stub
		return null;
	}

}

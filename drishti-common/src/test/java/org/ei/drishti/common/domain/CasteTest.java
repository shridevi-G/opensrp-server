package org.ei.drishti.common.domain;

import org.ei.drishti.common.domain.Caste;
import org.ei.drishti.common.domain.Indicator;
import org.ei.drishti.common.monitor.Metric;
import org.junit.Test;

public class CasteTest {
	
	@Test
	public void CasteTest(){
		assertThat(Caste.SC.indicator());
		
	}

	private void assertThat(Indicator indicator) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Test
	public void fromTest(){
		assertThat(Caste.from(name));
	}*/
	
}

package org.ei.drishti.dto;

import org.junit.Test;

public class AlertStatusTest {
	
	@Test
	public void alertStatusTest(){
		assertThat(AlertStatus.complete.value());
		assertThat(AlertStatus.inProcess.value());
	}

	private void assertThat(String value) {
		// TODO Auto-generated method stub
		
	}

}

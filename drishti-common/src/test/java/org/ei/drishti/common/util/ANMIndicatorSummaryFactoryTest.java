package org.ei.drishti.common.util;

import org.junit.Before;
import org.junit.Test;

public class ANMIndicatorSummaryFactoryTest {

	private ANMIndicatorSummaryFactory anmIndicatorSummaryFactory;

	@Before
	public void setUp() {
		anmIndicatorSummaryFactory = new ANMIndicatorSummaryFactory();
	}

	@Test
	public void createSummaryForIUDTest() {
	anmIndicatorSummaryFactory.createSummaryForANC();
	}

	
	@Test
	public void createSummaryForIUDTest1() {
	anmIndicatorSummaryFactory.createSummaryForIUD();
	}
	
	@Test
	public void createSummaryForIUDTest2() {
	anmIndicatorSummaryFactory.createSummaryForIUD("annualTarget");
	}
	
	@Test
	public void createSummaryForIUDTest3() {
	anmIndicatorSummaryFactory.createSummaryForCondom();
	}


}

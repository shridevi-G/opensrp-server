package org.ei.drishti.reporting.controller;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import org.ei.drishti.reporting.service.AggregateReportsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class FakeReportDataControllerTest {
	
	@Mock
	private AggregateReportsService aggregateReportsService;
	private FakeReportDataController fakeReportDataController;

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		fakeReportDataController = new FakeReportDataController(aggregateReportsService);

	}

	@Test
	public void forceAggregateReportsTest() throws Exception {

		fakeReportDataController.forceAggregateReports();
		 verify(aggregateReportsService).sendReportsToAggregator();

	}

}

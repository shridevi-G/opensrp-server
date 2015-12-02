package org.ei.drishti.reporting.controller;

import static org.mockito.MockitoAnnotations.initMocks;

import org.ei.drishti.common.util.DateUtil;
import org.ei.drishti.reporting.handler.FormDatahandler;
import org.ei.drishti.reporting.service.ANMService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class FormDataControllerTest {
	@Mock
	 private ANMService anmService;
	@Mock
	    private FormDatahandler formDataHandler;
	@Mock
	    private SMSController smsController;
	@Mock
	    private DateUtil dateUtil;
	
	private FormDataController formDataController;
	
	 @Before
	    public void setUp() throws Exception {
	        initMocks(this);
	        formDataController = new FormDataController(anmService,formDataHandler, smsController,dateUtil);
	    }
	 
	 @Test
	    public void formDatatest() throws Exception {
		 
	 }

}

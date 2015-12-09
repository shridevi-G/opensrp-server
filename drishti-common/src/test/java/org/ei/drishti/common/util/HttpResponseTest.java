package org.ei.drishti.common.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HttpResponseTest {
	private HttpResponse httpResponse;

	@Before
	public void setUp() {
		httpResponse = new HttpResponse(false, null);
	}

	@Test
	public void isSuccessTest() throws Exception {
		assertEquals("isSuccess", false, httpResponse.isSuccess());
	}

	@Test
	public void bodyTest() throws Exception {
		
		assertEquals(null, httpResponse.body());
	}
}
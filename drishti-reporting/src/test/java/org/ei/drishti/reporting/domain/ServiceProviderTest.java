package org.ei.drishti.reporting.domain;

import org.junit.Before;
import org.junit.Test;

public class ServiceProviderTest {
	
	private ServiceProviderType serviceProviderType;
	 @Before
public void setUp(){
		 serviceProviderType = new ServiceProviderType("sdaf");
}

@Test
public void idtest() throws Exception {
	
	serviceProviderType.id();

}

@Test
public void parsetest() throws Exception {
	
//	serviceProviderType.parse();

}

}

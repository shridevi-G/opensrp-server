package org.ei.drishti.reporting.domain;

import org.junit.Before;
import org.junit.Test;

public class ServiceProviderTypeTest {
	
	private ServiceProviderType serviceProviderType;
	 @Before
public void setUp(){
		 serviceProviderType = new ServiceProviderType("sadf");
}

@Test
public void idtest() throws Exception {
	
	serviceProviderType.id();

}

@Test
public void parsetest() throws Exception {
	
	serviceProviderType.parse("sadf");

}

@Test
public void equalstest() throws Exception {
	
	serviceProviderType.equals(null);

}

@Test
public void hashCodetest() throws Exception {
	
	serviceProviderType.hashCode();

}

@Test
public void toStringtest() throws Exception {
	
	serviceProviderType.toString();

}
@Test
public void typetest() throws Exception {
	
	serviceProviderType.type();

}

@Test
public void getTypetest() throws Exception {
	
	serviceProviderType.getType();

}

}

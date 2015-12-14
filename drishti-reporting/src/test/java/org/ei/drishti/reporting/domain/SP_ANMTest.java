package org.ei.drishti.reporting.domain;

import org.junit.Before;
import org.junit.Test;

public class SP_ANMTest {
	
	private SP_ANM spanm;
	 @Before
public void setUp(){
		 spanm = new SP_ANM("sadf","sdaf","sadf",324);
}

@Test
public void idtest() throws Exception {
	
	spanm.id();

}

@Test
public void nametest() throws Exception {
	
	spanm.name();

}

@Test
public void equalstest() throws Exception {
	
	spanm.equals(spanm);

}

@Test
public void hashCodetest() throws Exception {
	
	spanm.hashCode();

}


@Test
public void toStringtest() throws Exception {
	
	spanm.toString();

}

@Test
public void identifiertest() throws Exception {
	
	spanm.identifier();

}

@Test
public void subCentertest() throws Exception {
	
	spanm.subCenter();

}
}

package org.ei.drishti.reporting.domain;

import static org.junit.Assert.assertEquals;

import org.ei.drishti.common.util.HttpResponse;
import org.junit.Before;
import org.junit.Test;

public class VisitConfTest {
	
	private VisitConf visitConf;
	 @Before
 public void setUp(){
		 visitConf = new VisitConf("anc_visit1_from_week","String anc_visit2_from_week","anc_visit3_from_week","anc_visit4_from_week");
 }

@Test
public void idtest() throws Exception {
	
	visitConf.id();

}


@Test
public void anc_visit1_from_weektest() throws Exception {
	
	visitConf.anc_visit1_from_week();

}

@Test
public void anc_visit2_from_weektest() throws Exception {
	
	visitConf.anc_visit2_from_week();

}

@Test
public void anc_visit3_from_weektest() throws Exception {
	
	visitConf.anc_visit3_from_week();

}

@Test
public void anc_visit4_from_weektest() throws Exception {
	
	visitConf.anc_visit4_from_week();

}

@Test
public void equalstest() throws Exception {
	
	Object o = null;
	visitConf.equals(o);

}

@Test
public void hashCodetest() throws Exception {
	
	
	visitConf.hashCode();

}

@Test
public void toStringtest() throws Exception {
	
	
	visitConf.toString();

}


}

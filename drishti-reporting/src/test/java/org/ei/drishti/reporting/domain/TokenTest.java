package org.ei.drishti.reporting.domain;

import org.junit.Before;
import org.junit.Test;

public class TokenTest {

	
	private Token token;
	 @Before
public void setUp(){
		 token = new Token("anc_visit1_from_week","anc_visit2_from_week");
}

@Test
public void idtest() throws Exception {
	
	token.id();

}

@Test
public void nametest() throws Exception {
	
	token.name();

}

@Test
public void withValuetest() throws Exception {
	
	token.withValue(null);

}

@Test
public void valuetest() throws Exception {
	
	token.value();

}


@Test
public void equalstest() throws Exception {
	
	token.equals(token);

}

@Test
public void hashCodetest() throws Exception {
	
	token.hashCode();

}

@Test
public void toStringtest() throws Exception {
	
	token.toString();

}
}

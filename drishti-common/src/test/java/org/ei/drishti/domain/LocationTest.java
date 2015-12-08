package org.ei.drishti.domain;

import org.ei.drishti.common.util.HttpAgent;
import org.junit.Before;
import org.junit.Test;

public class LocationTest {
	
	private Location location;
	
	@Before 
	public void setUp(){
		location = new Location("null", "null", "null");
	}
	
	@Test
	public void LocationTest(){
		location.village();
		location.subCenter();
		location.phc();
		//location.Location("village", "subCenter", "phc");
		
	}

}

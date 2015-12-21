package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ANMDetailsDTOTest {
	
	private ANMDetailsDTO anmDetailsDTO;
	
	@Before
	public void setUp(){
		anmDetailsDTO = new ANMDetailsDTO(null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= anmDetailsDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		anmDetailsDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		anmDetailsDTO.toString();
	}

}

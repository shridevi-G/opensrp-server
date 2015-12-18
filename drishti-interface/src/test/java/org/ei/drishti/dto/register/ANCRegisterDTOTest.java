package org.ei.drishti.dto.register;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ANCRegisterDTOTest {
	
	private ANCRegisterDTO ancRegisterDTO;
	
	@Before
	public void setUp(){
		ancRegisterDTO = new ANCRegisterDTO(null);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= ancRegisterDTO.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		ancRegisterDTO.hashCode();
	}

	@Test
	public void toStringTest() {
		ancRegisterDTO.toString();
	}

}

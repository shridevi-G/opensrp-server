package org.ei.drishti.dto;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
public class VillagesDTOTest {

	private VillagesDTO villagesdto;
	 
	@Before
	public void setUp(){
		villagesdto = new VillagesDTO(null, null, null, null, null);
	} 
	
	@Test
	public void phcNameTest(){
		String w= villagesdto.phcName();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void subCenterTest(){
		String w= villagesdto.subCenter();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void villagesTest(){
		List<String> w= villagesdto.villages();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void phcIdentifierTest(){
		String w= villagesdto.phcIdentifier();
		String a=null;
		assertEquals(w,a);
	}
	
	@Test
	public void equalsTest(){
		Object o = null;
		boolean t= villagesdto.equals(o);
		boolean x = false;
		assertEquals(t,x);
	}

	@Test
	public void hashCodeTest() {
		villagesdto.hashCode();
	}

	@Test
	public void toStringTest() {
		villagesdto.toString();
	}
}

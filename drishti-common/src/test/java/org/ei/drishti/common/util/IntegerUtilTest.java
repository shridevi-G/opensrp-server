package org.ei.drishti.common.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntegerUtilTest {
	
	@Before
	public void setUp(){
		IntegerUtil integerUtil = new IntegerUtil();
	}	
	
    @Test
    public void shouldParseIntSafely() throws Exception {
        assertEquals(0, IntegerUtil.tryParse("", 0));
        assertEquals(2, IntegerUtil.tryParse(null, 2));
        assertEquals(0, IntegerUtil.tryParse("0", 1));
        assertEquals(3, IntegerUtil.tryParse("3", 3));
    }
       /* @Test
      public void isIntegerTest() {
                 
             //assertEquals("value", IntegerUtil.tryParse("value", 0));

            assertEquals("value", IntegerUtil.isInteger("value"));
           // assertTrue("value", IntegerUtil.isInteger("value"));
        }*/
           
}

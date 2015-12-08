package org.ei.drishti.common.audit;

import static org.junit.Assert.assertEquals;

import org.ei.drishti.common.util.IntegerUtil;
import org.junit.Before;
import org.junit.Test;

public class ForbiddenFieldInAuditMessageTest {
	
	private ForbiddenFieldInAuditMessage forbiddenFieldInAuditMessage;
	
	 @Before
    public void setUp(){
		 forbiddenFieldInAuditMessage = new ForbiddenFieldInAuditMessage(null, "sdaf", "sadf");
    }
   @Test
   public void ForbiddenFieldInAuditMessagetest() throws Exception {
	
      
   }

}

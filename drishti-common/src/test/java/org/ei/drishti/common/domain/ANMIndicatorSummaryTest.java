package org.ei.drishti.common.domain;

import static org.junit.Assert.assertEquals;

import org.ei.drishti.common.util.IntegerUtil;
import org.junit.Before;
import org.junit.Test;

public class ANMIndicatorSummaryTest {
	
	
	private ANMIndicatorSummary anmindicatorSummary;
	
	 @Before
    public void setUp(){
		 anmindicatorSummary = new ANMIndicatorSummary(null, null, null);
    }
   @Test
   public void monthlySummariestest() throws Exception {
	   
	   anmindicatorSummary.monthlySummaries();
   }

   
   @Test
   public void annualTargettest() throws Exception {
	   
	   anmindicatorSummary.annualTarget();
   }
   
   @Test
   public void indicatortest() throws Exception {
	   
	   anmindicatorSummary.indicator();
   }
}

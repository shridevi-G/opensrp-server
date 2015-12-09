package org.ei.drishti.common.util;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;

public class DateUtilTest {
	
	private DateUtil dateUtil;
	
	@Before
	public void setUp(){
		dateUtil = new DateUtil();
	}
	
//	@Test
//	public void fakeItTest(){
//		LocalDate fakeDayAsToday = null;
//		dateUtil.fakeIt(fakeDayAsToday);
//	}
	
	@Test
	public void millisTest(){
		dateUtil.millis();
	}
	
	@Test
	public void todayTest(){
		dateUtil.today();
	}
	
//	@Test
//	public void isDateWithinGivenPeriodBeforeTodayTest(){
//		LocalDate referenceDateForSchedule = null;
//		Period period = null;
//		dateUtil.isDateWithinGivenPeriodBeforeToday(referenceDateForSchedule, period);
//	}
	
	@Test
	public void toTimeTest(){
		dateUtil.datetimenow();
	}
	
	@Test
	public void ftryParseTest(){
		LocalDate defaultValue = null;
		dateUtil.tryParse("value", defaultValue);
	}
	
	@Test
	public void datetimenowTest(){
		dateUtil.datetimenow();
	}
	
	@Test
	public void dateFormatTest(){
		int diff = 0;
		dateUtil.dateFormat("2015-12-08", diff);
	}

}

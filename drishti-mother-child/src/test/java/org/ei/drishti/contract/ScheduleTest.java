package org.ei.drishti.contract;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ScheduleTest {
	
	private Schedule schedule;
	
	@Before
	public void setUp(){
		schedule = new Schedule(null, null);
	}

    @Test
    public void shouldTestScheduleDependency(){
        Schedule schedule1 = new Schedule("schedule1", new ArrayList<String>());
        Schedule schedule2 = new Schedule("schedule3", new ArrayList<String>()).withDependencyOn(schedule1);
        assertFalse(schedule1.hasDependency());
        assertTrue(schedule2.hasDependency());
        assertTrue(schedule2.dependsOn(schedule1));
        assertFalse(schedule1.dependsOn(schedule2));
    }
    
    @Test
    public void toString_Test(){
    	schedule.toString();
    }
}

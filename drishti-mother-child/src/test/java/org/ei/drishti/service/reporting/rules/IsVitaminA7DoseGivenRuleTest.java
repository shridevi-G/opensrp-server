package org.ei.drishti.service.reporting.rules;

import org.ei.drishti.util.SafeMap;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.ei.drishti.common.util.EasyMap.create;
import static org.junit.Assert.assertFalse;

public class IsVitaminA7DoseGivenRuleTest {
    private IsVitaminA7DoseGivenRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new IsVitaminA7DoseGivenRule();
    }

    @Test
    public void shouldReturnTrueIfVitaminA7DoseIsGiven() {
        SafeMap safeMap = new SafeMap(create("vitaminADose", "7").map());

        boolean didRuleApply = rule.apply(safeMap);
        assertTrue(didRuleApply);
    }

    @Test
    public void shouldReturnFalseIfVitaminA7DoseIsNotGiven() {

        boolean didRuleApply = rule.apply(new SafeMap(create("vitaminADose", "1").map()));
        assertFalse(didRuleApply);

        didRuleApply = rule.apply(new SafeMap(create("vitaminADose", "").map()));
        assertFalse(didRuleApply);
    }
}

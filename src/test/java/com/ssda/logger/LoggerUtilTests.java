package com.ssda.logger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoggerUtilTests {

    @Test
    public void shouldSplitFQNameIntoClassName() {
        String fqname = "public void com.ssda.tasks.AggregateCustomersTask.execute()";
        assertEquals(LoggerUtil.getClassname(fqname), "AggregateCustomersTask");
    }

    @Test
    public void shouldSplitFQNameIntoClassNameWithMethodArguments() {
        String fqname = "public void com.ssda.tasks.AggregateCustomersTask.execute(java.lang.String,java.lang.String)";
        assertEquals(LoggerUtil.getClassname(fqname), "AggregateCustomersTask");
    }
}

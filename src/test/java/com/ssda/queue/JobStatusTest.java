package com.ssda.queue;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JobStatusTest {
    @Test
    public void shouldUpdateTheStatusCorrectly() {
        JobStatus status1 = new JobStatus("abc123");
        status1.queued();
        assertThat(status1.getStatus(), is(Progress.QUEUED));
    }
}

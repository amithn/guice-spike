package com.ssda.queue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProgressTrackerTest {

    private ProgressTracker tracker;
    private JobStatus status1;
    private JobStatus status2;

    @Before
    public void setUp() {
        tracker = new ProgressTracker();

        status1 = new JobStatus("id123");
        status2 = new JobStatus("id124");

        tracker.add(status1);
        tracker.add(status2);
    }

    @Test(expected=AlreadyExistsException.class)
    public void shouldThrowAlreadyExistsExceptionWhenAddingSameJobStatus() {
        tracker.add(status1);
    }

    @Test
    public void shouldReturnTheCorrectJobStatusWhenQueried() {
        assertThat(tracker.getJobStatus("id123"), is(status1));
    }

    @Test
    public void shouldUpdateJobStatusCorrectly() {
        status1.queued();
        tracker.update(status1.getId(), Progress.ONGOING);
        assertThat(tracker.getJobStatus(status1.getId()).getStatus(), is(Progress.ONGOING));
    }

    @Test(expected=JobNotFoundException.class)
    public void shouldThrowJobNotFoundExceptionWhenJobNotFound() {
        tracker.getJobStatus("non-existent-id");
    }
}

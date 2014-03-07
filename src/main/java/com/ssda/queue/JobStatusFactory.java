package com.ssda.queue;

public class JobStatusFactory {
    private String jobId;

    public JobStatus build(String jobId) {
        this.jobId = jobId;
        return new JobStatus(jobId);
    }
}

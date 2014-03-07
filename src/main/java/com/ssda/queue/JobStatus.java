package com.ssda.queue;

public class JobStatus {

    private String jobId;
    private Progress status;

    public JobStatus(String jobId) {
        this.jobId = jobId;
        this.status = Progress.UNKNOWN;
    }

    public JobStatus queued() {
        this.status = Progress.QUEUED;
        return this;
    }

    public JobStatus running() {
        this.status = Progress.ONGOING;
        return this;
    }

    public JobStatus done() {
        this.status = Progress.DONE;
        return this;
    }

    public JobStatus failed() {
        this.status = Progress.FAILED;
        return this;
    }

    public String getId() {
        return jobId;
    }

    public Progress getStatus() {
        return status;
    }

    public void setStatus(Progress status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return jobId.hashCode() + status.hashCode();
    }

    @Override
    public boolean equals(Object status) {
        if(status == null) {
            return false;
        }else {
            System.out.println("Hascode - " + this.hashCode() + " == " + status.hashCode());
            return this.hashCode() == status.hashCode();
        }
    }
}

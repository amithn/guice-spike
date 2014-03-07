package com.ssda.queue;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProgressTracker {

    private Set<JobStatus> jobStatuses = null;
    
    public ProgressTracker() {
        jobStatuses = Collections.synchronizedSet(new HashSet<JobStatus>());
    }
    
    public void add(JobStatus status) {
        if(!jobStatuses.add(status)) {
            throw new AlreadyExistsException("Job id " + status.getId() + " already in the list");
        }
    }

    public void update(String jobId, Progress progress) {
        JobStatus jobStatus = getJobStatus(jobId);
        jobStatus.setStatus(progress);
        
    }

    public JobStatus getJobStatus(String jobId) {
        JobStatus foundStatus = null;
        for(JobStatus status : jobStatuses) {
            if(status.getId().equals(jobId)) {
                 foundStatus = status;
            }
        }

        if(foundStatus == null) {
            throw new JobNotFoundException("Job status not found");
        }
        return foundStatus;
    }


}

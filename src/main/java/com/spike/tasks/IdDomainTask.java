package com.spike.tasks;


import com.google.inject.Inject;
import com.spike.service.HDFSService;
import com.spike.service.JobService;

public class IdDomainTask implements Task {
    HDFSService hdfsService;
    JobService jobService;

    @Inject
    public IdDomainTask(HDFSService hdfsService, JobService jobService) {
        this.hdfsService = hdfsService;
        this.jobService = jobService;
    }

    @Override
    public void execute() {
        hdfsService.getFileSize();
        hdfsService.getFile();
        jobService.run();
        System.out.println("Running IDDomainTask with hdfsService ");
    }
}

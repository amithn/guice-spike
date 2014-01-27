package com.spike.tasks;


import com.google.inject.Inject;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.util.Arguments;

import java.util.Arrays;

public class IdDomainTask implements Task {
    private final Arguments consoleArguments;
    HDFSService hdfsService;
    JobService jobService;

    @Inject
    public IdDomainTask(HDFSService hdfsService, JobService jobService, Arguments consoleArguments) {
        this.hdfsService = hdfsService;
        this.jobService = jobService;
        this.consoleArguments = consoleArguments;
    }

    @Override
    public void execute() {
        System.out.println("Arguments are as follows " + Arrays.toString(consoleArguments.get()));
    }
}

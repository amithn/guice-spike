package com.spike.app;

import com.google.inject.Inject;
import com.spike.job.Job;
import com.spike.job.JobRunner;
import com.spike.logger.Log;
import com.spike.util.Arguments;

public class App {

    private String[] consoleargs;
    private JobRunner jobRunner;

    @Inject
    public App(JobRunner jobRunner, Arguments args) {
        this.jobRunner = jobRunner;
        this.consoleargs = args.get();
    }

    @Log
    public void run(Job job) {
        jobRunner.execute(job);
    }


}

package com.ssda.app;

import com.google.inject.Inject;
import com.ssda.job.Job;
import com.ssda.job.JobRunner;
import com.ssda.logger.Timed;
import com.ssda.util.Arguments;

public class App {

    private String[] consoleargs;
    private JobRunner jobRunner;

    @Inject
    public App(JobRunner jobRunner, Arguments args) {
        this.jobRunner = jobRunner;
        this.consoleargs = args.get();
    }

    @Timed
    public void run(Job job) {
        jobRunner.execute(job);
    }
}

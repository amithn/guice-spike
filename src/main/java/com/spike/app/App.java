package com.spike.app;

import com.google.inject.Inject;
import com.spike.job.Job;
import com.spike.job.JobRunner;
import com.spike.util.Arguments;

public class App {

    private String[] consoleargs;
    private JobRunner jobRunner;

    @Inject
    public App(JobRunner jobRunner, Arguments args) {
        this.jobRunner = jobRunner;
        this.consoleargs = args.get();
    }


	public void run(Job job) {
		jobRunner.execute(job);
	}


}

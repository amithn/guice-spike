package com.spike.app;

import com.google.inject.Inject;
import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.job.JobRunner;
import com.spike.tasks.DriveTask;
import com.spike.tasks.PrintTask;
import com.spike.util.GuiceTaskFactory;

public class App {

    private static String[] consoleargs;

	@Inject
	private JobRunner jobRunner;

	private void run(Job job) {
		jobRunner.execute(job);
	}

    public static void main(String args[]) {
        consoleargs = args;
		App app = GuiceTaskFactory.getInstance(App.class);

		Job canadaJob = new JobBuilder().addTask(PrintTask.class)
									    .addTask(DriveTask.class)
									    .build();
		app.run(canadaJob);
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

package com.spike.app;

import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.tasks.DriveTask;
import com.spike.tasks.PrintTask;

public class App {

    private static String[] consoleargs;

    public static void main(String args[]) {
        consoleargs = args;
        Job canadaJob = new JobBuilder().addTask(PrintTask.class)
									    .addTask(DriveTask.class)
									    .build();

        canadaJob.execute();
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

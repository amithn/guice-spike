package com.spike.app;

import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.tasks.CopyTask;
import com.spike.tasks.WordCountTask;

public class App {

    private static String[] consoleargs;

    public static void main(String args[]) {
        consoleargs = args;
        Job canadaJob = new JobBuilder<Job>(Job.class).addTask(CopyTask.class)
                                                      .addTask(WordCountTask.class)
                                                      .build();
        canadaJob.execute();
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

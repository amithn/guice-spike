package com.spike.app;


import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.tasks.AggregateCustomersTask;
import com.spike.tasks.DriveTask;
import com.spike.tasks.PrintTask;
import com.spike.util.GuiceTaskFactory;

public class Main {

    private static String[] consoleargs;

    public static void main(String args[]) {
        consoleargs = args;
        App app = GuiceTaskFactory.getInstance(App.class);

        Job canadaJob = new JobBuilder().addTask(PrintTask.class)
                .addTask(DriveTask.class)
                .addTask(AggregateCustomersTask.class)
                .build();
        app.run(canadaJob);
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

package com.ssda.app;


import com.ssda.job.Job;
import com.ssda.job.JobBuilder;
import com.ssda.tasks.MongoDBTableLoaderTask;
import com.ssda.tasks.AggregateCustomersTask;
import com.ssda.tasks.JoinCustomersHiveTask;
import com.ssda.util.GuiceTaskFactory;

public class Main {

    private static String[] consoleargs;

    public static void main(String args[]) {
        consoleargs = args;
        App app = GuiceTaskFactory.getInstance(App.class);

        Job custAggrJob = new JobBuilder()
                .addTask(AggregateCustomersTask.class)
                .addTask(JoinCustomersHiveTask.class)
                .addTask(MongoDBTableLoaderTask.class)
                .build();

        app.run(custAggrJob);
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

package com.spike.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.config.AppConfig;
import com.spike.job.DemogVisitsJob;
import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.tasks.CopyTask;
import com.spike.tasks.IdDomainTask;
import com.spike.tasks.TransferTask;

public class App {

    private static String[] consoleargs;

    public static void main(String args[]) {
        consoleargs = args;
        Injector injector = Guice.createInjector(new AppConfig());
        IdDomainTask task = injector.getInstance(IdDomainTask.class);
        CopyTask copyTask = injector.getInstance(CopyTask.class);
        TransferTask transferTask = injector.getInstance(TransferTask.class);

        DemogVisitsJob demogVisits = injector.getInstance(DemogVisitsJob.class);

        Job job = new JobBuilder().addTask(transferTask).addTask(task).addTask(copyTask).build();
        job.execute();
    }

    public static String[] getArgs() {
        return consoleargs;
    }
}

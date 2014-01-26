package com.spike.config;


import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.spike.app.App;
import com.spike.job.DemogVisitsJob;
import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.service.SuperJobServiceImpl;
import com.spike.service.SweetHDFSServiceImpl;
import com.spike.tasks.*;
import com.spike.util.Arguments;
import com.spike.util.ConsoleArguments;

public class AppConfig implements Module {

	@Inject
	HDFSService hdfsService;

	@Inject
	JobService jobService;

    @Override
    public void configure(Binder binder) {
        binder.bind(IdDomainTask.class).toInstance(idDomainTask());
        binder.bind(CopyTask.class).toInstance(copyTask());
        binder.bind(TransferTask.class).toInstance(transferTask());
        binder.bind(Arguments.class).toInstance(consoleArguments());
    }


    @Provides
    public DemogVisitsJob demographicVisits() {
         return (DemogVisitsJob) new JobBuilder()
                         .addTask(copyTask())
                         .addTask(transferTask())
                         .addTask(idDomainTask())
                         .build();
    }

    public Arguments consoleArguments() {
         return new ConsoleArguments(App.getArgs());
    }

    public IdDomainTask idDomainTask() {
        return new IdDomainTask(hdfsService,
								jobService,
								consoleArguments());
    }

    public CopyTask copyTask() {
        return new CopyTask(hdfsService);
    }

    public TransferTask transferTask() {
        return new TransferTask(hdfsService);
    }


}

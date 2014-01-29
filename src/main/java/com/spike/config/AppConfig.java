package com.spike.config;


import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.spike.app.App;
import com.spike.app.GuiceFactory;
import com.spike.service.JobService;
import com.spike.tasks.CopyTask;
import com.spike.tasks.DriveTask;
import com.spike.tasks.PrintTask;
import com.spike.tasks.TransferTask;
import com.spike.util.Arguments;
import com.spike.util.ConsoleArguments;

public class AppConfig implements Module {

    ServiceConfig serviceConfig;

    @Inject
    public AppConfig(ServiceConfig config) {
           this.serviceConfig = config;
    }

	@Inject
	JobService jobService;

    @Override
    public void configure(Binder binder) {
        binder.bind(ServiceConfig.class);
        binder.bind(JobConfig.class);
        binder.bind(CopyTask.class).toInstance(copyTask());
        binder.bind(DriveTask.class).to(DriveTask.class);
        binder.bind(PrintTask.class).to(PrintTask.class);
        binder.bind(TransferTask.class).toInstance(transferTask());
        binder.bind(Arguments.class).toInstance(consoleArguments());
		binder.bind(GuiceFactory.class).to(GuiceFactory.class).asEagerSingleton();
    }

    public Arguments consoleArguments() {
         return new ConsoleArguments(App.getArgs());
    }

    public CopyTask copyTask() {
        return new CopyTask(serviceConfig.hdfsService());
    }

    public TransferTask transferTask() {
        return new TransferTask(serviceConfig.hdfsService());
    }
}

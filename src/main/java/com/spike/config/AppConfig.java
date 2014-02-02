package com.spike.config;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.spike.app.App;
import com.spike.app.Main;
import com.spike.util.Arguments;
import com.spike.util.ConsoleArguments;
import com.spike.util.GuiceTaskFactory;

public class AppConfig implements Module {

    ServiceConfig serviceConfig;

//	@Inject
//	JobService jobService;

    @Override
    public void configure(Binder binder) {
        binder.bind(ServiceConfig.class);
        binder.bind(JobConfig.class);
       // binder.bind(CopyTask.class).toInstance(copyTask());
       // binder.bind(DriveTask.class).to(DriveTask.class);
       // binder.bind(PrintTask.class).to(PrintTask.class);
       // binder.bind(TransferTask.class).toInstance(transferTask());
        binder.bind(Arguments.class).toInstance(consoleArguments());
		binder.bind(GuiceTaskFactory.class);
		binder.bind(App.class);
    }

    public Arguments consoleArguments() {
         return new ConsoleArguments(Main.getArgs());
    }


//    public CopyTask copyTask() {
//        return new CopyTask(serviceConfig.hdfsService());
//    }
//
//    public TransferTask transferTask() {
//        return new TransferTask(serviceConfig.hdfsService());
//    }
}

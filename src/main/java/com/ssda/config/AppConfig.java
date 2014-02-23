package com.ssda.config;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.ssda.app.App;
import com.ssda.app.Main;
import com.ssda.util.Arguments;
import com.ssda.util.ConsoleArguments;
import com.ssda.util.GuiceTaskFactory;

public class AppConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(ServiceConfig.class);
        binder.bind(JobConfig.class);
        binder.bind(Arguments.class).toInstance(consoleArguments());
        binder.bind(GuiceTaskFactory.class);
        binder.bind(App.class);
    }

    public Arguments consoleArguments() {
        return new ConsoleArguments(Main.getArgs());
    }
}

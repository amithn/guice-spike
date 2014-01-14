package com.spike.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.config.AppConfig;
import com.spike.tasks.IdDomainTask;

public class App {

    public static void main(String args[]) {
        Injector injector = Guice.createInjector(new AppConfig());
        IdDomainTask task = injector.getInstance(IdDomainTask.class);
        task.execute();
    }
}

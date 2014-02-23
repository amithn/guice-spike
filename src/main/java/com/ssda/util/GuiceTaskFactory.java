package com.ssda.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ssda.config.InterceptorConfig;
import com.ssda.config.AppConfig;
import com.ssda.config.JobConfig;
import com.ssda.config.ServiceConfig;
import com.ssda.tasks.Task;

public class GuiceTaskFactory {
    private static final Injector injector;

    static {
        injector = Guice.createInjector(new AppConfig(),
                                        new ServiceConfig(),
                                        new JobConfig(),
                                        new InterceptorConfig());
    }

    public static <T> T getInstance(Class<T> clazz) {
        return injector.getInstance(clazz);

    }

    public static Task getTask(Class<? extends Task> taskInstance) {
        return injector.getInstance(taskInstance);
    }
}

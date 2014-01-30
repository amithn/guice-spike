package com.spike.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.config.AppConfig;
import com.spike.config.ServiceConfig;
import com.spike.tasks.Task;

public class GuiceTaskFactory {
    private static final Injector injector;

	static {
		injector = Guice.createInjector(new AppConfig(), new ServiceConfig());
	}

	public static <T> T getInstance(Class<T> clazz) {
		return injector.getInstance(clazz);

	}

    public static Task getTask(Class<? extends Task> taskInstance) {
        return injector.getInstance(taskInstance);
    }
}

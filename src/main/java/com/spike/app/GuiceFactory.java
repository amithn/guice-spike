package com.spike.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.spike.config.AppConfig;
import com.spike.config.ServiceConfig;

public class GuiceFactory {
    private static final Injector injector;

    static {
        injector = Guice.createInjector(new AppConfig(new ServiceConfig()), new ServiceConfig());
    }

    public static Injector getInjector() {
        return injector;
    }
}

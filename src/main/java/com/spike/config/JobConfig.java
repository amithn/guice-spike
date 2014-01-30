package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;

public class JobConfig implements Module {

    private final ServiceConfig serviceConfig;

    @Inject
    public JobConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;

    }

    @Override
    public void configure(Binder binder) {
    }
}

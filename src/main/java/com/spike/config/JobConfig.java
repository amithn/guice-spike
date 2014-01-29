package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.spike.job.CanadaJob;
import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.tasks.CopyTask;
import com.spike.tasks.TransferTask;

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

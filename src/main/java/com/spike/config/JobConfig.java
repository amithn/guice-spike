package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.spike.service.JobService;
import com.spike.service.JobServiceImpl;

public class JobConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(JobService.class).to(JobServiceImpl.class);
    }
}

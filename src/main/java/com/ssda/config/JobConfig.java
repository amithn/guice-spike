package com.ssda.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.ssda.service.JobService;
import com.ssda.service.JobServiceImpl;

public class JobConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(JobService.class).to(JobServiceImpl.class);
    }
}

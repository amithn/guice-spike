package com.spike.config;


import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.service.SuperJobServiceImpl;
import com.spike.service.SweetHDFSServiceImpl;
import com.spike.tasks.IdDomainTask;

public class AppConfig implements Module {

    @Override
    public void configure(Binder binder) {
       // binder.bind(HDFSService.class).to(SweetHDFSServiceImpl.class);
       // binder.bind(JobService.class).to(SuperJobServiceImpl.class);
    }

    @Provides
    public IdDomainTask idDomainTask() {
        return new IdDomainTask(hdfsService(), jobService());
    }

    @Provides
    public HDFSService hdfsService() {
        return new SweetHDFSServiceImpl();
    }

    @Provides
    public JobService jobService() {
        return new SuperJobServiceImpl(hdfsService());
    }
}

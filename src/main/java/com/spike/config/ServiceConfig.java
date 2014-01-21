package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.service.SuperJobServiceImpl;
import com.spike.service.SweetHDFSServiceImpl;


public class ServiceConfig implements Module {
	@Override
	public void configure(Binder binder) {
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

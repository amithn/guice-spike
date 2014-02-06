package com.spike.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.spike.logger.Log;
import com.spike.logger.LoggingInterceptor;

public class InterceptorConfig extends AbstractModule {

    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Log.class),
                new LoggingInterceptor());

    }
}

package com.spike.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.spike.logger.MeasureTimeInterceptor;
import com.spike.logger.Timed;

public class InterceptorConfig extends AbstractModule {

    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Timed.class),
                new MeasureTimeInterceptor());
    }
}

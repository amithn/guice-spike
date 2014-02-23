package com.ssda.config;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.ssda.logger.MeasureTimeInterceptor;
import com.ssda.logger.Timed;

public class InterceptorConfig extends AbstractModule {

    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(Timed.class),
                new MeasureTimeInterceptor());
    }
}

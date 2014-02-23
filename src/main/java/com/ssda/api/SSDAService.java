package com.ssda.api;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.ssda.checks.DatabaseHealthCheck;
import com.ssda.config.*;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/19/14
 */
public class SSDAService extends Service<SSDAConfiguration> {
    public static void main(String[] args) throws Exception {
        new SSDAService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SSDAConfiguration> bootstrap) {
        bootstrap.setName("Self Serve Data Analytics Service");

        GuiceBundle<SSDAConfiguration> guiceBundle = GuiceBundle.<SSDAConfiguration>newBuilder()
                .addModule(new QueueConfig())
                .addModule(new ServiceConfig())
                .addModule(new AppConfig())
                .addModule(new InterceptorConfig())
                .addModule(new JobConfig())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(SSDAConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(SSDAConfiguration configuration,
                    Environment environment) {
        environment.addHealthCheck(new DatabaseHealthCheck());
    }
}

package com.spike.api;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.spike.config.AppConfig;
import com.spike.config.InterceptorConfig;
import com.spike.config.JobConfig;
import com.spike.config.ServiceConfig;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/19/14
 */
public class SSDAService extends Service<SSDAConfiguration> {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting SSDA Service");
        new SSDAService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SSDAConfiguration> bootstrap) {
        bootstrap.setName("hello-world");

        GuiceBundle<SSDAConfiguration> guiceBundle = GuiceBundle.<SSDAConfiguration>newBuilder()
                .addModule(new ServiceConfig())
                .addModule(new AppConfig())
                .addModule(new InterceptorConfig())
                .addModule(new JobConfig())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(SSDAConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
        System.out.println("Leaving initialize()");
    }

    @Override
    public void run(SSDAConfiguration configuration,
                    Environment environment) {
        System.out.println("Inside run()");
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new SSDAResource(template, defaultName));
    }
}

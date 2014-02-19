package com.spike.api;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.spike.service.JobService;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SSDAResource {

    @Inject
    private JobService jobService;

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        System.out.println("jobService is " + jobService.getClass().getSimpleName());
        return new Saying(1,
                String.format("Hello %s", name.or("Stranger")));
    }
}


package com.spike.api;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.spike.job.Job;
import com.spike.job.JobBuilder;
import com.spike.job.JobRunner;
import com.spike.service.JobService;
import com.spike.tasks.AggregateCustomersTask;
import com.spike.tasks.JoinCustomersHiveTask;
import com.spike.tasks.MongoDBTableLoaderTask;
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

    private final JobRunner jobRunner;

    @Inject
    public SSDAResource(JobRunner jobRunner) {
        this.jobRunner = jobRunner;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        Job custAggrJob = new JobBuilder()
                .addTask(AggregateCustomersTask.class)
                .addTask(JoinCustomersHiveTask.class)
                .addTask(MongoDBTableLoaderTask.class)
                .build();

        jobRunner.execute(custAggrJob);

        return new Saying(1,
                String.format("Hello %s", name.or("Stranger")));
    }
}


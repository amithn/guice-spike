package com.ssda.api;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.ssda.job.Job;
import com.ssda.job.JobBuilder;
import com.ssda.job.JobRunner;
import com.ssda.queue.MessageQueueService;
import com.ssda.queue.SSDAEvent;
import com.ssda.tasks.AggregateCustomersTask;
import com.ssda.tasks.JoinCustomersHiveTask;
import com.ssda.tasks.MongoDBTableLoaderTask;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SSDAResource {

    private final JobRunner jobRunner;
    private final MessageQueueService<SSDAEvent> queueService;

    @Inject
    public SSDAResource(JobRunner jobRunner, MessageQueueService<SSDAEvent> queueService) {
        this.jobRunner = jobRunner;
        this.queueService = queueService;
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


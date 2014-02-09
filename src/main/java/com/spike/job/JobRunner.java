package com.spike.job;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.spike.logger.LoggerUtil;
import com.spike.service.MongoLoggingService;
import com.spike.tasks.Task;
import com.spike.util.GuiceTaskFactory;

import java.util.Date;

public class JobRunner {

    private final MongoLoggingService loggingService;
    private GuiceTaskFactory factory;

    @Inject
    public JobRunner(GuiceTaskFactory factory, MongoLoggingService loggingService) {
        this.factory = factory;
        this.loggingService = loggingService;
    }

    public void execute(Job job) {
        BasicDBObject doc;

        for (Class<? extends Task> task : job.getTasks()) {
            Task injectedTask = factory.getTask(task);
            injectedTask.execute();
            doc = new BasicDBObject("name", task.getSimpleName()).
                    append("type", "ETL").
                    append("time", new Date());
            loggingService.logJobMessage(doc);
        }
    }


}

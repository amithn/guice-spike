package com.spike.job;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.spike.tasks.Task;
import com.spike.util.GuiceTaskFactory;

public class JobRunner {

    private GuiceTaskFactory factory;

    @Inject
    public JobRunner(GuiceTaskFactory factory) {
        this.factory = factory;
    }

    public void execute(Job job) {
        BasicDBObject doc;

        for (Class<? extends Task> task : job.getTasks()) {
            Task injectedTask = factory.getTask(task);
            injectedTask.execute();
        }
    }
}

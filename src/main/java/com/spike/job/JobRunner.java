package com.spike.job;

import com.google.inject.Inject;
import com.spike.logger.Timed;
import com.spike.tasks.Task;
import com.spike.util.GuiceTaskFactory;

public class JobRunner {

    private GuiceTaskFactory factory;

    @Inject
    public JobRunner(GuiceTaskFactory factory) {
        this.factory = factory;
    }

    @Timed
    public void execute(Job job) {
        for (Class<? extends Task> task : job.getTasks()) {
            Task injectedTask = factory.getTask(task);
            injectedTask.execute();
        }
    }
}

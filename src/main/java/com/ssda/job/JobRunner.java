package com.ssda.job;

import com.google.inject.Inject;
import com.ssda.logger.Timed;
import com.ssda.tasks.Task;
import com.ssda.util.GuiceTaskFactory;

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

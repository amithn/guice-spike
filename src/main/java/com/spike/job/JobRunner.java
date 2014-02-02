package com.spike.job;

import com.google.inject.Inject;
import com.spike.tasks.Task;
import com.spike.util.GuiceTaskFactory;

public class JobRunner {

	@Inject
	private GuiceTaskFactory factory;

	public JobRunner() {
	}

	public void execute(Job job) {
		for(Class<? extends Task> task : job.getTasks()) {
			Task injectedTask = factory.getInstance(task);
			System.out.println("Executing task " + injectedTask.getClass().getSimpleName());
			injectedTask.execute();
		}
	}


}

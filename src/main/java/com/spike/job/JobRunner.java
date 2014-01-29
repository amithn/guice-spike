package com.spike.job;
import  com.spike.tasks.Task;



public class JobRunner implements Task {

	private Job job;

	public JobRunner(Job job) {
		this.job = job;
	}

	@Override
	public void execute() {
		job.execute();
	}


}

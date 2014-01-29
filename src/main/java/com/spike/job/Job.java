package com.spike.job;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.spike.app.GuiceFactory;
import com.spike.tasks.Task;

import java.util.List;

public class Job<T> implements Task {
    private List<Class> tasks;

	@Inject
	GuiceFactory factory;

    public Job() {
    }

    public final void execute() {
        for(Class<Task> task : tasks) {
            Injector injector = factory.getInjector();
			Task injectedTask = injector.getInstance(task);
			System.out.println("Executing task " + injectedTask.getClass().getSimpleName());
			injectedTask.execute();
		}
    }

    public void setTasks(List<Class> tasks) {
        this.tasks = tasks;
    }

	/* For testing purposes only */
	public void setFactory(GuiceFactory factory) {
		this.factory = factory;
	}

}

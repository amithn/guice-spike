package com.spike.job;

import com.google.inject.Injector;
import com.spike.app.GuiceFactory;
import com.spike.tasks.Task;

import java.util.List;

public class Job<T> implements Task {
    private List<Class> tasks;

    public Job() {
    }

    public final void execute() {
        for(Class<Task> task : tasks) {
              System.out.println("Executing task " + task.getClass().getSimpleName());
              Injector injector = GuiceFactory.getInjector();
              Task injectedTask = injector.getInstance(task);
              injectedTask.execute();
        }
    }

    public void setTasks(List<Class> tasks) {
        this.tasks = tasks;
    }

}

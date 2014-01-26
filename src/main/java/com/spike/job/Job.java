package com.spike.job;

import com.spike.tasks.Task;

import java.util.List;

public class Job implements Task {
    private List<Task> tasks;

    public Job() {

    }

    public Job(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void execute() {
        for(Task task : tasks) {
              System.out.println("Executing task " + task.getClass().getSimpleName());
              task.execute();
        }
    }

}

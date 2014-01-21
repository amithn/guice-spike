package com.spike.job;

import com.spike.tasks.Task;

import java.util.List;

public class Job implements Task {
    private List<Task> tasks;

    public Job(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void execute() {
        for(Task task : tasks) {
              task.execute();
        }
    }

}

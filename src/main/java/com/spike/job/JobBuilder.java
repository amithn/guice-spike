package com.spike.job;

import com.spike.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class JobBuilder {
    private List<Task> tasks;

    public JobBuilder() {
        tasks = new ArrayList<Task>();
    }

    public JobBuilder addTask(Task task) {
        tasks.add(task);
        return this;
    }

    public Job build() {
        return new Job(tasks);
    }


}

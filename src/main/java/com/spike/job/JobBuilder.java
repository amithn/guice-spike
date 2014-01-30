package com.spike.job;

import com.spike.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class JobBuilder {

    List<Class<? extends Task>> tasks = new ArrayList<Class<? extends Task>>();

    public JobBuilder() {
    }

    public JobBuilder addTask(Class<? extends Task> task) {
        tasks.add(task);
        return this;
    }

    public Job build() {
        return new Job(tasks);
    }
}
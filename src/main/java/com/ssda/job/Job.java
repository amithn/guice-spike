package com.ssda.job;

import com.ssda.tasks.Task;

import java.util.ArrayList;
import java.util.List;

/** A job is a collection of tasks **/

public class Job {
    private List<Class<? extends Task>> tasks = new ArrayList<Class<? extends Task>>();

    protected Job(List<Class<? extends Task>> tasks) {
        this.tasks = tasks;
    }

    public List<Class<? extends Task>> getTasks() {
        return tasks;
    }
}

package com.spike.job;

import com.spike.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Job {
    private List<Class<? extends Task>> tasks = new ArrayList<Class<? extends Task>>();

    protected Job(List<Class<? extends Task>> tasks) {
		this.tasks = tasks;
    }

	public List<Class<? extends Task>>  getTasks() {
		return tasks;
	}
}

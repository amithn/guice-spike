package com.spike.tasks;

public class TaskProcessor implements Task{

    private final Task task;

    public TaskProcessor(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {

    }
}

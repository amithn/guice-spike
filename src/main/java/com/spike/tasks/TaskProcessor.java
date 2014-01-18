package com.spike.tasks;

/**
 * Created with IntelliJ IDEA.
 * User: cloudera
 * Date: 1/18/14
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskProcessor implements Task{

    private final Task task;

    public TaskProcessor(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

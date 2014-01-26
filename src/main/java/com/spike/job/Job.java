package com.spike.job;

import com.spike.tasks.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cloudera
 * Date: 1/18/14
 * Time: 11:26 PM
 * To change this template use File | Settings | File Templates.
 */
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

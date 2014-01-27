package com.spike.job;

import com.spike.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class JobBuilder<T extends Job> {

    Class<T> clazz;
    List<Class<?>> tasks = new ArrayList<Class<?>>();

    public JobBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    public JobBuilder addTask(Class<? extends Task> task) {
        tasks.add(task);
        return this;
    }

    public T build() {
        T instance = null;
        try {
            instance = clazz.newInstance();
            instance.setTasks(tasks);
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return instance;
    }
}
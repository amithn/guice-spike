package com.spike.tasks;

import com.google.inject.Inject;
import com.spike.util.Arguments;

public class PrintTask implements Task {

    @Inject
    Arguments consoleArgs;

    @Inject
    public PrintTask() {
    }

    @Override
    public void execute() {
        System.out.println("Executing PrintTask " + "[Hello World]");
    }
}

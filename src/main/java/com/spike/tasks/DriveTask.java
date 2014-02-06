package com.spike.tasks;

import com.google.inject.Inject;
import com.spike.logger.Log;
import com.spike.util.Arguments;

public class DriveTask implements Task {

    @Inject
    Arguments consoleArgs;

    @Inject
    public DriveTask() {
    }

    @Override
    @Log
    public void execute() {
        System.out.println("Executing DriveTask " + "[Wrooom ......]");
    }
}

package com.spike.tasks;

import com.google.inject.Inject;
import com.spike.service.HDFSService;
import com.spike.util.Arguments;

import java.util.Arrays;

<<<<<<< HEAD
=======

>>>>>>> 48c52070024dc7dd412fe361b305ff06e493b113
public class CopyTask implements Task {

    private HDFSService hdfsService;

    @Inject
    Arguments consoleArgs;

    public CopyTask(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void execute() {
        System.out.println("Executing copyTask from hdfs" + Arrays.toString(consoleArgs.get()));
    }
}

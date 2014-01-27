package com.spike.tasks;

import com.google.inject.Inject;
import com.spike.service.HDFSService;
import com.spike.util.Arguments;

import java.util.Arrays;

public class CopyTask implements Task {

    private HDFSService hdfsService;

    @Inject
    Arguments consoleArgs;

    @Inject
    public CopyTask(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void execute() {
        System.out.println("Executing copyTask from local" + Arrays.toString(consoleArgs.get()));
        hdfsService.copyFileToHDFS("/home/cloudera/hivedata/transactions.txt", "trans.txt");
    }
}

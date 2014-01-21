package com.spike.tasks;

import com.spike.service.HDFSService;


public class CopyTask implements Task {

    private HDFSService hdfsService;

    public CopyTask(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }


    @Override
    public void execute() {
        System.out.println("Executing copyTask from hdfs");
    }
}

package com.spike.tasks;

import com.spike.service.HDFSService;

/**
 * Created with IntelliJ IDEA.
 * User: cloudera
 * Date: 1/18/14
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
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

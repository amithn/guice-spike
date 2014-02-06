package com.spike.tasks;

import com.spike.service.HDFSService;

public class TransferTask implements Task {
    private HDFSService hdfsService;

    public TransferTask(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void execute() {
    }
}

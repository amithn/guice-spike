package com.spike.tasks;

import com.spike.service.HiveService;

import javax.inject.Inject;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/2/14
 */
public class AggregateCustomersTask implements Task {

    private final HiveService hiveService;

    @Inject
    public AggregateCustomersTask(HiveService hiveService) {
        this.hiveService = hiveService;
    }


    @Override
    public void execute() {
        hiveService.execute("show tables");
    }
}

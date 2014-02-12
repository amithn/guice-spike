package com.spike.tasks;


import com.google.inject.Inject;
import com.spike.logger.Timed;
import com.spike.service.HiveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinCustomersHiveTask implements Task {

    private final HiveService hiveService;
    Logger logger = LoggerFactory.getLogger(JoinCustomersHiveTask.class);

    @Inject
    public JoinCustomersHiveTask(HiveService hiveService) {
        this.hiveService = hiveService;
    }

    @Timed
    @Override
    public void execute() {
        hiveService.execute("drop table customers");
        hiveService.createTableFromTextFiles("customers", "name STRING, amount FLOAT", ',', ':', '~', '-', "/user/cloudera/customer/output");
    }
}

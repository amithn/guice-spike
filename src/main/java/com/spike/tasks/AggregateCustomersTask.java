package com.spike.tasks;

import com.spike.mapreduce.CustomerMapper;
import com.spike.mapreduce.CustomerReducer;
import com.spike.service.*;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/2/14
 */
public class AggregateCustomersTask implements Task {

    private final HiveService hiveService;
    private final JobService jobService;
    private final HDFSService hdfsService;

    @Inject
    public AggregateCustomersTask(HDFSService hdfsService, HiveService hiveService, JobService jobService) {
        this.hdfsService = hdfsService;
        this.hiveService = hiveService;
        this.jobService = jobService;
    }

    @Override
    public void execute() {
        hdfsService.copyFileToHDFS("/home/cloudera/hivedata/customers.txt", "customer/input/customers.txt");

        MapReduceConf mapReduceConfig = createMapReduceConfig();
        jobService.run(mapReduceConfig);

//        hiveService.execute("drop table customers");
//        hiveService.createTableFromTextFiles("customers", "id INT, name String", ',', ':', '~', '-', "/user/cloudera/customer");
//
//        ResultSet resultSet = hiveService.executeQuery("show tables");
//        try {
//            while (resultSet.next()) {
//                System.out.println("Table Name is " + resultSet.getString(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    private MapReduceConf createMapReduceConfig() {
        return new MapReduceConfBuilder().withCurrentClass(this.getClass())
                                                       .withJobName("AggregateCustomers")
                                                       .withMapperClass(CustomerMapper.class)
                                                       .withReducerClass(CustomerReducer.class)
                                                       .withInputFormat(TextInputFormat.class)
                                                       .withOutputFormat(TextOutputFormat.class)
                                                       .withInputDir("customer/input")
                                                       .withOutputDir("customer/output")
                                                       .withOutputKeyClass(Integer.class)
                                                       .withOutputValueClass(FloatWritable.class)
                                                       .withCurrentClass(this.getClass())
                                                       .build();
    }
}
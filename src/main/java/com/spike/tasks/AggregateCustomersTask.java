package com.spike.tasks;

import com.spike.logger.Log;
import com.spike.mapreduce.CustomerMapper;
import com.spike.mapreduce.CustomerReducer;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.service.MapReduceConf;
import com.spike.service.MapReduceConfBuilder;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import javax.inject.Inject;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/2/14
 */
public class AggregateCustomersTask implements Task {

    private final JobService jobService;
    private final HDFSService hdfsService;

    @Inject
    public AggregateCustomersTask(HDFSService hdfsService, JobService jobService) {
        this.hdfsService = hdfsService;
        this.jobService = jobService;
    }

    @Override
    @Log
    public void execute() {
        hdfsService.copyFileToHDFS("/home/cloudera/hivedata/customers.txt", "customer/input/customers.txt");
        hdfsService.removeDirectory("customer/output");

        MapReduceConf mapReduceConfig = createMapReduceConfig();
        jobService.run(mapReduceConfig);
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
                                                       .withJar("/home/cloudera/workspaces/guice-spike/build/libs/guice-spike-1.0.jar")
                                                       .withOutputKeyClass(Text.class)
                                                       .withOutputValueClass(FloatWritable.class)
                                                       .withCurrentClass(this.getClass())
                                                       .build();
    }
}
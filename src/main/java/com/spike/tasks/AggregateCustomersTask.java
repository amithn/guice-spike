package com.spike.tasks;

import com.spike.logger.Timed;
import com.spike.mapreduce.*;
import com.spike.service.FakeHDFS;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import javax.inject.Inject;

public class AggregateCustomersTask implements Task {

    private final JobService jobService;
    private final HDFSService hdfsService;

    @Inject
    public AggregateCustomersTask(HDFSService hdfsService, JobService jobService) {
        this.hdfsService = hdfsService;
        this.jobService = jobService;
    }

    @Override
    @Timed
    public void execute() {
        hdfsService.copyFileToHDFS("/home/cloudera/hivedata/customers.txt", "customer/input/customers.txt");
        hdfsService.removeDirectory("customer/output");

        MapReduceConf mapReduceConfig = createMapReduceConfig();
        jobService.run(mapReduceConfig);
    }

    private MapReduceConf createMapReduceConfig() {
        return new MapReduceConfBuilder().withJobName("AggregateCustomers")
                                       .withMapperClass(AggregateCustomerMapper.class)
                                       .withReducerClass(AggregateCustomerReducer.class)
                                       .withInputFormat(TextInputFormat.class)
                                       .withOutputFormat(TextOutputFormat.class)
                                       .withInputDir("customer/input")
                                       .withOutputDir("customer/output")
                                       .withJar("/home/cloudera/testbed/guicespike/build/libs/guicespike-1.0.jar")
                                       .withOutputKeyClass(Text.class)
                                       .withOutputValueClass(FloatWritable.class)
                                       .withCurrentClass(this.getClass())
                                       .build();
    }

    @Inject
    public void setHDFSService(@FakeHDFS HDFSService service) {
        /* Do nothing */
    }
}
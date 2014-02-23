package com.ssda.tasks;

import com.ssda.logger.Timed;
import com.ssda.mapreduce.*;
import com.ssda.service.FakeHDFS;
import com.ssda.service.HDFSService;
import com.ssda.service.JobService;
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
                                       .withJar("/home/cloudera/testbed/ssda-service/build/libs/ssda-service-1.0.jar")
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
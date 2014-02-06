package com.spike.service;


import com.spike.tasks.AggregateCustomersTask;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class JobServiceImpl implements JobService {

    public JobServiceImpl() {
    }

    @Override
    public void run(MapReduceConf mapReduceConf) {
        Configuration config = new Configuration();
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/core-site.xml"));
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/hdfs-site.xml"));
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/mapred-site.xml"));


        JobConf conf = new JobConf(config, mapReduceConf.getCurrentClass());
        conf.setJobName(mapReduceConf.getJobName());

        conf.setOutputKeyClass(mapReduceConf.getOutputKeyClass());
        conf.setOutputValueClass(mapReduceConf.getOutputValueClass());

        conf.setMapperClass(mapReduceConf.getMapperClass());
        conf.setReducerClass(mapReduceConf.getReducerClass());

        conf.setInputFormat(mapReduceConf.getInputFormat());
        conf.setOutputFormat(mapReduceConf.getOutputFormat());
        conf.setJar(mapReduceConf.getPathToJar());

        FileInputFormat.setInputPaths(conf, new Path(mapReduceConf.getInputDir()));
        FileOutputFormat.setOutputPath(conf, new Path(mapReduceConf.getOutputDir()));

        JobClient client = null;
        try {
            client = new JobClient(config);
            RunningJob runningJob = client.submitJob(conf);
            runningJob.waitForCompletion();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

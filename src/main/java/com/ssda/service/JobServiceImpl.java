package com.ssda.service;


import com.google.inject.Inject;
import com.ssda.mapreduce.MapReduceConf;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class JobServiceImpl implements JobService {

    private final Configuration config;

    @Inject
    public JobServiceImpl(Configuration config) {
        this.config = config;
    }

    @Override
    public void run(MapReduceConf mapReduceConf) {
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

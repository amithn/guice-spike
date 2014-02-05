package com.spike.service;


import com.google.inject.Inject;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class JobServiceImpl implements JobService {

    public JobServiceImpl() {
    }

    @Override
    public void run(MapReduceConf mapReduceConf) {
        System.out.println("Get info called on " + this.getClass().getSimpleName());
        JobConf conf = new JobConf(mapReduceConf.getCurrentClass());
        conf.setJobName(mapReduceConf.getJobName());

        conf.setOutputKeyClass(mapReduceConf.getOutputKeyClass());
        conf.setOutputValueClass(mapReduceConf.getOutputValueClass());

        conf.setMapperClass(mapReduceConf.getMapperClass());
        conf.setReducerClass(mapReduceConf.getReducerClass());

        conf.setInputFormat(mapReduceConf.getInputFormat());
        conf.setOutputFormat(mapReduceConf.getOutputFormat());

        FileInputFormat.setInputPaths(conf, new Path(mapReduceConf.getInputDir()));
        FileOutputFormat.setOutputPath(conf, new Path(mapReduceConf.getOutputDir()));

        try {
            JobClient.runJob(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.spike.service;

import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.Reducer;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/5/14
 */
public class MapReduceConf {
    private final String pathToJar;
    Class<? extends Mapper> mapperClass;
    Class<? extends Reducer> reducerClass;
    Class<? extends InputFormat> inputFormat;
    Class<? extends OutputFormat> outputFormat;

    Class<?> outputKeyClass;
    Class<?> outputValueClass;

    Class<?> currentClass;

    String inputDir;
    String outputDir;
    private String jobName;

    protected MapReduceConf(Class<? extends Mapper> mapperClass, Class<? extends Reducer> reducerClass,
                         Class<? extends InputFormat> inputFormat, Class<? extends OutputFormat> outputFormat,
                         Class<?> outputKeyClass, Class<?> outputValueClass, Class<?> currentClass,
                         String inputDir, String outputDir, String pathToJar, String jobName) {
        this.mapperClass = mapperClass;
        this.reducerClass = reducerClass;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.outputKeyClass = outputKeyClass;
        this.outputValueClass = outputValueClass;
        this.currentClass = currentClass;
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.pathToJar = pathToJar;
        this.jobName = jobName;
    }


    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public Class<? extends Reducer> getReducerClass() {
        return reducerClass;
    }

    public Class<? extends Mapper> getMapperClass() {
        return mapperClass;
    }

    public Class<? extends InputFormat> getInputFormat() {
        return inputFormat;
    }

    public Class<? extends OutputFormat> getOutputFormat() {
        return outputFormat;
    }

    public Class<?> getCurrentClass() {
        return currentClass;
    }

    public Class<?> getOutputKeyClass() {
        return outputKeyClass;
    }

    public Class<?> getOutputValueClass() {
        return outputValueClass;
    }

    public String getJobName() { return jobName;  }

    public String getPathToJar() { return pathToJar; }

}

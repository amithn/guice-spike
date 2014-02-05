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
    Class<? extends Mapper> mapperClass;
    Class<? extends Reducer> reducerClass;
    Class<? extends InputFormat> inputFormat;

    protected MapReduceConf(Class<? extends Mapper> mapperClass, Class<? extends Reducer> reducerClass,
                         Class<? extends InputFormat> inputFormat, Class<? extends OutputFormat> outputFormat,
                         Class<?> outputKeyClass, Class<?> outputValueClass, Class<?> currentClass,
                         String inputDir, String outputDir, String jobName) {
        this.mapperClass = mapperClass;
        this.reducerClass = reducerClass;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.outputKeyClass = outputKeyClass;
        this.outputValueClass = outputValueClass;
        this.currentClass = currentClass;
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.jobName = jobName;
    }

    Class<? extends OutputFormat> outputFormat;

    Class<?> outputKeyClass;
    Class<?> outputValueClass;

    Class<?> currentClass;

    String inputDir;
    String outputDir;
    private String jobName;

    public String getInputDir() {
        return inputDir;
    }

    public void setInputDir(String inputDir) {
        this.inputDir = inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }


    public void setMapperClass(Class<? extends Mapper> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public void setReducerClass(Class<? extends Reducer> reducerClass) {
        this.reducerClass = reducerClass;
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

    public void setInputFormat(Class<? extends InputFormat> inputFormat) {
        this.inputFormat = inputFormat;
    }

    public Class<? extends OutputFormat> getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(Class<? extends OutputFormat> outputFormat) {
        this.outputFormat = outputFormat;
    }

    public Class<?> getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(Class<?> currentClass) {
        this.currentClass = currentClass;
    }

    public Class<?> getOutputKeyClass() {
        return outputKeyClass;
    }

    public void setOutputKeyClass(Class<?> outputKeyClass) {
        this.outputKeyClass = outputKeyClass;
    }

    public Class<?> getOutputValueClass() {
        return outputValueClass;
    }

    public void setOutputValueClass(Class<?> outputValueClass) {
        this.outputValueClass = outputValueClass;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}

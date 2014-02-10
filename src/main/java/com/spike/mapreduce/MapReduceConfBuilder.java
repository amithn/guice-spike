package com.spike.mapreduce;

import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.Reducer;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/5/14
 */
public class MapReduceConfBuilder {
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
    private String pathToJar;

    public MapReduceConfBuilder withInputDir(String inputDir) {
        this.inputDir = inputDir;
        return this;
    }

    public MapReduceConfBuilder withOutputDir(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    public MapReduceConfBuilder withMapperClass(Class<? extends Mapper> mapperClass) {
        this.mapperClass = mapperClass;
        return this;
    }

    public MapReduceConfBuilder withReducerClass(Class<? extends Reducer> reducerClass) {
        this.reducerClass = reducerClass;
        return this;
    }

    public MapReduceConfBuilder withInputFormat(Class<? extends InputFormat> inputFormat) {
        this.inputFormat = inputFormat;
        return this;
    }

    public MapReduceConfBuilder withOutputFormat(Class<? extends OutputFormat> outputFormat) {
        this.outputFormat = outputFormat;
        return this;
    }

    public MapReduceConfBuilder withCurrentClass(Class<?> currentClass) {
        this.currentClass = currentClass;
        return this;
    }

    public MapReduceConfBuilder withOutputKeyClass(Class<?> outputKeyClass) {
        this.outputKeyClass = outputKeyClass;
        return this;
    }

    public MapReduceConfBuilder withOutputValueClass(Class<?> outputValueClass) {
        this.outputValueClass = outputValueClass;
        return this;
    }

    public MapReduceConfBuilder withJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public MapReduceConfBuilder withJar(String pathToJar) {
        this.pathToJar = pathToJar;
        return this;
    }

    public MapReduceConf build() {
        return new MapReduceConf(mapperClass, reducerClass, inputFormat, outputFormat,
                                outputKeyClass, outputValueClass, currentClass,
                                inputDir, outputDir, pathToJar, jobName);
    }
}

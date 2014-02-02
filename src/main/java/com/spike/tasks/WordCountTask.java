package com.spike.tasks;

import com.google.inject.Inject;
import com.spike.service.HDFSService;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordCountTask implements Task {

    HDFSService hdfsService;

    @Inject
    public WordCountTask(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void execute() {
        System.out.println("Executing Word Count Task with hdfs service " + hdfsService.getClass());
    }

    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            FileSplit fileSplit = (FileSplit) reporter.getInputSplit();
            String filename = fileSplit.getPath().getName();

            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                output.collect(word, one);
            }
        }
    }

    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            int sum = 0;
            System.out.print("Got the following values for key " + key.toString() + ":");
            while (values.hasNext()) {
                int value = values.next().get();
                System.out.print(value + ",");
                sum = sum + value;
            }
            output.collect(key, new IntWritable(sum));
        }
    }
}
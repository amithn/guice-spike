package com.spike.mapreduce;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/5/14
 */
public class CustomerReducer extends MapReduceBase implements Reducer<Text, FloatWritable, Text, FloatWritable> {

    @Override
    public void reduce(Text name, Iterator<FloatWritable> values, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
        float total = 0;
        while (values.hasNext()) {
            total  = total + values.next().get();
        }
        output.collect(name, new FloatWritable(total));
    }
}

package com.spike.mapreduce;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/5/14
 */
public class CustomerMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, FloatWritable> {

    @Override
    public void map(LongWritable lineNumber, Text line, OutputCollector<Text, FloatWritable> output, Reporter reporter) throws IOException {
        String lineStr = line.toString();
        String strippedStr = lineStr.replaceAll("\\s", "");
        StringTokenizer tokenizer = new StringTokenizer(strippedStr, ",");

        String customerId = tokenizer.nextToken();
        String customerName = tokenizer.nextToken();
        String amount = tokenizer.nextToken();
        output.collect(new Text(customerName), new FloatWritable(Float.valueOf(amount)));
    }
}

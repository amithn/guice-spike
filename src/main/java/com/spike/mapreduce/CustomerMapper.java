package com.spike.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/5/14
 */
public class CustomerMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable lineNumber, Text line, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        String lineStr = line.toString();
        String strippedStr = lineStr.replaceAll("\\s", "");
        StringTokenizer tokenizer = new StringTokenizer(strippedStr, ",");

        String customerId = tokenizer.nextToken();
        String customerName = tokenizer.nextToken();
        String amount = tokenizer.nextToken();

        output.collect(new Text(customerName), new IntWritable(Integer.valueOf(amount)));
    }
}

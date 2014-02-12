package com.spike.mapreduce;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
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
public class AggregateCustomerReducer extends MapReduceBase implements Reducer<Text, FloatWritable, Text, NullWritable> {

    @Override
    public void reduce(Text id, Iterator<FloatWritable> values, OutputCollector<Text, NullWritable> output, Reporter reporter) throws IOException {
        float total = 0;
        while (values.hasNext()) {
            total  = total + values.next().get();
        }
        String strId = id.toString();
        String strTotal = String.valueOf(total);
        output.collect(new Text(strId.concat(",").concat(strTotal)), NullWritable.get());
    }
}

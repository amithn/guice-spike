package com.spike.app;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by cloudera on 2/5/14.
 */
public class ConfigTest {

    public static void main(String[] args) throws IOException {
        Configuration config = new Configuration();
        config.addResource(new Path("/etc/hadoop/conf.cloudera.hdfs1/core-site.xml"));
        config.addResource(new Path("/etc/hadoop/conf.cloudera.hdfs1/hdfs-site.xml"));
        Writer writer = new StringWriter(100000);
        config.dumpConfiguration(config, writer);
        System.out.println("Config is " + writer.toString());
    }
}

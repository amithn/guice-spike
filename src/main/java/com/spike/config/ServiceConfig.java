package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.mongodb.MongoClient;
import com.spike.service.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import javax.inject.Named;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;


public class ServiceConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(String.class).annotatedWith(Names.named("HDFSURI")).toInstance("hdfs://localhost.localdomain:8020");
        binder.bind(String.class).annotatedWith(Names.named("MONGOHOST")).toInstance("localhost");

        binder.bind(HDFSService.class).to(RealHDFSServiceImpl.class);
        binder.bind(HDFSService.class).annotatedWith(FakeHDFS.class).to(FakeHDFSServiceImpl.class);
        binder.bind(HiveConnection.class).toInstance(HiveConnectionFactory.createNew());
        binder.bind(HiveService.class).to(HiveServiceJDBCImpl.class);
    }

    @Provides
    public Configuration configuration() {
        Configuration config = new Configuration();
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/core-site.xml"));
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/hdfs-site.xml"));
        config.addResource(new Path("/etc/hadoop/conf.cloudera.mapreduce1/mapred-site.xml"));
        return config;
    }

    @Provides
    @Singleton
    public FileSystem fileSystem(Configuration conf, @Named("HDFSURI") String hdfsURI) {
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI(hdfsURI), conf);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return fs;
    }

    @Provides
    @Singleton
    public MongoClient mongoClient(@Named("MONGOHOST") String mongoHost) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(mongoHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongoClient;
    }
}

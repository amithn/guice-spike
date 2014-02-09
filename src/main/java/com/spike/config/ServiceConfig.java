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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;


public class ServiceConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(HDFSService.class).to(HDFSServiceImpl.class);
        binder.bind(JobService.class).to(JobServiceImpl.class);
        binder.bind(String.class)
                .annotatedWith(Names.named("HDFSURI"))
                .toInstance("hdfs://localhost.localdomain:8020");
        binder.bind(HiveConnection.class).toInstance(HiveConnectionFactory.createNew());
        binder.bind(HiveService.class).to(HiveServiceJDBCImpl.class);
    }

    @Provides
    @Singleton
    public Configuration configuration() {
        return new Configuration();
    }

    @Provides
    @Singleton
    public FileSystem fileSystem(Configuration conf) {
        FileSystem fs = null;
        try {
            fs = FileSystem.get(new URI("hdfs://localhost.localdomain:8020/"), conf);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return fs;
    }

    @Provides
    @Singleton
    public MongoClient mongoClient() {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongoClient;
    }


//
//	@Provides
//    @Singleton
//	public HDFSServiceImpl hdfsService() {
//		return new HDFSServiceImpl(fileSystem(configuration()));
//	}

}

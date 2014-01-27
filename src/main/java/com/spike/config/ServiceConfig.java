package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.spike.service.HDFSService;
import com.spike.service.JobService;
import com.spike.service.RealHDFSService;
import com.spike.service.RealJobServiceImpl;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class ServiceConfig implements Module {

    @Override
	public void configure(Binder binder) {
        binder.bind(HDFSService.class).to(RealHDFSService.class);
        binder.bind(JobService.class).to(RealJobServiceImpl.class);
        binder.bind(String.class)
                .annotatedWith(Names.named("HDFSURI"))
                .toInstance("hdfs://localhost.localdomain:8020");
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
               fs = FileSystem.get(new URI("hdfs://localhost.localdomain:8020"), conf);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (URISyntaxException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return fs;
    }

	@Provides
    @Singleton
	public RealHDFSService hdfsService() {
		return new RealHDFSService(fileSystem(configuration()));
	}

}

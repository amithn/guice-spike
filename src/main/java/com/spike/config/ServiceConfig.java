package com.spike.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.spike.service.HiveConnection;
import com.spike.service.HiveConnectionFactory;
import com.spike.service.HiveService;
import com.spike.service.HiveServiceJDBCImpl;


public class ServiceConfig implements Module {

    @Override
    public void configure(Binder binder) {
//        binder.bind(HDFSService.class).to(RealHDFSService.class);
//        binder.bind(JobService.class).to(RealJobServiceImpl.class);
        binder.bind(String.class)
                .annotatedWith(Names.named("HDFSURI"))
                .toInstance("hdfs://localhost.localdomain:8020");
        binder.bind(HiveConnection.class).toInstance(HiveConnectionFactory.createNew());
        binder.bind(HiveService.class).to(HiveServiceJDBCImpl.class);
    }

//    @Provides
//    @Singleton
//    public Configuration configuration() {
//        return new Configuration();
//    }
//
//    @Provides
//    @Singleton
//    public FileSystem fileSystem(Configuration conf) {
//        FileSystem fs = null;
//        try {
//               fs = FileSystem.get(new URI("file://"), conf);
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        } catch (URISyntaxException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        return fs;
//    }
//
//	@Provides
//    @Singleton
//	public RealHDFSService hdfsService() {
//		return new RealHDFSService(fileSystem(configuration()));
//	}

}

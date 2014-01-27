package com.spike.service;


import com.google.inject.Inject;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class RealHDFSService implements HDFSService {
    FileSystem fileSystem;

    @Inject
    public RealHDFSService(FileSystem fileSystem) {
          this.fileSystem = fileSystem;
          System.out.println("Home is " + fileSystem.getScheme());
    }

    @Override
    public void copyFileToHDFS(String source, String destination) {
        try {
            fileSystem.copyFromLocalFile(new Path(source), new Path(destination));
            //fileSystem.copyToLocalFile(new Path("dep.txt"), new Path("/home/amith/hivedata"));
        } catch (IOException e) {
            System.out.println("Exception is " + e.getMessage());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}

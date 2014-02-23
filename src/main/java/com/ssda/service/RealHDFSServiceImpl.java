package com.ssda.service;


import com.google.inject.Inject;
import com.ssda.logger.Timed;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class RealHDFSServiceImpl implements HDFSService {
    FileSystem fileSystem;

    @Inject
    public RealHDFSServiceImpl(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    @Timed
    public void copyFileToHDFS(String source, String destination) {
        try {
            fileSystem.copyFromLocalFile(new Path(source), new Path(destination));
            //fileSystem.copyToLocalFile(new Path("dep.txt"), new Path("/home/amith/hivedata"));
        } catch (IOException e) {
            System.out.println("Exception is " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void removeFile(String filePath) {
        try {
            fileSystem.delete(new Path(filePath), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Timed
    public void removeDirectory(String dirPath) {
        try {
            fileSystem.delete(new Path(dirPath), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

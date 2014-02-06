package com.spike.service;


import com.google.inject.Inject;
import com.spike.logger.Log;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class HDFSServiceImpl implements HDFSService {
    FileSystem fileSystem;

    @Inject
    public HDFSServiceImpl(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    @Log
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
    @Log
    public void removeDirectory(String dirPath) {
        try {
            fileSystem.delete(new Path(dirPath), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

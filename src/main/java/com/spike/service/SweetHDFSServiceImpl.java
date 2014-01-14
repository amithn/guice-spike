package com.spike.service;


import java.io.File;

public class SweetHDFSServiceImpl implements HDFSService {

    @Override
    public File getFile() {
        System.out.println("Called getFile() in " + this.getClass().getSimpleName());
        return new File("~/.bashrc");
    }

    @Override
    public int getFileSize() {
        System.out.println("Called getFileSize() in " + this.getClass().getSimpleName());
        return 1;
    }
}

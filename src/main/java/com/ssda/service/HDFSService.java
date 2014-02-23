package com.ssda.service;


public interface HDFSService {

    void copyFileToHDFS(String source, String destination);
    void removeFile(String filePath);
    void removeDirectory(String dirPath);

}

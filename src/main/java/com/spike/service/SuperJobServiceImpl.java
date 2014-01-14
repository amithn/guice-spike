package com.spike.service;


public class SuperJobServiceImpl implements JobService {
    HDFSService hdfsService;

    public SuperJobServiceImpl(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void run() {
       System.out.println("Get info called on " + this.getClass().getSimpleName());
    }
}

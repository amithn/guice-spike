package com.spike.service;


import com.google.inject.Inject;

public class RealJobServiceImpl implements JobService {
    HDFSService hdfsService;

    @Inject
    public RealJobServiceImpl(HDFSService hdfsService) {
        this.hdfsService = hdfsService;
    }

    @Override
    public void run() {
        System.out.println("Get info called on " + this.getClass().getSimpleName());
    }
}

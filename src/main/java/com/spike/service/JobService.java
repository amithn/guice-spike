package com.spike.service;


import com.spike.mapreduce.MapReduceConf;

public interface JobService {
    void run(MapReduceConf conf);
}

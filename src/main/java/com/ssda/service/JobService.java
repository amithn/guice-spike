package com.ssda.service;


import com.ssda.mapreduce.MapReduceConf;

public interface JobService {
    void run(MapReduceConf conf);
}

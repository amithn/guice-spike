package com.spike.tasks;


import com.spike.logger.Log;

public interface Task {

    @Log
    void execute();
}

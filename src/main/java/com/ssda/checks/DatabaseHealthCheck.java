package com.ssda.checks;

import com.yammer.metrics.core.HealthCheck;

public class DatabaseHealthCheck extends HealthCheck {

    public DatabaseHealthCheck() {
        super("database");
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
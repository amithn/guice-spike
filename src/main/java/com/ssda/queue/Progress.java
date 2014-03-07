package com.ssda.queue;

public enum Progress {
    QUEUED,
    ONGOING,
    DONE,
    FAILED,
    UNKNOWN;

    @Override
    public String toString() {
        return this.name().toString();
    }
}

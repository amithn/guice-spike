package com.spike.util;


public class ConsoleArguments implements Arguments {
    String[] args;

    public ConsoleArguments(String[] args) {
        this.args = args;
    }

    public String[] get() {
        return args;
    }
}

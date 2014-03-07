package com.ssda.queue;

import com.google.inject.Inject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageReader<T extends SSDAEvent> implements Runnable {

    private final Queue<T> queue;
    private final ExecutorService service;

    @Inject
    public MessageReader(Queue<T> queue) {
        this.queue = queue;
        this.service = Executors.newFixedThreadPool(1);
    }

    @Override
    public void run() {
        while(true) {
            T event = queue.dequeue();
            System.out.println("Event is " + event.getId());
            service.execute(new SSDATask(event.getId()));
        }
    }
}

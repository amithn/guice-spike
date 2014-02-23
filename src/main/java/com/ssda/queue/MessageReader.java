package com.ssda.queue;

import com.google.inject.Inject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageReader implements Runnable {

    private final Queue queue;
    private final ExecutorService service;

    @Inject
    public MessageReader(Queue queue) {
        this.queue = queue;
        this.service = Executors.newFixedThreadPool(2);
    }

    @Override
    public void run() {
        while(true) {
            SSDAEvent ssdaEvent = queue.dequeue();
            System.out.println("Event is " + ssdaEvent.getId());
            service.execute(new SSDATask(ssdaEvent.getId()));
        }
    }
}

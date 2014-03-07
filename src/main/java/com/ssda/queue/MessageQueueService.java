package com.ssda.queue;

import com.google.inject.Inject;

public class MessageQueueService<T> {

    private final Queue<T> incomingQ;

    @Inject
    public MessageQueueService(Queue<T> incomingQ) {
        this.incomingQ = incomingQ;
    }

    T dequeue() {
        return incomingQ.dequeue();
    }

    void enqueue(T event) {
         incomingQ.enqueue(event);
    }
}

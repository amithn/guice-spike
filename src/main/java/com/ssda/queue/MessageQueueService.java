package com.ssda.queue;

import com.google.inject.Inject;

public class MessageQueueService {

    private final Queue incomingQ;
    private final Queue outgoingQ;

    @Inject
    public MessageQueueService(Queue incomingQ, Queue outgoingQ) {
        this.incomingQ = incomingQ;
        this.outgoingQ = outgoingQ;
    }

    SSDAEvent dequeueIncoming() {
        return incomingQ.dequeue();
    }

    SSDAEvent dequeueOutgoing() {
        return outgoingQ.dequeue();
    }

    void enqueueIncoming(SSDAEvent event) {
         incomingQ.enqueue(event);
    }

    void enqueueOutgoing(SSDAEvent event) {
        outgoingQ.enqueue(event);
    }
}

package com.ssda.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.ssda.queue.InMemoryQueue;
import com.ssda.queue.MessageQueueService;
import com.ssda.queue.Queue;
import com.ssda.queue.SSDAEvent;

public class QueueConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(Queue.class).toInstance(new InMemoryQueue<SSDAEvent>());
    }

    @Provides
    public MessageQueueService queueService(Queue queue) {
        return new MessageQueueService<SSDAEvent>(queue);
    }
}

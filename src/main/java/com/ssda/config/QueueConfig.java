package com.ssda.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.ssda.queue.InMemoryQueue;
import com.ssda.queue.MessageQueueService;
import com.ssda.queue.Queue;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/23/14
 */
public class QueueConfig implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(Queue.class).to(InMemoryQueue.class);
    }

    @Provides
    public MessageQueueService queueService(Queue queue) {
        return new MessageQueueService(queue, queue);
    }
}

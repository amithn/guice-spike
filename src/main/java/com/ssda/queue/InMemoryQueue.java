package com.ssda.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/22/14
 */
public class InMemoryQueue implements Queue {
    private LinkedBlockingQueue<SSDAEvent> queue = new LinkedBlockingQueue<SSDAEvent>();

    public void enqueue(SSDAEvent event) {
        queue.offer(event);
    }

    public SSDAEvent dequeue() {
        try {
            System.out.println("Current number of pending events is " + queue.size());
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

}

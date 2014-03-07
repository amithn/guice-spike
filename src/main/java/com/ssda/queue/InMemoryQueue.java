package com.ssda.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class InMemoryQueue<T> implements Queue<T> {
    private LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<T>();

    @Override
    public void enqueue(T event) {
        queue.offer(event);
    }

    public T dequeue() {
        try {
            System.out.println("Current number of pending events is " + queue.size());
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

}

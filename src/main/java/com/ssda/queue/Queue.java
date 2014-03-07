package com.ssda.queue;


public interface Queue<T> {
    void enqueue(T event);
    T dequeue();
}

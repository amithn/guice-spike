package com.ssda.queue;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/23/14
 */
public interface Queue {
    void enqueue(SSDAEvent event);
    SSDAEvent dequeue();
}

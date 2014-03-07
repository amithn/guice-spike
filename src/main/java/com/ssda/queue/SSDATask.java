package com.ssda.queue;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/22/14
 */
public class SSDATask implements Runnable {

    private final String id;

    public SSDATask(String id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Started Executing task with id " + id);
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Finished - Executing task with id " + id);
    }
}


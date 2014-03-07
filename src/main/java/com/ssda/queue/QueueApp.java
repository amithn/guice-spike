package com.ssda.queue;


import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueApp {

    public static void main(String[] args) throws InterruptedException {
        Queue<SSDAEvent> incomingQ = new InMemoryQueue<SSDAEvent>();
        MessageQueueService<SSDAEvent> queueService = new MessageQueueService<SSDAEvent>(incomingQ);

        ExecutorService messageReadingService = Executors.newSingleThreadExecutor();
        MessageReader<SSDAEvent> messageReader = new MessageReader<SSDAEvent>(incomingQ);
        messageReadingService.execute(messageReader);

        while(true) {
            queueService.enqueue(createSSDAEvent());
            Thread.sleep(1000 * 100);
            System.out.println("Waiting done ");
        }
    }

    private static SSDAEvent createSSDAEvent() {
        SSDAEvent event = new SSDAEvent(UUID.randomUUID().toString());
        return event;
    }
}

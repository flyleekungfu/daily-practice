package com.saltfish.dailypractice.concurrent.delayqueue;

import java.util.concurrent.DelayQueue;

public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueue<DelayData> queue = new DelayQueue<>();
        queue.add(new DelayData());
        while (true) {
            try {
                DelayData data = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

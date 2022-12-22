package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer customer = null;
        for (int i = 0; i < queue.size(); i++) {
            customer = queue.poll();
        }
        return customer.name();
    }

    public String getLastUpsetCustomer() {
        for (int i = 0; i < queue.size(); i++) {
            queue.poll();
        }
        return queue.poll().name();
    }
}
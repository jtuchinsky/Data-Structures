package com.wellsfargo.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    T[] store;
    int capacity;
    int size = 0;
    int head = 0;
    int tail = 0;
    Lock lock = new ReentrantLock();
    Condition isEmpty = lock.newCondition();
    Condition isFull = lock.newCondition();

    public BlockingQueue(int capacity) {
        store = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueL(T item) throws InterruptedException{
        try {
            lock.lock();
            while(size == capacity)
                isFull.await();

            if(tail == capacity)
                tail = 0;

            store[tail] = item;
            size++;
            tail++;

            isEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void enque(T item) throws InterruptedException{
        while(size == capacity) {
            wait();
        }

        if(tail == capacity)
            tail = 0;

        store[tail] = item;
        size++;
        tail++;

        notifyAll();
    }

    public T dequeL() throws InterruptedException{
        T item = null;

        lock.lock();
        while(size == 0)
            isEmpty.await();

        if(head == capacity)
            head = 0;
        item = store[head];
        store[head] = null;
        head++;

        isFull.signalAll();
        lock.unlock();

        return item;
    }

    public synchronized T deque() throws InterruptedException{
        T item = null;

        while(size == 0)
            wait();

        if(head == capacity)
            head = 0;
        item = store[head];
        store[head] = null;
        head++;

        notifyAll();

        return item;
    }
}

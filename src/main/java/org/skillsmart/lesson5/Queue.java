package org.skillsmart.lesson5;

import java.util.LinkedList;

public class Queue<T> extends AbstractQueue<T> {

    private LinkedList<T> queue;
    private int dequeueStatus;
    private int peekStatus;

    public Queue() {
        clear();
    }

    @Override
    public void enqueue(T item) {
        queue.add(item);
    }

    @Override
    public void dequeue() {
        if (queue.size() > 0) {
            queue.removeFirst();
            dequeueStatus = DEQUEUE_OK;
        } else {
            dequeueStatus = DEQUEUE_ERR;
        }
    }

    @Override
    public void clear() {
        queue = new LinkedList<>();
    }

    @Override
    public T peek() {
        if (queue.size() > 0) {
            peekStatus = PEEK_OK;
            return queue.getFirst();
        } else {
            peekStatus = PEEK_ERR;
            return null;
        }
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public int getDequeueStatus() {
        return this.dequeueStatus;
    }

    @Override
    public int getPeekStatus() {
        return this.peekStatus;
    }
}

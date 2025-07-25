package org.skillsmart.lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<Integer> qu = new Queue();
        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        assertEquals(3, qu.size());
    }

    void dequeue() {
        Queue qu = new Queue();
        qu.enqueue(1);
        qu.enqueue("test");
        qu.enqueue(3);
        assertEquals(1, qu.peek());
        qu.dequeue();
        assertEquals(2, qu.getDequeueStatus());
        assertEquals(2, qu.getPeekStatus());
        assertEquals(2, qu.size());
        assertEquals("test", qu.peek());
        qu.dequeue();
        assertEquals(2, qu.getDequeueStatus());
        assertEquals(2, qu.getPeekStatus());
        assertEquals(1, qu.size());
        assertEquals(3, qu.peek());
        qu.dequeue();
        assertEquals(0, qu.size());
        qu.dequeue();
        qu.peek();
        assertEquals(1, qu.getDequeueStatus());
        assertEquals(1, qu.getPeekStatus());
    }
}
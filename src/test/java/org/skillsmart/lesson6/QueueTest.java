package org.skillsmart.lesson6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<Integer> qu = new Queue<>();
        qu.addTail(1);
        qu.addTail(2);
        qu.addTail(3);
        assertEquals(3, qu.size());
    }

    @Test
    void dequeue() {
        Queue qu = new Queue();
        qu.addTail(1);
        qu.addTail("test");
        qu.addTail(3);
        assertEquals(1, qu.getFront());
        qu.removeFront();
        assertEquals(2, qu.getRemoveFrontStatus());
        assertEquals(2, qu.getGetFrontStatus());
        assertEquals(2, qu.size());
        assertEquals("test", qu.getFront());
        qu.removeFront();
        assertEquals(2, qu.getRemoveFrontStatus());
        assertEquals(2, qu.getGetFrontStatus());
        assertEquals(1, qu.size());
        assertEquals(3, qu.getFront());
        qu.removeFront();
        assertEquals(0, qu.size());
        qu.removeFront();
        qu.getFront();
        assertEquals(1, qu.getRemoveFrontStatus());
        assertEquals(1, qu.getGetFrontStatus());
    }
}
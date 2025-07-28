package org.skillsmart.lesson6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void testAddFront() {
        Deque deque = new Deque<>();
        deque.addFront(3);
        assertEquals(1, deque.size());
        assertEquals(3, deque.getFront());
        deque.addFront("two");
        assertEquals(2, deque.size());
        assertEquals("two", deque.getFront());
        deque.addFront(1);
        assertEquals(3, deque.size());
        assertEquals(1, deque.getFront());

        deque.removeFront();
        assertEquals("two", deque.getFront());
        deque.removeFront();
        assertEquals(3, deque.getFront());
        assertEquals(1, deque.size());
    }

    @Test
    void testAddTail() {
        Deque deque = new Deque<>();
        deque.addTail(1);
        assertEquals(1, deque.size());
        assertEquals(1, deque.getTail());
        deque.addTail("two");
        assertEquals(2, deque.size());
        assertEquals("two", deque.getTail());
        deque.addTail(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getTail());
        
        deque.removeTail();
        assertEquals("two", deque.getTail());
        deque.removeTail();
        assertEquals(1, deque.getTail());
        assertEquals(1, deque.size());
    }

    @Test
    void testRemoveFront() {
        Deque deque = new Deque<>();
        deque.addFront(1);
        deque.addFront("two");
        deque.addFront(3);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getFront());
        deque.removeFront();
        assertEquals(2, deque.getRemoveFrontStatus());
        assertEquals(2, deque.size());
        assertEquals("two", deque.getFront());
        deque.removeFront();
        assertEquals(2, deque.getRemoveFrontStatus());
        assertEquals(1, deque.size());
        assertEquals(1, deque.getFront());
        deque.removeFront();
        assertEquals(2, deque.getRemoveFrontStatus());
        assertEquals(0, deque.size());
        deque.removeFront();
        assertEquals(1, deque.getRemoveFrontStatus());
        assertEquals(0, deque.size());
    }

    @Test
    void testRemoveTail() {
        Deque deque = new Deque<>();
        deque.addFront(3);
        deque.addFront("two");
        deque.addFront(1);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getTail());
        deque.removeTail();
        assertEquals(2, deque.getRemoveTailStatus());
        assertEquals(2, deque.size());
        assertEquals("two", deque.getTail());
        deque.removeTail();
        assertEquals(2, deque.getRemoveTailStatus());
        assertEquals(1, deque.size());
        assertEquals(1, deque.getTail());
        deque.removeTail();
        assertEquals(2, deque.getRemoveTailStatus());
        assertEquals(0, deque.size());
        deque.removeTail();
        assertEquals(1, deque.getRemoveTailStatus());
        assertEquals(0, deque.size());
    }

    @Test
    void testMixFrontTail() {
        Deque deq = new Deque();
        deq.addFront("f1");
        deq.addTail("t1");
        deq.addFront("f2");
        deq.addTail("t2");
        assertEquals("f2", deq.getFront());
        deq.removeFront();
        assertEquals("t2", deq.getTail());
        deq.removeTail();
        assertEquals("f1", deq.getFront());
        deq.removeFront();
        assertEquals("t1", deq.getTail());
        deq.removeTail();
    }

}
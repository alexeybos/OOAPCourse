package org.skillsmart.lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentLinkedListTest {

    @Test
    void find() {
        ParentLinkedList<Integer> list = new ParentLinkedList<>();
        list.addToEmpty(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(2);
        list.addTail(4);
        assertEquals(1, list.get());
        list.find(1);
        assertEquals(AbstractParentLinkedList.FIND_ERR, list.getFindResult());
        list.find(2);
        assertEquals(AbstractParentLinkedList.FIND_OK, list.getFindResult());
        list.find(2);
        assertEquals(AbstractParentLinkedList.FIND_OK, list.getFindResult());
    }
}
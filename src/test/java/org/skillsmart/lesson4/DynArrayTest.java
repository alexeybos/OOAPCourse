package org.skillsmart.lesson4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DynArrayTest {

    @Test
    void testGetItem() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        assertEquals(1, array.get(0));
        assertEquals(1, array.length());
        assertEquals(DynArray.GET_OK, array.getGetStatus());
    }

    @Test
    void testGetItem_SeveralValues() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        assertEquals(2, array.get(1));
        assertEquals(3, array.length());
    }

    @Test
    void testGetItem_InvalidIndex() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        assertNull(array.get(5));
        assertEquals(DynArray.GET_ERR, array.getGetStatus());
    }

    @Test
    void testAppend() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
    }
    @Test
    void testAppend_WithReallocation() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            array.append(i);
        }
        array.append(16);
        assertEquals(16, array.get(16));
    }

    @Test
    void testInsert_NoBufferResize() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(3);
        array.append(4);
        array.insert(2, 1);
        assertEquals(DynArray.INSERT_OK, array.getInsertStatus());
        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
        assertEquals(4, array.get(3));
    }

    @Test
    void testInsert_BufferResize() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            array.append(i);
        }
        array.insert(16, 5);
        assertEquals(DynArray.INSERT_OK, array.getInsertStatus());
        assertEquals(16, array.get(5));
        assertEquals(15, array.get(16));
    }

    @Test
    void testInsert_InvalidIndex() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(3);
        array.append(4);
        array.insert(2, 5);
        assertEquals(DynArray.INSERT_ERR, array.getInsertStatus());
    }

    @Test
    void testRemove_NoBufferResize() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.remove(1);
        assertEquals(DynArray.REMOVE_OK, array.getRemoveStatus());
        assertEquals(1, array.get(0));
        assertEquals(3, array.get(1));
    }

    @Test
    void testRemove_InvalidIndex() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.append(2);
        array.append(3);
        array.remove(5);
        assertEquals(DynArray.REMOVE_ERR, array.getRemoveStatus());
    }
}
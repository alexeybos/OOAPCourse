package org.skillsmart.lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void put() {
        HashTable<String> tab = new HashTable<>(String.class, 17);
        tab.put("10");
        tab.put("5");
        assertEquals(2, tab.size());
        tab.put("01");
        tab.put("hash");
        assertEquals(2, tab.getPutStatus());
        for (int i = 0; i < 14; i++) {
            tab.put("hash" + i);
        }
        assertEquals(17, tab.size());
        tab.put("123");
        assertEquals(1, tab.getPutStatus());
    }

    @Test
    void find() {
        HashTable<String> table = new HashTable<>(String.class, 17);
        table.put("10");
        table.put("5");
        table.put("01");
        table.put("hash");
        assertEquals(12, table.find("10"));
        assertEquals(15, table.find("01"));
        assertEquals(1, table.find("hash"));
        assertEquals(2, table.find("5"));
        assertEquals(-1, table.find("123"));
    }

    @Test
    void remove() {
        HashTable<String> table = new HashTable<>(String.class, 17);
        table.put("10");
        table.put("5");
        table.put("01");
        table.put("hash");
        assertEquals(4, table.size());
        table.remove(table.find("5"));
        assertEquals(3, table.size());
        table.remove(129);
        assertEquals(3, table.size());
        table.remove(8);
        assertEquals(3, table.size());
    }
}
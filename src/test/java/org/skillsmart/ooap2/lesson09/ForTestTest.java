package org.skillsmart.ooap2.lesson09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForTestTest {

    @Test
    void simpleTest() {
        ForTest instance = new ForTest();
        Any anyInstance = new Any();
        //assertTrue(instance.instanceOf(instance, ForTest.class));
        //assertFalse(instance.instanceOf(instance, String.class));
        assertFalse(anyInstance.instanceOf(General.class));
        assertTrue(instance.instanceOf(ForTest.class));
        assertFalse(instance.instanceOf(String.class));
        Class<?> clz = instance.getType();
        System.out.println(clz);
        ForTest instance2 = new ForTest();
        assertEquals("Class for hierarchy test", instance2.getName());
        instance.setName("new");
        instance.copy(instance2);
        assertEquals("new", instance2.getName());
        instance2 = new ForTest();
        instance.deepCopy(instance2);
        assertEquals("new", instance2.getName());
        ForTest instance3 = (ForTest) instance2.clone();
        assertEquals("new", instance3.getName());
    }

}
package org.skillsmart.ooap2.lesson14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void testAddVectors() {
        Vector<FirstCl> vector1 = new Vector<>();
        vector1.put(new FirstCl(1));
        vector1.put(new FirstCl(2));
        vector1.put(new FirstCl(3));
        Vector<FirstCl> vector2 = new Vector<>();
        vector2.put(new FirstCl(4));
        vector2.put(new FirstCl(5));
        vector2.put(new FirstCl(6));
        Vector<FirstCl> res1 = vector1.addVectors(vector2);
        List<FirstCl> arr1 = res1.getArray();
        assertEquals(5, arr1.get(0).getValue());
        assertEquals(7, arr1.get(1).getValue());
        assertEquals(9, arr1.get(2).getValue());
        Vector<Vector<FirstCl>> vectorExt1 = new Vector<>();
        vectorExt1.put(vector1);
        vectorExt1.put(vector2);

        Vector<FirstCl> vector3 = new Vector<>();
        vector3.put(new FirstCl(7));
        vector3.put(new FirstCl(8));
        vector3.put(new FirstCl(9));
        Vector<FirstCl> vector4 = new Vector<>();
        vector4.put(new FirstCl(10));
        vector4.put(new FirstCl(11));
        vector4.put(new FirstCl(12));
        Vector<Vector<FirstCl>> vectorExt2 = new Vector<>();
        vectorExt2.put(vector3);
        vectorExt2.put(vector4);
        Vector<Vector<FirstCl>> res2 = vectorExt1.addVectors(vectorExt2);
        List<Vector<FirstCl>> arr2 = res2.getArray();
        List<FirstCl> innerArr1 = arr2.getFirst().getArray();
        List<FirstCl> innerArr2 = arr2.getLast().getArray();
        //assertEquals(5, innerArr1.get(0).getValue());
        //assertEquals(5, innerArr1.get(1).getValue());
        //assertEquals(5, innerArr1.get(2).getValue());
    }

}
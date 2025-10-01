package org.skillsmart.ooap2.lesson12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnyTest {

    @Test
    void simpleTest() {
        General gen = new General();
        Any any = new Any();
        //Any.assignmentAttempt(any, gen);
        //General.assignmentAttempt(gen, "String");
        General gen2 = General.assignmentAttempt(gen, "String");
        System.out.println("end");
        System.out.println("yes");

    }

}
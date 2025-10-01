package org.skillsmart.ooap2.lesson12;

import java.io.Serializable;

public class Example12 {

    /*public*/ class General implements Serializable {

        public static final int ASSIGNMENT_NO = 1; // присваивание невозможно
        public static final int ASSIGNMENT_OK = 2; // присваивание возможно
        protected int assignmentStatus;

        // либо со статусами
        public <T> General assignmentAttemptWithStatus(General target, T source) {
            if (target.getClass().isAssignableFrom(source.getClass())) {
                assignmentStatus = ASSIGNMENT_OK;
                return (General) source;
            }
            assignmentStatus = ASSIGNMENT_NO;
            return new None();
        }

        // либо без статусов
        public static <T> General assignmentAttempt(General target, T source) {
            if (target.getClass().isAssignableFrom(source.getClass())) {
                return (General) source;
            }
            return new None();
        }

        public int getAssignmentStatus() {
            return assignmentStatus;
        }
    }

    /*public*/ class Any extends General {
        //private final None Void = new None();

        public <T> Any assignmentAttempt(Any target, T source) {
            if (target.getClass().isAssignableFrom(source.getClass())) {
                assignmentStatus = ASSIGNMENT_OK;
                return (Any) source;
            }
            assignmentStatus = ASSIGNMENT_NO;
            return new None();
        }

        //либо можно static без статусов (как для General)
    }

    /*public*/ final class None extends Any {
    }

}

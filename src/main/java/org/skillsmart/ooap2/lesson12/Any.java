package org.skillsmart.ooap2.lesson12;

public class Any extends General {
    //private final None Void = new None();

    public <T> Any assignmentAttempt(Any target, T source) {
        if (target.getClass().isAssignableFrom(source.getClass())) {
            assignmentStatus = ASSIGNMENT_OK;
            return  (Any) source;
        }
        assignmentStatus = ASSIGNMENT_NO;
        return new None();
    }

    //либо можно static без статусов (как для General)
}

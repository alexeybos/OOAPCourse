package org.skillsmart.ooap2.fortests;

public class Any extends General{

    public String mirrorA(Any cl) {
        if (cl instanceof None) return "";
        return "Any";
    }
}

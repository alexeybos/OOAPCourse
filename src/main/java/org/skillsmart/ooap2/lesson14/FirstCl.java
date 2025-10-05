package org.skillsmart.ooap2.lesson14;

public class FirstCl extends General {

    private int value;

    public FirstCl(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public <T> T add(T adding) {
        if (!(adding instanceof FirstCl term))
            throw new IllegalArgumentException("Not supported type");
        return (T) new FirstCl(value + term.value);
    }
}

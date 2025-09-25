package org.skillsmart.lesson9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PowerSet<T> extends AbstractSimplePowerSet<T> {

    private final Map<T, Object> innerSet;
    private int putStatus;
    private int removeStatus;

    public PowerSet() {
        this.innerSet = new HashMap<>();
    }

    @Override
    public void put(T value) {
        if (get(value)) {
            putStatus = PUT_EXISTS;
        } else {
            putStatus = PUT_OK;
            innerSet.put(value, 0);
        }
    }

    @Override
    public void remove(T value) {
        if (get(value)) {
            removeStatus = REMOVE_OK;
            innerSet.remove(value);
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public boolean get(T value) {
        return innerSet.containsKey(value);
    }

    @Override
    public int size() {
        return innerSet.size();
    }

    @Override
    public int getPutStatus() {
        return putStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }
}

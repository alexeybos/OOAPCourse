package org.skillsmart.lesson8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class NativeDictionary<T> extends AbstractNativeDictionary<T> {

    private static final int STEP = 3;
    private final int maxSize;
    private int putStatus;
    private int removeStatus;
    private int getStatus;
    private int size;
    private String [] slots;
    private T [] values;

    public NativeDictionary(Class<T> clz, int maxSize) {
        this.size = 0;
        this.maxSize = maxSize;
        slots = new String[size];
        values = (T[]) Array.newInstance(clz, this.size);
        Arrays.fill(values, null);
    }

    @Override
    public void put(String key, T value) {
        int slot = seekSlot(key);
        if (slot == -1) {
            putStatus = PUT_ERR;
        } else {
            putStatus = PUT_OK;
            slots[slot] = key;
            values[slot] = value;
            size += 1;
        }
    }

    @Override
    public void remove(String key) {
        int slot = seekSlot(key);
        if (slot == -1) {
            removeStatus = REMOVE_ERR;
        } else {
            removeStatus = REMOVE_OK;
            slots[slot] = null;
            values[slot] = null;
            size -= 1;
        }
    }

    @Override
    public T get(String key) {
        int slot = seekSlot(key);
        if (slot == -1) {
            getStatus = GET_ERR;
        } else {
            getStatus = GET_OK;
            return values[slot];
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int getPutStatus() {
        return putStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }

    private int hashFun(String key) {
        byte[] chars = key.getBytes();
        int sum = 0;
        for (byte aChar : chars) {
            sum += aChar;
        }
        return sum%maxSize;
    }

    private int seekSlot(String key) {
        int slot = hashFun(key);
        for (int i = 0; i <= STEP; i++) {
            for (; slot < maxSize; slot += STEP) {
                if (slots[slot] == null || Objects.equals(slots[slot], key)) return slot;
            }
            slot -= maxSize;
        }
        return -1;
    }

    private int findValue(T value) {
        for (int i = 0; i < maxSize; i++) {
            if (Objects.equals(values[i], value)) return i;
        }
        return -1;
    }
}

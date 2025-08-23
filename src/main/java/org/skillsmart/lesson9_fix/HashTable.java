package org.skillsmart.lesson9_fix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HashTable<T> extends AbstractHashTable<T> {

    private static final int STEP = 3;
    private final int maxSize;
    private final T[] slots;
    private Class<T> clazz;
    private int putStatus;
    private int removeStatus;
    private int size;

    public HashTable(Class<T> clz, int max_size) {
        this.clazz = clz;
        this.maxSize = max_size;
        this.slots = (T[]) java.lang.reflect.Array.newInstance(clazz, max_size);
        Arrays.fill(slots, null);
        this.size = 0;
    }

    @Override
    public void put(T value) {
        if (get(value)) {
            putStatus = PUT_OK;
            return;
        }
        int slot = seekSlot(value);
        if (slot != -1) {
            slots[slot] = value;
            size += 1;
            putStatus = PUT_OK;
        } else {
            putStatus = PUT_ERR;
        }
    }

    @Override
    public void remove(T value) {
        int slot = seekSlot(value);
        if (slot != -1) {
            slots[slot] = null;
            size -= 1;
            removeStatus = REMOVE_OK;
        } else {
            removeStatus = REMOVE_ERR;
        }
    }

    @Override
    public boolean get(T value) {
        int slot = hashFun(value);
        for (int i = 0; i <= STEP; i++) {
            for (; slot < maxSize; slot += STEP) {
                if (Objects.equals(slots[slot], value)) return true;
                if (slots[slot] == null) {
                    return false;
                }
            }
            slot -= maxSize;
        }
        return false;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public List<T> getValues() {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            if (slots[i] != null) {
                result.add(slots[i]);
            }
        }
        return result;
    }

    @Override
    public int getPutStatus() {
        return putStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    private int hashFun(T value) {
        String valForHash = value.toString();
        byte[] chars = valForHash.getBytes();
        int sum = 0;
        for (byte aChar : chars) {
            sum += aChar;
        }
        return sum%maxSize;
    }

    private int seekSlot(T value) {
        int slot = hashFun(value);
        for (int i = 0; i <= STEP; i++) {
            for (; slot < maxSize; slot += STEP) {
                if (slots[slot] == null || Objects.equals(slots[slot], value)) return slot;
            }
            slot -= maxSize;
        }
        return -1;
    }

    /*private int find(T value) {
        int slot = hashFun(value);
        for (int i = 0; i <= STEP; i++) {
            for (; slot < maxSize; slot += STEP) {
                if (Objects.equals(slots[slot], value)) return slot;
                if (slots[slot] == null) {
                    return -1;
                }
            }
            slot -= maxSize;
        }
        return -1;
    }*/
}

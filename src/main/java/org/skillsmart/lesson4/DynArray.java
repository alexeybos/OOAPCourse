package org.skillsmart.lesson4;

import java.lang.reflect.Array;

public class DynArray<T> extends AbstractDynArray<T> {

    private static final int INITIAL_CAPACITY = 16;
    private static final int APPEND_MULTIPLIER = 2;
    private Class<T> clazz;
    private T[] array;
    private int length;
    private int capacity;

    private int insertStatus;
    private int removeStatus;
    private int getStatus;



    public DynArray(Class<T> clz) {
        this.clazz = clz;
        this.capacity = INITIAL_CAPACITY;
        clear();
    }

    @Override
    public void append(T itm) {
        expandIfNeed();
        this.array[length] = itm;
        length += 1;
    }

    @Override
    public void insert(T itm, int index) {
        if (index < 0 || index > length - 1) {
            insertStatus = INSERT_ERR;
        } else {
            expandIfNeed();
            length += 1;
            insertStatus = INSERT_OK;
        }
        for (int i = length - 1; insertStatus == INSERT_OK && i > index; i--) {
            array[i] = array[i - 1];
        }
        if (insertStatus == INSERT_OK) {
            this.array[index] = itm;
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > length - 1) {
            removeStatus = REMOVE_ERR;
        } else {
            length -= 1;
            removeStatus = REMOVE_OK;
        }
        for (int i = index; removeStatus == REMOVE_OK && i > 0 && i < length; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public void clear() {
        this.array = (T[]) java.lang.reflect.Array.newInstance(clazz, capacity);
        this.length = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > length - 1) {
            getStatus = GET_ERR;
            return null;
        } else {
            getStatus = GET_OK;
            return array[index];
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int getInsertStatus() {
        return insertStatus;
    }

    @Override
    public int getRemoveStatus() {
        return removeStatus;
    }

    @Override
    public int getGetStatus() {
        return getStatus;
    }

    private void makeArray(int new_capacity) {
        T[] oldArray = array;
        array = (T[]) Array.newInstance(this.clazz, new_capacity);
        System.arraycopy(oldArray, 0, array, 0, length);
        capacity = new_capacity;
    }

    private void expandIfNeed() {
        if (length == capacity) {
            makeArray(capacity * APPEND_MULTIPLIER);
        }
    }
}

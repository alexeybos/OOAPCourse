package org.skillsmart.lesson6;

import java.util.LinkedList;

public class ParentQueue<T> extends AbstractParentQueue<T> {

    protected final LinkedList<T> queue;
    private int removeFrontStatus;
    private int getFrontStatus;

    public ParentQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public void addTail(T item) {
        queue.add(item);
    }

    @Override
    public void removeFront() {
        if (queue.size() > 0) {
            queue.removeFirst();
            removeFrontStatus = REMOVE_FRONT_OK;
        } else {
            removeFrontStatus = REMOVE_FRONT_ERR;
        }
    }

    @Override
    public T getFront() {
        if (queue.size() > 0) {
            getFrontStatus = GET_FRONT_OK;
            return queue.getFirst();
        } else {
            getFrontStatus = GET_FRONT_ERR;
            return null;
        }
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public int getRemoveFrontStatus() {
        return removeFrontStatus;
    }

    @Override
    public int getGetFrontStatus() {
        return getFrontStatus;
    }
}

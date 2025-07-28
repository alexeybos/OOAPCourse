package org.skillsmart.lesson6;

import java.util.LinkedList;

/**
 * Двусторонняя очередь. Отдельный класс.
 * @param <T>
 */
public class DequeFull<T> extends AbstractDequeFull<T> {

    private final LinkedList<T> queue;
    private int removeFrontStatus;
    private int removeTailStatus;
    private int getFrontStatus;
    private int getTailStatus;

    public DequeFull() {
        queue = new LinkedList<>();
    }

    @Override
    public void addFront(T item) {
        queue.addFirst(item);
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
    public void removeTail() {
        if (queue.size() > 0) {
            queue.removeLast();
            removeTailStatus = REMOVE_TAIL_OK;
        } else {
            removeTailStatus = REMOVE_TAIL_ERR;
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
    public T getTail() {
        if (queue.size() > 0) {
            getTailStatus = GET_TAIL_OK;
            return queue.getLast();
        } else {
            getTailStatus = GET_TAIL_ERR;
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
    public int getRemoveTailStatus() {
        return removeTailStatus;
    }

    @Override
    public int getGetFrontStatus() {
        return getFrontStatus;
    }

    @Override
    public int getGetTailStatus() {
        return getTailStatus;
    }
}

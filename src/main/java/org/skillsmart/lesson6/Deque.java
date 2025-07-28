package org.skillsmart.lesson6;

public class Deque<T> extends ParentQueue<T> {

    private static final int REMOVE_TAIL_ERR = 1; // очередь пуста
    private static final int REMOVE_TAIL_OK = 2; // успешно

    private static final int GET_TAIL_ERR = 1; // очередь пуста
    private static final int GET_TAIL_OK = 2; // успешно

    private int removeTailStatus;
    private int getTailStatus;

    public void addFront(T item) {
        queue.addFirst(item);
    }

    public void removeTail() {
        if (queue.size() > 0) {
            queue.removeLast();
            removeTailStatus = REMOVE_TAIL_OK;
        } else {
            removeTailStatus = REMOVE_TAIL_ERR;
        }
    }

    public T getTail() {
        if (queue.size() > 0) {
            getTailStatus = GET_TAIL_OK;
            return queue.getLast();
        } else {
            getTailStatus = GET_TAIL_ERR;
            return null;
        }
    }

    public int getRemoveTailStatus() {
        return removeTailStatus;
    }

    public int getGetTailStatus() {
        return getTailStatus;
    }
}

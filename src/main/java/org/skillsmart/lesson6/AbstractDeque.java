package org.skillsmart.lesson6;

public abstract class AbstractDeque<T> extends AbstractParentQueue<T> {

    private static final int REMOVE_TAIL_ERR = 1; // очередь пуста
    private static final int REMOVE_TAIL_OK = 2; // успешно

    private static final int GET_TAIL_ERR = 1; // очередь пуста
    private static final int GET_TAIL_OK = 2; // успешно

    // конструктор
    // постусловие: создана пустая двусторонняя очередь
    //public abstract AbstractDeque<T> AbstractDeque();

    // постусловие: в голову очереди добавлен новый элемент
    public abstract void addFront(T item);

    // предусловие: очередь не пуста
    // постусловие: из хвоста очереди удален элемент
    public abstract void removeTail();

    // предусловие: очередь не пуста
    public abstract T getTail(); // получить элемент из хвоста очереди

    public abstract int getRemoveTailStatus(); // получить статус removeTail()
    public abstract int getGetTailStatus(); // получить статус getTail()
}

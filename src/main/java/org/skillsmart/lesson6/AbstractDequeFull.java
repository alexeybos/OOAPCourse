package org.skillsmart.lesson6;

// Двусторонняя очередь. Отдельный АТД (без Parent).
public abstract class AbstractDequeFull<T> {

    // конструктор
    //public abstract AbstractDequeFull<T> AbstractDequeFull();

    // статусы
    public static final int REMOVE_FRONT_ERR = 1; // очередь пуста
    public static final int REMOVE_FRONT_OK = 2; // успешно

    public static final int REMOVE_TAIL_ERR = 1; // очередь пуста
    public static final int REMOVE_TAIL_OK = 2; // успешно

    public static final int GET_FRONT_ERR = 1; // очередь пуста
    public static final int GET_FRONT_OK = 2; // успешно

    public static final int GET_TAIL_ERR = 1; // очередь пуста
    public static final int GET_TAIL_OK = 2; // успешно


    // команды
    // постусловие: в голову очереди добавлен новый элемент
    public abstract void addFront(T item);

    // постусловие: в хвост очереди добавлен новый элемент
    public abstract void addTail(T item);

    // предусловие: очередь не пуста
    // постусловие: из головы очереди удален элемент
    public abstract void removeFront();

    // предусловие: очередь не пуста
    // постусловие: из хвоста очереди удален элемент
    public abstract void removeTail();

    // запросы
    // предусловие: очередь не пуста
    public abstract T getFront(); // получить элемент из головы очереди

    // предусловие: очередь не пуста
    public abstract T getTail(); // получить элемент из хвоста очереди

    public abstract int size(); // возвращает размер очереди

    // дополнительные запросы

    public abstract int getRemoveFrontStatus(); // получить статус removeFront()
    public abstract int getRemoveTailStatus(); // получить статус removeTail()
    public abstract int getGetFrontStatus(); // получить статус getFront()
    public abstract int getGetTailStatus(); // получить статус getTail()
}

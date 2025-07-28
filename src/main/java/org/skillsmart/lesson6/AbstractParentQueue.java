package org.skillsmart.lesson6;

public abstract class AbstractParentQueue<T> {

    // статусы
    public static final int REMOVE_FRONT_ERR = 1; // очередь пуста
    public static final int REMOVE_FRONT_OK = 2; // успешно

    public static final int GET_FRONT_ERR = 1; // очередь пуста
    public static final int GET_FRONT_OK = 2; // успешно

    // конструктор
    // постусловие: создана пустая очередь
    //public abstract AbstractParentQueue<T> AbstractParentQueue();

    // команды
    // предусловие: -
    // постусловие: в хвост очереди добавлен элемент
    public abstract void addTail(T item);

    // предусловие: очередь не пустая
    // постусловие: из головы очереди удален элемент
    public abstract void removeFront();

    // запросы
    // предусловие: очередь не пустая
    public abstract T getFront(); // возвращает элемент из головы очереди

    public abstract int size(); // возвращает размер очереди

    //дополнительные запросы
    public abstract int getRemoveFrontStatus(); // возвращает статус команды removeFront()
    public abstract int getGetFrontStatus(); // возвращает статус команды getFront()
}

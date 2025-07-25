package org.skillsmart.lesson5;

public abstract class AbstractQueue<T> {
    // Очереди и стеки как стандартные структуры данных очень хороши тем, что, моделируя естественные схемы работы
    // всевозможных сущностей реального и виртуального мира, предоставляют очень компактный интерфейс, не позволяющий делать ничего лишнего

    // статусы
    public static final int DEQUEUE_ERR = 1; // очередь пуста
    public static final int DEQUEUE_OK = 2; // последняя команда dequeue() выполнена успешно

    public static final int PEEK_ERR = 1; // очередь пуста
    public static final int PEEK_OK = 2; // последняя команда peek() выполнена успешно

    // конструктор
    // постусловие: создана пустая очередь
    //public abstract AbstractQueue<T> AbstractQueue();

    // команды
    // предусловие: -
    // постусловие: в хвост очереди добавлен элемент
    public abstract void enqueue(T item);

    // предусловие: очередь не пустая
    // постусловие: из головы очереди удален элемент
    public abstract void dequeue();

    // постусловие: из очереди удалены все элементы
    public abstract void clear();

    // запросы
    // предусловие: очередь не пустая
    public abstract T peek(); // возвращает элемент из головы очереди

    public abstract int size(); // возвращает размер очереди

    //дополнительные запросы
    public abstract int getDequeueStatus(); // возвращает статус команды dequeue() DEQUEUE_*
    public abstract int getPeekStatus(); // возвращает статус команды peek() PEEK_*
}

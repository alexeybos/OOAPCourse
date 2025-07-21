package org.skillsmart.lesson4;

public abstract class AbstractDynArray<T> {

    public static final int INSERT_OK = 1;
    public static final int INSERT_ERR = 2;

    public static final int REMOVE_OK = 1;
    public static final int REMOVE_ERR = 2;

    public static final int GET_OK = 1;
    public static final int GET_ERR = 2;

    // конструктор
    // постусловие: создается новый динамический массив
    //public abstract AbstractDynArray<T> AbstractDynArray();

    // команды
    // постусловие: в хвост массива добавлен элемент
    public abstract void append(T itm);

    // предусловие: в массиве присутствует элемент с указанным индексом
    // постусловие: все значения начиная с указанного индекса сдвигаются вправо (вперед) на одну позицию
    // в указанный индекс вставляется элемент с указанным значением
    public abstract void insert(T itm, int index);

    // предусловие: в массиве присутствует элемент с указанным индексом
    // постусловие: все значения начиная со следующего индекса сдвигаются влево на одну позицию.
    public abstract void remove(int index);

    //постусловие: из массива удаляются все элементы.
    public abstract void clear();

    // запросы
    //предусловие: в массиве присутствует элемент с указанным индексом
    public abstract T get(int index);

    public abstract int length(); // получить кол-во элементов массива

    // дополнительные запросы
    public abstract int getInsertStatus();
    public abstract int getRemoveStatus();
    public abstract int getGetStatus();
}

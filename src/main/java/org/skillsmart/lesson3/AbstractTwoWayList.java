package org.skillsmart.lesson3;

public abstract class AbstractTwoWayList<T> extends AbstractParentLinkedList<T> {

    public static final int LEFT_OK = 1; // последняя команда left() выполнена успешно
    public static final int LEFT_ERR = 2; // слева нет элементов

    //конструктор
    //постусловие: создан новый пустой список
    //public abstract AbstractTwoWayList<T> AbstractTwoWayList();

    //команды
    //предусловие: слева курсора есть элемент
    //постусловие: курсор сдвинут на один узел влево
    public abstract void left();

    // дополнительные запросы
    public abstract int getLeftResult(); // возвращает значение LEFT_*
}

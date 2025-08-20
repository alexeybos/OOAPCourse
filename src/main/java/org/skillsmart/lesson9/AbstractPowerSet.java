package org.skillsmart.lesson9;

public abstract class AbstractPowerSet<T> extends AbstractHashTable<T> {

    public static final int PUT_EXISTS = 3; // элемент уже есть в множестве

    // конструктор
    // постусловие: создано пустое множество с указанным размером
    //public abstract AbstractPowerSet<T> AbstractPowerSet(int sz);

    // команды
    // предусловие: в таблице имеется свободный слот для value
    // постусловие: в множество добавлен элемент, если он отсутствует
    public abstract void put(T value);
}

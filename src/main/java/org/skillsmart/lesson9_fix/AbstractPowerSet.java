package org.skillsmart.lesson9_fix;

public abstract class AbstractPowerSet<T> extends AbstractHashTable<T> {

    public static final int PUT_EXISTS = 3; // элемент уже есть в множестве

    // конструктор
    // постусловие: создано пустое множество с указанным размером
    //public abstract AbstractPowerSet<T> AbstractPowerSet(int sz);

    // команды
    // предусловие: в таблице имеется свободный слот для value
    // постусловие: в множество добавлен элемент, если он отсутствует
    // запросы
// возвращает пересечение текущего множества
// с множеством set
    public abstract PowerSet<T> Intersection(PowerSet<T> set);

    // возвращает объединение текущего множества
// и множества set
    public abstract PowerSet<T> Union(PowerSet<T> set);

    // возвращает разницу между текущим множеством
// и множеством set
    public abstract PowerSet<T> Difference(PowerSet<T> set);

    // проверка, будет ли set подмножеством
// текущего множества
    public abstract boolean IsSubset(PowerSet<T> set);
}

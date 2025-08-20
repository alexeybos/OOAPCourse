package org.skillsmart.lesson9;

public abstract class AbstractSimplePowerSet<T> {

    // статусы
    public static final int PUT_OK = 2; // добавлено успешно
    public static final int PUT_EXISTS = 3; // элемент уже есть в множестве

    public static final int REMOVE_ERR = 1; // значения нет в множестве
    public static final int REMOVE_OK = 2; // элемент удален

    // конструктор
    // постусловие: создано пустое множество
    //public abstract AbstractSimplePowerSet<T> AbstractSimplePowerSet();

    // команды
    // постусловие: в множество добавлен элемент, если он отсутствует
    public abstract void put(T value);

    // предусловие: в множестве присутствует элемент со значением value
    // постусловие: из множества удален элемент со значением value
    public abstract void remove(T value);

    // постусловие: в множество добавлены все отсутствующие элементы из множества set2
    //public abstract void union(AbstractSimplePowerSet<T> set2);

    // запросы
    public abstract boolean get(T value); // получаем true если значение есть в множестве и false, если его нет

    public abstract int size(); // размер множества

    // дополнительные запросы

    public abstract int getPutStatus();
    public abstract int getRemoveStatus();
}

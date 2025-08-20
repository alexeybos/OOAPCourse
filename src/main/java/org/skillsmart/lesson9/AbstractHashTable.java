package org.skillsmart.lesson9;

public abstract class AbstractHashTable<T> {

    // статусы
    public static final int PUT_ERR = 1; // таблица полная, свободных слотов нет
    public static final int PUT_OK = 2; // успешно

    public static final int REMOVE_ERR = 1; // индекс вне пределов таблицы или уже пуст
    public static final int REMOVE_OK = 2; // слот очищен

    // конструктор
    // постусловие: создана пустая хэш-таблица заданного размера
    public abstract AbstractHashTable<T> AbstractHashTable(int sz);

    // команды
    // предусловие: в таблице имеется свободный слот для value;
    // постусловие: в таблицу добавлено новое значение
    public abstract void put(T value);

    // предусловие: в таблице имеется значение value;
    // постусловие: из таблицы удалено значение value
    public abstract void remove(T value);

    // запросы
    public abstract boolean get(T value); // содержится ли значение value в таблице

    public abstract int size(); // количество элементов в таблице

    // запросы статусов (возможные значения статусов)
    public abstract int get_put_status(); // успешно;
    // система коллизий не смогла найти свободный слот для значения

    public abstract int get_remove_status(); // успешно; значения нету в таблице
}

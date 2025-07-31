package org.skillsmart.lesson7;

public abstract class AbstractHashTable<T> {

    // статусы
    public static final int PUT_ERR = 1; // таблица полная, свободных слотов нет
    public static final int PUT_OK = 2; // успешно

    public static final int REMOVE_ERR = 1; // индекс вне пределов таблицы или уже пуст
    public static final int REMOVE_OK = 2; // слот очищен

    // конструктор
    // постусловие: создана пустая хэш таблица с указанным размером
    //public abstract AbstractHashTable<T> AbstractHashTable(int max_size);

    // команды
    // предусловие: таблица не полная (есть хотя бы один свободный слот)
    // постусловие: элемент добавлен в таблицу
    public abstract void put(T value);

    // предусловие: индекс находится в разрешенном диапазоне
    // постусловие: слот с указанным индексом очищен
    public abstract void remove(int index); // предположил, что здесь уместнее параметр индекс, т.к. мы его получаем из find() по значению

    // запросы
    public abstract int find(T value); // получить индекс элемента

    public abstract int size(); // возвращает количество элементов в таблице

    // дополнительные запросы

    public abstract int getPutStatus();
    public abstract int getRemoveStatus();
}

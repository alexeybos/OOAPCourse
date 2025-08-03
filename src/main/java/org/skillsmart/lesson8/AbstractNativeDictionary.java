package org.skillsmart.lesson8;

public abstract class AbstractNativeDictionary<T> {

    // статусы
    public static final int PUT_ERR = 1; // система коллизий не смогла найти свободный слот для ключа
    public static final int PUT_OK = 2; // успешно

    public static final int REMOVE_ERR = 1; // значения нет в таблице
    public static final int REMOVE_OK = 2; // слот очищен

    public static final int GET_ERR = 1; // ключа нет в таблице
    public static final int GET_OK = 2; // успешно


    // конструктор
    // постусловие: создан пустой словарь с указанным размером
    //public abstract AbstractNativeDictionary<T> AbstractNativeDictionary(int max_size);

    // команды
    // предусловие: в словаре имеется свободный слот для key;
    // постусловие: в словаре добавлено (заменено в случае наличия) значение по ключу key
    public abstract void put(String key, T value);

    // предусловие: в словаре имеется значение key
    // постусловие: из словаря удалена запись с ключом key
    public abstract void remove(String key);

    // запросы
    // предусловие: в словаре имеется ключ key
    public abstract T get(String key); // возвращает значение по ключу

    public abstract int size(); // возвращает количество элементов в словаре

    // дополнительные запросы

    public abstract int getPutStatus();
    public abstract int getRemoveStatus();
    public abstract int getGetStatus();
}

package org.skillsmart.lesson10;

public abstract class AbstractBloomFilter {

    // конструктор
    // постусловие: создан фильтр указанной длины
    //public abstract AbstractBloomFilter AbstractBloomFilter(int len);

    // команды
    // постусловие: в фильтр добавлена строка
    public abstract void add(String value);

    // запросы
    // проверка, имеется ли строка в фильтре
    public abstract boolean isValue(String value);

    // слияние фильтров блюма
    public abstract BloomFilter mergeFilter(BloomFilter filter2);
}

package org.skillsmart.ooap2.lesson08;

import java.util.Arrays;
import java.util.List;

//базовый класс
class Fruit {
    public String getName() { return "Фрукт"; }
}

class Apple extends Fruit {
    @Override
    public String getName() { return "Яблоко"; }
}

class Orange extends Fruit {
    @Override
    public String getName() { return "Апельсин"; }
}

public class Example8 {

    // массивы в Java ковариантны
    public static void processFruits(Fruit[] fruits) {
        for (Fruit fruit: fruits) {
            System.out.println(fruit.getName());
        }
    }

    //пример контравариантности: в метод может прийти коллекция базового типа и в нее мы можем добавить
    //объекты указанного дочернего типа
    public static void addApplesToCollection(List<? super Apple> collection) {
        collection.add(new Apple());
        collection.add(new Apple());
    }

}

Apple[] apples = {new Apple(), new Apple()};
Orange[] oranges = {new Orange(), new Orange()};

// можем передать Apple[] и Orange[] туда, где ожидается Fruit[] - ковариантность.
processFruits(apples);
processFruits(oranges);

//контравариантность - можем передать в метод с "? super дочерний класс" список с объектами базового типа,
//но работать с сущностями можно только после явного приведения типа
List<Fruit> fruits = Arrays.asList(new Apple(), new Orange());
addApplesToCollection(fruits);
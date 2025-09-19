package org.skillsmart.ooap2.lesson07;

//создаем базовый класс
public class Animal {
    public String sound() {
        return "sound";
    }
}

//у наследника переопределяем метод
public class Dog extends Animal {
    @Override
    public String sound() {
        return "гав";
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Dog();  // ссылка базового класса (Animal) на объект дочернего класса Dog
        myAnimal.sound();  // динамическое связывание - вызовется метод sound() из Dog
    }
}
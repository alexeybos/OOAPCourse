package org.skillsmart.ooap2.lesson01;

public class Example1 {

    /**
     * Примеры наследования и полиморфизма:
     * Базовый класс - комната.
     * Два поля: площадь и количество окон
     * Один метод: получает стоимость уборки помещения.
     * Далее два класса, расширяющие класс комната: Кухня и Ванная комната
     */
    class Room {
        public final float roomArea;
        public final int windowCount;

        public Room(float roomArea, int windowCount) {
            this.roomArea = roomArea;
            this.windowCount = windowCount;
        }

        public float getCleaningPrice() {
            return roomArea * 1.35f;
        }
    }

    /**
     * Наследование (is-a): класс кухня потомок класса Room. Имеет те же поля + свое поле "наличие газовой плиты"
     * Полиморфизм: метод getCleaningPrice() переопределен. Для данного класса он учитывает в расчете уникальное
     * поле класса Kitchen (hasGasStove)
     */
    class Kitchen extends Room {

        public boolean hasGasStove;
        public Kitchen(float roomArea, int windowCount) {
            super(roomArea, windowCount);
        }

        @Override
        public float getCleaningPrice() {
            float additionalCleaningPrice = 0;
            if (hasGasStove) additionalCleaningPrice = 100;
            return roomArea * 1.35f + additionalCleaningPrice;
        }
    }

    /**
     * Наследование (is-a): класс ванная комната потомок класса Room. Имеет те же поля, что и родительский класс
     * Полиморфизм: метод getCleaningPrice() переопределен. Тут просто используем другой коэффициент.
     */
    class Bathroom extends Room {

        public Bathroom(float roomArea, int windowCount) {
            super(roomArea, windowCount);
        }

        @Override
        public float getCleaningPrice() {
            return roomArea * 5.35f;
        }
    }

    /**
     * Квартира - пример композиции (has-a)
     * Квартира состоит из комнаты (одна или несколько), кухни и ванной (одна или несколько)
     * + свои поля класса (этаж)
     */
    class Flat {
        public final Room[] rooms;
        public final Kitchen kitchen;
        public final Bathroom[] bathrooms;
        public final int floor;

        public Flat(Room[] rooms, Kitchen kitchen, Bathroom[] bathrooms, int floor) {
            this.rooms = rooms;
            this.kitchen = kitchen;
            this.bathrooms = bathrooms;
            this.floor = floor;
        }
    }
}

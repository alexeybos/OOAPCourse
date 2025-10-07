package org.skillsmart.ooap2.lesson15;

public class Example15 {

    class Car {
        //...
        public void refueling() {
            System.out.println("I need fuel");
        }
    }

    class GasCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need gas");
        }
    }

    class GasolineCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need Gasoline");
        }
    }

    class DieselCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need Diesel");
        }
    }
    class ElectricCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need electricity");
        }
    }

}

package org.skillsmart.ooap2.lesson20;

import java.time.LocalTime;

public class Example20 {

    //наследование с функциональной вариацией
    public class Ship{
        public void sail() {
            System.out.println("On the water");
        }
    }

    public class Submarine extends Ship {
        @Override
        public void sail() {
            System.out.println("Under the water");
        }
    }

    //наследование с вариацией типа
    class DatabaseConnection {
        public DatabaseConnection createConnection() {
            return new DatabaseConnection();
        }
    }

    class OracleConnection extends DatabaseConnection {
        @Override
        public OracleConnection createConnection() {
            return new OracleConnection();
        }
    }

    class PostgresqlConnection extends DatabaseConnection{
        @Override
        public PostgresqlConnection createConnection() {
            return new PostgresqlConnection();
        }
    }

    //Наследование с конкретизацией (reification inheritance)
    public abstract class Watch {
        public abstract LocalTime getTime();
    }

    public class ElectronicWatch extends Watch {
        @Override
        public LocalTime getTime() {
            //hours = getNumbersBeforeColon();
            //minutes = getNumbersAfterColon();
            return null;
        }
    }

    public class SunWatch extends Watch {
        @Override
        public LocalTime getTime() {
            //if (isSunny()) getHours(), getMinutes()
            return null;
        }
    }

    //Структурное наследование (structure inheritance)
    public class Shape {
        protected int size;
    }

    interface Resizable {
        public void resize(int size);
    }

    public class Square extends Shape implements Resizable {

        @Override
        public void resize(int size) {
            this.size = size;
        }
    }

}

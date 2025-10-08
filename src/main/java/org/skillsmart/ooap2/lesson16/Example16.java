package org.skillsmart.ooap2.lesson16;

import java.util.List;

public class Example16 {

    class Car {
        public void refueling() {
            System.out.println("I need fuel");
        }
    }

    class GasolineCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need Gasoline");
        }
    }

    class ElectricCar extends Car {
        @Override
        public void refueling() {
            System.out.println("I need electricity");
        }
    }

    //пример полиморфного вызова метода
    public void polyExample() {
        GasolineCar gasolineCar = new GasolineCar();
        ElectricCar electricCar = new ElectricCar();
        gasolineCar.refueling(); //полиморфный вызов
        electricCar.refueling(); //полиморфный вызов
    }

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

    // ковариантный вызов
    public void covariantExample() {
        DatabaseConnection dcOra = new OracleConnection();
        DatabaseConnection dcPostgresql = new PostgresqlConnection();

        //ковариантность в возвращаемом типе
        DatabaseConnection newOraConnect1 = dcOra.createConnection();
        DatabaseConnection newPGConnect1 = dcPostgresql.createConnection();
        DatabaseConnection newOraConnect2 = newConnect(dcOra);
        DatabaseConnection newPGConnect2 = newConnect(dcPostgresql);

        //ковариантная типизация
        testConnections(List.of(newOraConnect1, newOraConnect2));
        testConnections(List.of(newPGConnect1, newPGConnect2));
    }

    public DatabaseConnection newConnect(DatabaseConnection type) {
        return type.createConnection();
    }

    public void testConnections(List<? extends DatabaseConnection> connects) {
        // что-нибудь делаем в цикле
    }
}

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

        @Override
        public String toString() {
            return "DatabaseConnection";
        }

        public <T extends DatabaseConnection> void covariantMethod(List<T> values) {
            for (T value : values) {
                System.out.println(value.toString());
            }
        }

        public void covariantMethod2(List<? extends DatabaseConnection> values) {
            for (DatabaseConnection value : values) {
                System.out.println(value.toString());
            }
        }
    }

    class OracleConnection extends DatabaseConnection {
        @Override
        public OracleConnection createConnection() {
            return new OracleConnection();
        }

        @Override
        public String toString() {
            return "OracleConnection";
        }
    }

    class PostgresqlConnection extends DatabaseConnection{
        @Override
        public PostgresqlConnection createConnection() {
            return new PostgresqlConnection();
        }

        @Override
        public String toString() {
            return "PostgresqlConnection";
        }
    }

    /**
     * это уже доделал после ознакомления с ответом
     */
    class Provider {
        public <T extends DatabaseConnection> void covariantMethod(List<T> values) {
            for (T value : values) {
                System.out.println(value.toString());
            }
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
        testConnections(List.of(newOraConnect1, newOraConnect2, newPGConnect2));
        System.out.println("next");
        testConnections(List.of(newPGConnect1, newPGConnect2, newOraConnect1, newOraConnect2));
        System.out.println("next");
        //все что ниже уже доделал после ознакомления с ответом
        dcOra.covariantMethod(List.of(newPGConnect1, newPGConnect2, newOraConnect1, newOraConnect2));
        System.out.println("next");
        dcOra.covariantMethod2(List.of(newPGConnect1, newPGConnect2, newOraConnect1, newOraConnect2));
        Provider provider = new Provider();
        System.out.println("next");
        provider.covariantMethod(List.of(newPGConnect1, newPGConnect2, newOraConnect1, newOraConnect2));
    }

    public DatabaseConnection newConnect(DatabaseConnection type) {
        return type.createConnection();
    }

    public void testConnections(List<? extends DatabaseConnection> connects) {
        for (DatabaseConnection connect : connects) {
            System.out.println(connect.toString());
        }
    }
}

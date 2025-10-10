package org.skillsmart.ooap2.lesson13;

public class Example13 {

    // 1. метод публичен в родительском классе А и публичен в его потомке B;
    class A {
        public void doAction() {
            System.out.println("Действие A");
        }
    }

    class B extends A {
        @Override
        public void doAction() { // Все еще public
            System.out.println("Действие B");
        }
    }

    public class Main {
        public static void main(String[] args) {
            //A obj = new B();
            //obj.doAction(); // Вывод: Действие B
        }
    }

    // 2. метод публичен в родительском классе А и скрыт в его потомке B;
    // в Java нельзя сужать видимость.

    // 3. метод скрыт в родительском классе А и публичен в его потомке B;
    class A1 {
        protected void doInternalAction() {
            System.out.println("Внутреннее действие A");
        }
    }

    class B1 extends A1 {
        @Override
        public void doInternalAction() {
            System.out.println("Внутреннее действие B");
        }
    }

    public class Main1 {
        public static void main(String[] args) {
            //A1 objA = new A1();
            // objA.doInternalAction(); // Ошибка компиляции: метод protected

            //B1 objB = new B1();
            //objB.doInternalAction(); // Корректно: вывод "Внутреннее действие B, т.к. теперь публичное"
        }
    }

    // 4. метод скрыт в родительском классе А и скрыт в его потомке B.
    class A2 {
        protected void doInternalAction() {
            System.out.println("Внутреннее действие от A");
        }
    }

    class B2 extends A2 {
        // Переопределяем метод, но оставляем тот же уровень доступа (protected).
        @Override
        protected void doInternalAction() {
            System.out.println("Внутреннее действие от B");
        }
    }

    public class Main2 {
        public static void main(String[] args) {
            //B2 objB = new B2();
            //objB.doInternalAction(); // Ошибка компиляции: метод protected
        }
    }
}

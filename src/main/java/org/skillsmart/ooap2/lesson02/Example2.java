package org.skillsmart.ooap2.lesson02;

public class Example2 {

    /**
     * Базовый класс прямоугольник. Достаточно задать размер двух сторон - ширины и высоты
     * Периметр считается простым удвоением сумм длин этих сторон
     */
    class Rectangle {
        protected double side1;
        protected double side2;

        public Rectangle(double side1, double side2) {
            this.side1 = side1;
            this.side2 = side2;
        }

        public double getPerimeter() {
            return 2 * (side1 + side2);
        }
    }

    /**
     * Четырехугольник. Класс, задающий более общий случай родителя:
     * Все четыре стороны могут быть разного размера, поэтому в класс добавляем новые поля и
     * переопределяем метод подсчета периметра на более общий - честное сложение всех четырех сторон.
     * Четырехугольник - более общий случай, чем прямоугольник
     */
    class Quadrangle extends Rectangle {
        protected double side3;
        protected double side4;

        public Quadrangle(double side1, double side2, double side3, double side4) {
            super(side1, side2);
            this.side3 = side3;
            this.side4 = side4;
        }

        @Override
        public double getPerimeter() {
            return side1 + side2 + side3 + side4;
        }
    }

    /**
     * Квадрат. Класс, задающий более специализированный случай родителя:
     * Все стороны квадрата равны, поэтому при создании объекта данного класса достаточно указать один размер.
     * При этом метод подсчета периметра менять не обязательно. Работает метод родительского класса.
     */
    class Square extends Rectangle {

        public Square(double side) {
            super(side, side);
        }
    }

}

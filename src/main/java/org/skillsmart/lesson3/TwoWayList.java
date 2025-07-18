package org.skillsmart.lesson3;

public class TwoWayList<T> extends ParentLinkedList<T> {

    private int leftStatus;

    public static final int LEFT_OK = 1; // последняя команда left() выполнена успешно
    public static final int LEFT_ERR = 2; // слева нет элементов

    public void left() {
        if (isHead()) {
            leftStatus = LEFT_ERR;
        } else {
            currentNode = currentNode.prev;
            leftStatus = LEFT_OK;
        }
    };

    // дополнительные запросы
    public int getLeftResult() {
        return leftStatus;
    }
}

package org.skillsmart.lesson1;

import java.util.ArrayList;
import java.util.List;

public class BoundedStack<T> {

    // скрытые поля
    private List<T> stack; // основное хранилище стека
    private int peekStatus; // статус запроса peek()
    private int popStatus; // статус команды pop()
    private int pushStatus; // статус команды push(T value)
    private int stackMaxSize = DEFAULT_MAX_SIZE; // максимальный размер стека. По умолчанию 32 элемента

    // интерфейс класса, реализующий АТД BoundedStack
    public static final int POP_NIL = 0;
    public static final int POP_OK = 1;
    public static final int POP_ERR = 2;
    public static final int PEEK_NIL = 0;
    public static final int PEEK_OK = 1;
    public static final int PEEK_ERR = 2;
    public static final int PUSH_NIL = 0;
    public static final int PUSH_OK = 1;
    public static final int PUSH_ERR = 2;
    public static final int DEFAULT_MAX_SIZE = 32;

    // конструкторы
    // постусловие: создан новый пустой BoundedStack с верхней границей (кол-вом элементов) size
    public BoundedStack() {
        clear();
    }

    // постусловие: создан новый пустой BoundedStack с верхней границей (кол-вом элементов) по умолчанию
    public BoundedStack(int size) {
        this.stackMaxSize = size;
        clear();
    }

    // команды
    // предусловие: стек не полон
    // постусловие: в стек добавлено новое значение
    public void push(T value) {
        if (stack.size() >= stackMaxSize) {
            pushStatus = PUSH_ERR; // стек полный
        } else {
            stack.add(value);
            pushStatus = PUSH_OK;
        }

    }

    // предусловие: стек не пуст
    // постусловие: из стека удален верхний элемент
    public void pop() {
        if (size() > 0) {
            stack.removeLast();
            popStatus = POP_OK;
        } else {
            popStatus = POP_ERR;
        }
    }

    // постусловие: из стека удалятся все элементы
    public void clear() {
        stack = new ArrayList<>(stackMaxSize); // пустой список/стек размера stackMaxSize

        // начальные статусы для предусловий push(T), peek() и pop()
        peekStatus = PEEK_NIL;
        popStatus = POP_NIL;
        pushStatus = PUSH_NIL;
    }

    // запросы
    // предусловие: стек не пуст
    public T peek() {
        T result;
        if (size() > 0) {
            result = stack.getLast();
            peekStatus = PEEK_OK;
        } else {
            result = null;
            peekStatus = PEEK_ERR;
        }
        return result;
    }

    public int size() {
        return stack.size();
    }

    // дополнительные запросы
    // возвращает значение PEEK_*
    public int getPeekStatus() {
        return peekStatus;
    }

    // возвращает значение POP_*
    public int getPopStatus() {
        return popStatus;
    }

    // возвращает значение PUSH_*
    public int getPushStatus() {
        return pushStatus;
    }

    // возвращает максимальный размер стека. Вот вообще не уверен, что это нужно пользователю класса
    public int getStackMaxSize() {
        return stackMaxSize;
    }
}


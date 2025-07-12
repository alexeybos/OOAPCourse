package org.skillsmart.lesson1;

// АТД BoundedStack
public abstract class AbstractBoundedStack<T> {

    public static final int POP_NIL = 0; // push() ещё не вызывалась
    public static final int POP_OK = 1; // последняя pop() отработала нормально
    public static final int POP_ERR = 2; // стек пуст

    public static final int PEEK_NIL = 0; // push() ещё не вызывалась
    public static final int PEEK_OK = 1; // последняя peek() вернула корректное значение
    public static final int PEEK_ERR = 2; // стек пуст

    public static final int PUSH_NIL = 0; // push() ещё не вызывалась
    public static final int PUSH_OK = 1; // последняя push() отработала корректно
    public static final int PUSH_ERR = 2; // стек полон

    // из теории пока не понял чем же являются возможные дефолтные значения и насколько законно их нахождение в АТД
    public static final int DEFAULT_MAX_SIZE = 32;

    // конструкторы
    // постусловие: создан новый пустой BoundedStack с верхней границей (кол-вом элементов) size
    public abstract AbstractBoundedStack<T> AbstractBoundedStack(int size);
    // постусловие: создан новый пустой BoundedStack с верхней границей (кол-вом элементов) по умолчанию
    public abstract AbstractBoundedStack<T> AbstractBoundedStack();

    // команды
    // предусловие: стек не полон
    // постусловие: в стек добавлено новое значение
    public abstract void push(T value);

    // предусловие: стек не пуст
    // постусловие: из стека удален верхний элемент
    public abstract void pop();

    // постусловие: из стека удалятся все элементы
    public abstract void clear();

    // запросы
    // предусловие: стек не пуст
    public abstract T peek();

    public abstract int size();

    // дополнительные запросы

    public abstract int getPopResult(); // возвращает значение POP_*
    public abstract int getPeekResult(); // возвращает значение PEEK_*
    public abstract int getPushResult(); // возвращает значение PUSH_*
    public abstract int getStackMaxSize(); // возвращает максимальный размер стека. Вот вообще не уверен, что это нужно пользователю класса
}

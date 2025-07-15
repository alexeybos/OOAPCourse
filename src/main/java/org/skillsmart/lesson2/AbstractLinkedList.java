package org.skillsmart.lesson2;

public abstract class AbstractLinkedList<T> {

    /**
     * Ответы на задания:
     * 2.2  Почему операция tail не сводима к другим операциям (если исходить из эффективной реализации)?
     *
     * Как я понимаю, в принципе, команда tail может быть выражена через последовательность команд head() -> итеративно right()
     * Но в данном случае tail() будет иметь сложность O(N), мы всегда гарантированно будет проходить весь список.
     * Таким образом, нам более эффективно запланировать отдельную команду tail(), не сводимую к head()-right()
     *
     * 2.3 Операция поиска всех узлов с заданным значением, выдающая список таких узлов, уже не нужна. Почему?
     *
     * Концепция курсора предполагает, что текущее значение у нас в каждый отдельный момент всегда только одно.
     * Возврат списка узлов противоречит этой абстракции - где работа идёт через курсор и значения, а не через манипуляции с узлами.
     * Функциональность findAll() сводима к head() - get() - итеративно find()
     */

    // статусы
    public static final int HEAD_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int HEAD_OK = 1; // последняя команда head() выполнена успешно
    public static final int HEAD_ERR = 2; // список пуст (т.е. курсор не указывает на элемент списка)

    public static final int TAIL_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int TAIL_OK = 1; // последняя команда tail() выполнена успешно
    public static final int TAIL_ERR = 2; // список пуст

    public static final int RIGHT_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int RIGHT_OK = 1; // последняя команда right() выполнена успешно
    public static final int RIGHT_ERR = 2; // список пуст
    public static final int RIGHT_ABSENT = 3; // курсор уже указывает на последний элемент (справа нет элементов)

    public static final int PUT_RIGHT_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int PUT_RIGHT_OK = 1; // последняя команда putRight() выполнена успешно
    public static final int PUT_RIGHT_ERR = 2; // список пуст

    public static final int PUT_LEFT_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int PUT_LEFT_OK = 1; // последняя команда putLeft() выполнена успешно
    public static final int PUT_LEFT_ERR = 2; // список пуст

    public static final int REMOVE_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int REMOVE_OK = 1; // последняя команда remove() выполнена успешно
    public static final int REMOVE_ERR = 2; // список пуст

    public static final int ADD_TO_EMPTY_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int ADD_TO_EMPTY_OK = 1; // последняя команда add_to_empty() выполнена успешно
    public static final int ADD_TO_EMPTY_ERR = 2; // список НЕ пуст (курсор указывает на элемент списка)

    //исхожу так же из концепции, что инициализируется список только через add_to_empty()
    public static final int ADD_TAil_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int ADD_TAil_OK = 1; // последняя команда addTail() выполнена успешно
    public static final int ADD_TAil_ERR = 2; // список пуст

    public static final int REPLACE_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int REPLACE_OK = 1; // последняя команда replace() выполнена успешно
    public static final int REPLACE_ERR = 2; // список пуст

    public static final int FIND_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int FIND_OK = 1; // последняя команда find() выполнена успешно
    public static final int FIND_ERR = 2; // список пуст (статус для полноты)
    public static final int FIND_NOT_FOUND = 3; // искомое значение не найдено

    public static final int GET_NIL = 0; // add_to_empty() еще не вызывалась
    public static final int GET_OK = 1; // последняя команда get() выполнена успешно
    public static final int GET_ERR = 2; // список пуст


    // конструктор
    // постусловие: создан новый пустой список
    public abstract AbstractLinkedList<T> AbstractLinkedList();

    // команды
    // предусловие: список не пуст
    // постусловие: курсор указывает на первый узел в списке
    public abstract void head();

    // предусловие: список не пуст
    // постусловие: курсор указывает на последний узел в списке
    public abstract void tail();

    // предусловие: список не пуст, курсор не указывает на последний узел в списке
    // постусловие: курсор указывает на следующий узел справа
    public abstract void right();

    // предусловие: список не пуст
    // постусловие: в список добавлен узел со значением value справа от текущего
    public abstract void putRight(T value);

    // предусловие: список не пуст
    // постусловие: в список добавлен узел со значением value слева от текущего
    public abstract void putLeft(T value);

    // предусловие: список не пуст
    // постусловие: текущий узел удален, курсор смещается к правому соседу, если он есть, в противном случае курсор
    // смещается к левому соседу, если он есть
    public abstract void remove();

    // постусловие: из списка удалятся все узлы
    public abstract void clear();

    // предусловие: список пуст
    // постусловие: в список добавлен элемент со значением value
    public abstract void add_to_empty(T value);

    // постусловие: из списка удалены все узлы со значением value
    public abstract void removeAll(T value);

    // предусловие: список не пуст (? - надеюсь я тут правильно понимаю, что список инициализируется исключительно
    // через add_to_empty() или же при явно указанном месте вставки все же позволительно добавлять элемент в пустой список?)
    // постусловие: элемент со значением value добавлен последним элементом списка
    public abstract void addTail(T value);

    // предусловие: список не пуст
    // постусловие: значение текущего узла заменено на заданное;
    public abstract void replace(T value);

    // предусловие: список не пуст
    // постусловие: курсор указывает на ближайший справа от текущего узел с указанным значением value
    public abstract void find(T value);

    // запросы
    // предусловие: список не пуст
    public abstract T get(); // получить значение текущего узла;
    
    public abstract int size(); // посчитать количество узлов в списке;
    public abstract boolean isHead(); // находится ли курсор в начале списка?
    public abstract boolean isTail(); // находится ли курсор в конце списка?
    public abstract boolean isValue(); // установлен ли курсор на какой-либо узел в списке (по сути, непустой ли список).

    // дополнительные запросы
    public abstract int getHeadResult(); // возвращает значение HEAD_*
    public abstract int getTailResult(); // возвращает значение TAIL_*
    public abstract int getRightResult(); // возвращает значение RIGHT_*
    public abstract int getPutRightResult(); // возвращает значение PUT_RIGHT_*
    public abstract int getPutLeftResult(); // возвращает значение PUT_LEFT_*
    public abstract int getRemoveResult(); // возвращает значение REMOVE_*
    public abstract int getAddToEmptyResult(); // возвращает значение ADD_TO_EMPTY_*
    public abstract int getAddTailResult(); // возвращает значение ADD_TAil_*
    public abstract int getReplaceResult(); // возвращает значение REPLACE_*
    public abstract int getFindResult(); // возвращает значение FIND_*
    public abstract int getGetResult(); // возвращает значение GET_*

}

package org.skillsmart.lesson3;

import java.util.Objects;

public class ParentLinkedList<T> extends AbstractParentLinkedList<T> {

    // скрытые поля
    private final DummyNode<T> _dummyNode;
    Node<T> currentNode;
    private int size;

    private int headStatus;
    private int tailStatus;
    private int putRightStatus;
    private int putLeftStatus;
    private int removeStatus;
    private int addToEmptyStatus;
    private int replaceStatus;
    private int findStatus;
    private int getStatus;
    private int rightStatus;

    public ParentLinkedList() {
        _dummyNode = new DummyNode<>();
        clear();
    }

    @Override
    public void head() {
        if (size() > 0) {
            currentNode = _dummyNode.next;
            headStatus = HEAD_OK;
        } else {
            headStatus = HEAD_ERR;
        }
    }

    @Override
    public void tail() {
        if (size() > 0) {
            currentNode = _dummyNode.prev;
            tailStatus = TAIL_OK;
        } else {
            tailStatus = TAIL_ERR;
        }
    }

    @Override
    public void right() {
        if (currentNode.next instanceof DummyNode) {
            rightStatus = RIGHT_ERR;
        } else {
            currentNode = currentNode.next;
            rightStatus = RIGHT_OK;
        }
    }

    @Override
    public void putRight(T value) {
        if (size() > 0) {
            Node<T> newNode = new Node<>(value);
            newNode.prev = currentNode;
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            putRightStatus = PUT_RIGHT_OK;
            size++;
        } else {
            putRightStatus = PUT_RIGHT_ERR;
        }
    }

    @Override
    public void putLeft(T value) {
        if (size() > 0) {
            Node<T> newNode = new Node<>(value);
            newNode.next = currentNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
            putLeftStatus = PUT_LEFT_OK;
            size++;
        } else {
            putLeftStatus = PUT_LEFT_ERR;
        }
    }

    @Override
    public void remove() {
        if (size() == 0) removeStatus = REMOVE_ERR;
        if (size() == 1) {
            removeStatus = REMOVE_OK;
            clear();
        }
        if (size() > 1) {
            removeStatus = REMOVE_OK;
            size--;
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            currentNode = currentNode.next;
        }
        if (size() > 0 && currentNode instanceof DummyNode<T>) {
            currentNode = currentNode.prev;
        }
    }

    @Override
    public void clear() {
        _dummyNode.next = _dummyNode;
        _dummyNode.prev = _dummyNode;
        this.size = 0;
        currentNode = _dummyNode;
    }

    @Override
    public void addToEmpty(T value) {
        if (size() > 0) {
            addToEmptyStatus = ADD_TO_EMPTY_ERR;
        } else {
            Node<T> node = new Node<>(value);
            _dummyNode.next = node;
            _dummyNode.prev = node;
            node.prev = _dummyNode;
            node.next = _dummyNode;
            addToEmptyStatus = ADD_TO_EMPTY_OK;
            currentNode = node;
            size++;
        }
    }

    @Override
    public void removeAll(T value) {
        clear();
    }

    @Override
    public void addTail(T value) {
        Node<T> node = new Node<>(value);
        node.prev = _dummyNode.prev;
        node.prev.next = node;
        node.next = _dummyNode;
        _dummyNode.prev = node;
        if (size() == 0) currentNode = node;
        size++;
    }

    @Override
    public void replace(T value) {
        if (size() > 0) {
            currentNode.value = value;
            replaceStatus = REPLACE_OK;
        } else {
            replaceStatus = REPLACE_ERR;
        }
    }

    @Override
    public void find(T value) {
        findStatus = FIND_ERR;
        Node<T> tmpCurrentNode = currentNode;
        right();
        for (; getRightResult() == GET_OK && findStatus != FIND_OK; right()) {
            if (Objects.equals(currentNode.value, value)) findStatus = FIND_OK;
        }
        if (findStatus == FIND_ERR) currentNode = tmpCurrentNode;
    }

    @Override
    public T get() {
        T result;
        if (size() > 0) {
            getStatus = GET_OK;
            result = currentNode.value;
        } else {
            getStatus = GET_ERR;
            result = null;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isHead() {
        return currentNode == _dummyNode.next;
    }

    @Override
    public boolean isTail() {
        return currentNode == _dummyNode.prev;
    }

    @Override
    public boolean isValue() {
        return size() > 0;
    }

    @Override
    public int getHeadResult() {
        return headStatus;
    }

    @Override
    public int getTailResult() {
        return tailStatus;
    }

    @Override
    public int getRightResult() {
        return rightStatus;
    }

    @Override
    public int getPutRightResult() {
        return putRightStatus;
    }

    @Override
    public int getPutLeftResult() {
        return putLeftStatus;
    }

    @Override
    public int getRemoveResult() {
        return removeStatus;
    }

    @Override
    public int getAddToEmptyResult() {
        return addToEmptyStatus;
    }

    @Override
    public int getReplaceResult() {
        return replaceStatus;
    }

    @Override
    public int getFindResult() {
        return findStatus;
    }

    @Override
    public int getGetResult() {
        return getStatus;
    }

}

class Node<T>
{
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

class DummyNode<T> extends Node<T>
{
    public DummyNode() {
        super(null);
        this.next = this;
        this.prev = this;
    }
}


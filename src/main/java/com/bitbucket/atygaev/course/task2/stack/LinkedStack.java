package com.bitbucket.atygaev.course.task2.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Stack is built on linked list of int.
 *
 * Current implementation used LinkedList
 * but it should be replaced to linked list of int.
 */
public class LinkedStack implements Stack {

    private List<Integer> elements;

    /**
     * TODO: Initialize linked list here.
     *
     * The constructor initializes empty stack.
     */
    public LinkedStack() {
        elements = new LinkedList<>();
    }

    /**
     * TODO: Add item to the stack.
     *
     * The method adds item to the linked list and increases size.
     */
    @Override
    public void push(int value) {
        elements.add(0, value);
    }

    /**
     * TODO: Remove item from the stack.
     *
     * The method verifies that the stack is not empty and
     * if so then decreases size. Also removes item
     * from the underlined linked list.
     *
     * Otherwise, throws exception with appropriate message.
     */
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        elements.remove(0);
    }

    /**
     * TODO: Return last added item to the stack.
     *
     * The method verifies that the stack is not empty and
     * if so then returns last added item to underlined linked list.
     *
     * Otherwise, throws exception with appropriate message.
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }

        return elements.get(0);
    }

    /**
     * TODO: Returns size of the stack.
     *
     * Returns count of items in underlined linked list.
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * TODO: Returns true when stack is empty. Otherwise, returns false.
     *
     * Returns true when current size is zero. Otherwise, returns false.
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * TODO: Returns readable information about stack.
     *
     * Returns name of class and items joined by ",".
     */
    @Override
    public String toString() {
        StringBuilder elementsInfo = new StringBuilder("");

        int size = size();

        for (int i = 0; i < size; i++) {
            elementsInfo.append(elements.get(i));

            if (i < size - 1) {
                elementsInfo.append(",");
            }
        }

        return "ArrayStack(" + elementsInfo + ")";
    }

    /**
     * TODO: Returns true when stack is equal another stack by its items.
     *
     * Returns true if passed object is also LinkedStack
     * and its items is the same. Otherwise, returns false.
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) { return true; }
        if ((object == null) || (getClass() != object.getClass())) { return false; }

        LinkedStack stack = (LinkedStack) object;

        return Objects.equals(elements, stack.elements);
    }

    /**
     * TODO: Returns hash code of the stack by its items.
     *
     * Returns Objects#hash of underlined array.
     */
    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
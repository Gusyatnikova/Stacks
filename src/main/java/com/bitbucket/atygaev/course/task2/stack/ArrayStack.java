package com.bitbucket.atygaev.course.task2.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Stack is built on array of int.
 *
 * Current implementation used ArrayList
 * but it should be replaced to array of int.
 */
public class ArrayStack implements Stack {

    private int size;
    private int[] elements;

    /**
     * TODO: Initialize array here.
     *
     * The constructor initializes empty stack.
     */
    public ArrayStack() {
        elements = new int[50];
        size = 0;
    }


    /**
     * TODO: Add item to the stack.
     *
     * The method adds item to the underlined array and increases size.
     */
    @Override
    public void push(int value) {
           elements[++size] = value;
    }

    /**
     * TODO: Remove item from the stack.
     *
     * The method verifies that the stack is not empty and
     * if so then decreases size.
     *
     * Otherwise, throws exception with appropriate message.
     */
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
       size--;
    }

    /**
     * TODO: Return last added item to the stack.
     *
     * The method verifies that the stack is not empty and
     * if so then returns last added item to underlined array.
     *
     * Otherwise, throws exception with appropriate message.
     */
    @Override
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return elements[size];
    }

    /**
     * TODO: Returns size of the stack.
     *
     * Returns count of items in underlined array.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * TODO: Returns true when stack is empty. Otherwise, returns false.
     *
     * Returns true when current size is zero. Otherwise, returns false.
     */
    @Override
    public boolean isEmpty() {
            return (size == 0);
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
            elementsInfo.append(elements[i]);

            if (i < size - 1) {
                elementsInfo.append(",");
            }
        }

        return "ArrayStack(" + elementsInfo + ")";
    }

    /**
     * TODO: Returns true when stack is equal another stack by its items.
     *
     * Returns true if passed object is also ArrayStack
     * and its items is the same. Otherwise, returns false.
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) { return true; }
        if ((object == null) || (getClass() != object.getClass())) { return false; }

        ArrayStack stack = (ArrayStack) object;

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
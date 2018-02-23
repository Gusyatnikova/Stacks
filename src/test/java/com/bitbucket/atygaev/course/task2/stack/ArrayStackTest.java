package com.bitbucket.atygaev.course.task2.stack;

public class ArrayStackTest extends StackTest {
    @Override
    protected Stack getStack() {
        return new ArrayStack();
    }
}
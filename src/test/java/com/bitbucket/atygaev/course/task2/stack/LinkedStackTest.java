package com.bitbucket.atygaev.course.task2.stack;

public class LinkedStackTest extends StackTest {
    @Override
    protected Stack getStack() {
        return new LinkedStack();
    }
}
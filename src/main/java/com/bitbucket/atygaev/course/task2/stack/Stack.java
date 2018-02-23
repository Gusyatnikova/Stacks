package com.bitbucket.atygaev.course.task2.stack;

interface Stack {
    void push(int value);

    void pop();

    int peek();

    int size();

    boolean isEmpty();
}
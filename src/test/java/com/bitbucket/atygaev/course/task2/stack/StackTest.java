package com.bitbucket.atygaev.course.task2.stack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class StackTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Stack stack;

    private Random random;

    @Before
    public void setUp() {
        stack = getStack();

        random = new Random();
    }

    @Test
    public void isEmptyShouldReturnTrueOnEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseOnNonEmptyStack() {
        stack.push(random.nextInt());

        assertFalse(stack.isEmpty());
    }

    @Test
    public void sizeShouldReturnZeroOnEmptyStack() {
        assertEquals(0, stack.size());
    }

    @Test
    public void sizeShouldReturnCountOfPushedItems() {
        int itemsCount = random.nextInt(10);

        for (int i = 0; i < itemsCount; i++) {
            stack.push(random.nextInt());
        }

        assertEquals(itemsCount, stack.size());
    }

    @Test
    public void pushShouldPushItem() {
        int item = random.nextInt();

        stack.push(item);

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test
    public void popShouldPopItem() {
        int item = random.nextInt();

        stack.push(item);
        stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void popShouldThrowExceptionWhenStackIsEmpty() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Stack is empty.");

        stack.pop();
    }

    @Test
    public void peekShouldThrowExceptionWhenStackIsEmpty() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Stack is empty.");

        stack.peek();
    }

    @Test
    public void stackShouldImplementFILO() {
        List<Integer> items = Arrays.asList(random.nextInt(), random.nextInt(), random.nextInt());

        for (int item: items) {
            stack.push(item);

            assertEquals(item, stack.peek());
        }

        List<Integer> reversedItems = new ArrayList<>(items);
        Collections.reverse(reversedItems);

        for (int item: reversedItems) {
            assertEquals(item, stack.peek());

            stack.pop();
        }
    }

    abstract protected Stack getStack();
}

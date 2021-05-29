/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.stack;

import java.util.ArrayList;

/**
 *
 * @author djoshi
 */
public class SetOfStacks {

    ArrayList<MyStack> stacks = new ArrayList<MyStack>();
    int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public MyStack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    void push(int v) {
        MyStack last = getLastStack();

        if (last != null && !last.isEmpty()) { // add to last stack
            last.push(v);
        } else {
            MyStack stack = new MyStack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    int pop() {
        MyStack last = getLastStack();
        int v = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    boolean isEmpty() {
        MyStack last = getLastStack();
        return last == null || last.isEmpty();
    }

    int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        MyStack stack = stacks.get(index);
        int removed_item;

        if (removeTop) {
            removed_item = stack.pop();
        } else {
            removed_item = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }

        return removed_item;
    }
}

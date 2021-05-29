/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

/**
 *
 * @author djoshi
 */
public class ArrayQueue {

    int front, rear, size;
    int array[];

    public ArrayQueue(int size) {
        rear = front = 0;
        array = new int[size];
    }

    private boolean isFull() {
        return ((size - 1) == rear);
    }

    private boolean isEmpty() {
        return (size == 0);
    }

    private void enqueue(int item) {
        if (isFull()) {
            return;
        }
        array[rear++] = item;
        size++;
        System.out.println(item + " enqueued to queue");
    }

    private int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int item = array[front++];
        size--;
        return item;
    }

    public static void main(String args[]) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front);
        System.out.println("Rear item is " + queue.rear);

    }
}

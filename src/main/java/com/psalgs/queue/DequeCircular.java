/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/implementation-deque-using-circular-array/
 *
 * Implementation of Deque ( Double ended queue ) using circular array
 *
 * Note: In Double ended queue( deque) insertion and deletion operation can be
 * done from both ends rear and front;
 *
 */
public class DequeCircular {

    static final int MAX = 1000;
    int arr[];
    int front;
    int rear;
    int size;

    public DequeCircular(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    private boolean isFull() {
        return ((front == 0 && rear == size - 1)
                || (front == rear + 1));
    }

    private boolean isEmpty() {
        return (front == -1);
    }

    private void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow");
        }

        // If queue is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            // front is at first position of queue
            // means queue is full then re-init front
            front = size - 1;
        } else {
            // decrement front end by '1'
            front--;
        }
        // insert current element into front of Deque
        arr[front] = key;
    }

    private void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow");
        }

        // If queue is initially empty
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            // rear is at last position of queue
            // means queue is full and will be re-init
            rear = 0;
        } else {
            // increment rear end by '1'
            rear++;
        }

        // insert current element into Deque
        arr[rear] = key;
    }

    private void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            // if deque empty from front end, then reset it back
            // back to initial position
            front = 0;
        } else {
            // increment front by 1 to remove current
            // front value from Deque
            front = front + 1;
        }
    }

    private void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        // Deque has only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            // if deque is empty from rear end, reset it back
            rear = size - 1;
        } else {
            rear = rear - 1;
        }

    }

    // Returns front element of Deque
    private int getFront() {
        // check whether Deque is empty or not
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }

    // function return rear element of Deque
    private int getRear() {
        // check whether Deque is empty or not
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    public static void main(String args[]) {
        DequeCircular dq = new DequeCircular(5);
        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : " + dq.getRear());

        dq.deleteRear();
        System.out.println("After delete rear element new rear become : " + dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);

        System.out.println("get front element: " + dq.getFront());

        dq.deleteFront();

        System.out.println("After delete front element new front become : " + dq.getFront());
    }

}

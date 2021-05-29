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
 * http://www.geeksforgeeks.org/queue-set-2-linked-list-implementation/
 * 
 * Linked List implementation of queue
 */
public class ListQueue {

    static class QNode {

        int data;
        QNode next;

        QNode(int d) {
            data = d;
            next = null;
        }
    }

    QNode front, rear;

    private ListQueue() {
        front = rear = null;
    }

    private void enqueue(int d) {
        QNode temp = new QNode(d);

        // If queue is empty, then new node is front and rear both
        if (rear == null) {
            front = rear = temp;
        }

        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
    }

    private QNode dequeue() {
        // If queue is empty, return NULL.
        if (front == null) {
            return null;
        }

        // Store previous front and move front one node ahead
        QNode temp = front;
        front = front.next;
        temp.next = null;
        
        if (front == null) {
            rear = null;
        }

        return temp;
    }

    public static void main(String args[]) {
        ListQueue q = new ListQueue();
        q.enqueue(10);
        q.enqueue(20);
//        q.dequeue();
//        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Dequeued item is " + q.dequeue().data);
    }

}

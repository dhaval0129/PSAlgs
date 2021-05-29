/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/?p=5009
 *
 * Implement Queue using Stack ( one stack and function call stack )
 * or you can also use two stacks and implement queue
 * 
 * Note : It can also be done using two stacks
 *
 */
public class QImplStack {

    static class Queue {

        Stack<Integer> stack1;
    }

    private static void push(Stack<Integer> top_ref, int new_data) {
        top_ref.push(new_data);
    }

    private static int pop(Stack<Integer> top_ref) {
        if (top_ref == null) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        return top_ref.pop();
    }

    private static void enQueue(Queue q, int x) {
        push(q.stack1, x);
    }

    private static int deQueue(Queue q) {
        
        int x, res = 0;
        /* If the stacks is empty then error */
        if (q.stack1.isEmpty()) {
            System.out.println("Queue is Empty");
            System.exit(0);
        } else if(q.stack1.size() == 1) {
            return pop(q.stack1);
        } else {
            // Use function call stack to reach first element of queue
            // then push elements back to stack
            /* pop an item from the stack1 */
            x = pop(q.stack1);
            /* store the last dequeued item */
            res = deQueue(q);
            /* push everything back to stack1 */
            push(q.stack1, x);
            return res;
        }
       
        
        
        return 0;
    }

    public static void main(String args[]) {
        /* Create a queue with items 1 2 3*/
        Queue q = new Queue();
        q.stack1 = new Stack<>();

        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);

        /* Dequeue items */
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
    }
}

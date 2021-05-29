/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/write-a-c-function-to-detect-loop-in-a-linked-list/
 * 
 * Floyd's Cycle Finding Algorithm
 * 
 */
public class DetectLoop {
    
    class Node {
        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    Node head;
    
    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }
    
    private boolean detectLoop() {
        Node slow = head, fast = head;
        boolean cycle = false;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow.data == fast.data) {
                cycle = true;
                break;
            }
        }
        
        return cycle;
    }
    
    public static void main(String args[]) {
        DetectLoop llist = new DetectLoop();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);
         
        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
 
        System.out.println("Is there loop: "+llist.detectLoop()); 
    }
    
}

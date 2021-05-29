/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.list;

/**
 *
 * @author djoshi
 * 
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 
 */
public class FindKthElement {
   
    static class Node {
        int data;
        Node next;
        
        Node(int d) {
            this.data = d;
            next = null;
        }
    }
    
    static Node head;
    
    private static void findKthElement(int k) {
        Node curr = head;
        int count = 1;
        
        while(curr != null) {
            if(count == k) {
                System.out.print("Element at "+ k +" location is " +curr.data);
                break;
            }
            count++;
            curr = curr.next;
        }
    }
    
    public static void main(String args[]) {
        head = new Node(10);
        head.next = new Node(9);
        head.next.next = new Node(8);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.next.next = new Node(1);
        
        findKthElement(4);
    }
}

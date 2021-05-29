/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.list;

import java.util.HashMap;

/**
 *
 * @author djoshi
 * 
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * 1] First sort the list ( n log n) quick sort or merge sort
 * 2] Then scan prev and next values in node, if they match remove prev or next nodes
 * 
 */
public class RemoveDuplicate {
   
    static class Node {
        int data;
        Node next;
        
        Node(int d) {
            this.data = d;
            next = null;
        }
    }
    
    static Node head;
    
    private static void removeDuplicates() {
        HashMap<Integer,Integer> hm = new HashMap();
        
        Node curr = head.next;
        Node prev = head;
        
        while(curr != null) {
            if(hm.containsKey(curr.data)) {
                prev.next = curr.next;
            } else {
                hm.put(curr.data, 1);
                prev = curr;
            }
            curr = curr.next;
        }
    }
    
    private static void printList() {
        Node node = head;
        
        while(node != null) {
            if(node.next != null)
                System.out.print(node.data + "->");
            else 
                System.out.print(node.data);
            node = node.next;
        }
        System.out.println("\n");
    }
    
    public static void main(String args[]) {
        head = new Node(4);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next.next.next.next = new Node(8);
        
        printList();
        removeDuplicates();
        printList();
    }
}

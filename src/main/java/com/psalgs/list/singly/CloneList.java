/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 * 
 * 
 */
class Node {

    int data; //Node data
    Node next, random; //Next and random reference

    //Node constructor
    public Node(int data) {
        this.data = data;
        this.next = this.random = null;
    }
}

public class CloneList {

    Node head; //Linked list head reference

    CloneList(Node head) {
        this.head = head;
    }

    // push method to put data always at the head
    // in the linked list.
    void push(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    // Method to print the list.
    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            Node random = temp.random;
            int randomData = (random != null) ? random.data : -1;
            System.out.println("Data = " + temp.data + ", Random data = " + randomData);
            temp = temp.next;
        }
    }

    @Override
    public CloneList clone() {
        // Initialize two references, one with original
        // list's head.
        Node origCurr = this.head, cloneCurr = null;

        // Hash map which contains node to node mapping of
        // original and clone linked list.
        Map<Node, Node> map = new HashMap<>();
        
        // Traverse the original list and make a copy of that
        // in the clone linked list.
        while (origCurr != null) {
            cloneCurr = new Node(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        // Adjusting the original list reference again.
        origCurr = this.head;
        
        // Traversal of original list again to adjust the next
        // and random references of clone list using hash map.
        while (origCurr != null) {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
        
        //return the head reference of the clone list.
        return new CloneList(map.get(this.head));
    }
}

class Main {

    public static void main(String[] args) {
        // Pushing data in the linked list.
        CloneList list = new CloneList(new Node(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;
        list.head.next.next.random = list.head.next.next.next.next;
        list.head.next.next.next.random = list.head.next.next.next.next.next;
        list.head.next.next.next.next.random = list.head.next;

        // Making a clone of the original linked list.
        CloneList clone = list.clone();

        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print(list.head);
        System.out.println("\nCloned linked list");
        clone.print(clone.head);
    }
}

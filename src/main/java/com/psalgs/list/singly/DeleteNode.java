/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 */
public class DeleteNode {

    Node head; // head of the list

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Given a reference to the head of a list and an int,
        inserts a new Node on the front of the list. */
    public void push(int new_data) {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }
    
    // Here we are creating another node with same value as next node
    // And pointing head node to next pointer of next node
    private void deleteNode(Node node) {
        Node temp = node.next; // copy next location node to temp node
        node.data = temp.data; // copy next location data to temp node
        node.next = temp.next; // point delete node location to next location of next node
        temp = null;
    }

    /* This function prints contents of linked list 
        starting from the given Node */
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteNode llist = new DeleteNode();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        System.out.println("Before deleting");
        llist.printList();

        /* I m deleting the head itself.
        You can check for more cases */
        llist.deleteNode(llist.head);

        System.out.println("\nAfter Deleting");
        llist.printList();
    }

}

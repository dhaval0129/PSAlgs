/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 *
 * Sorted Linked List to Balanced BST
 *
 * Time Complexity O(n)
 */
public class LISTtoBBST {

    static class LNode {

        int data;
        LNode next, prev;

        LNode(int d) {
            data = d;
            next = prev = null;
        }
    }

    static class TNode {

        int data;
        TNode left, right;

        TNode(int d) {
            data = d;
            left = right = null;
        }
    }

    TNode root;
    LNode head;

    private void push(int d) {
        LNode node = new LNode(d);
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    private void printList(LNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private void preOrder(TNode node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.print(node.data + " ");
        preOrder(node.right);
    }

    private int countNodes(LNode head) {
        int count = 0;
        LNode temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    private TNode sortedListToBST() {
        /*Count the number of nodes in Linked List */
        int n = countNodes(head);
        /* Construct BST */
        return sortedListToBSTRecur(n);
    }

    private TNode sortedListToBSTRecur(int n) {
        // base case
        if (n <= 0) {
            return null;
        }

        /* Recursively construct the left subtree */
        TNode left = sortedListToBSTRecur(n / 2);

        /* head_ref now refers to middle node, 
           make middle node as root of BST*/
        TNode node = new TNode(head.data);

        node.left = left;
        head = head.next;

        /* Recursively construct the right subtree and link it 
           with root. The number of nodes in right subtree  is 
           total nodes - nodes in left subtree - 1 (for root) */
        
        // division has higher precedence so it will evaluated first
        node.right = sortedListToBSTRecur(n - n / 2 - 1);
        return node;
    }

    public static void main(String args[]) {
        LISTtoBBST llist = new LISTtoBBST();
        /* Let us create a sorted linked list to test the functions
           Created linked list will be 1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList(llist.head);

        /* Convert List to BST */
        TNode root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
        System.out.println();
    }
}

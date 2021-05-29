/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.construct;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 * 
 * Construct Complete Binary Tree from its Linked List Representation
 * 
 * Build Complete BT
 */
public class CBTFromList {

    // A linked list node
    static class LNode {

        int data;
        LNode next;

        LNode(int d) {
            data = d;
            next = null;
        }
    }

    static class TNode {

        int data;
        TNode left;
        TNode right;

        TNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static LNode head;
    static TNode root;

    private void push(int d) {
        LNode node = new LNode(d);
        node.next = head;
        head = node;
    }

    private void inOrderTraversal(TNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
    
    private TNode convertList2BT(TNode node) {
        // Create Queue of type tree
        Queue<TNode> q = new LinkedList<>();
        
        //base case
        if(head == null) {
            return null;
        }
        
        node = new TNode(head.data);
        q.add(node);
        
        head = head.next;
        
        while(head != null) {
            TNode curr = q.poll();
            
            TNode left = null;
            TNode right = null;
            
            left = new TNode(head.data);
            q.add(left);
            head = head.next;
            
            if(head != null) {
                right = new TNode(head.data);
                q.add(right);
                head = head.next;
            }
            
            curr.left = left;
            curr.right = right;
        }
        
        return node;
    }

    public static void main(String args[]) {
        CBTFromList list = new CBTFromList();
        CBTFromList tree = new CBTFromList();
        list.push(36);
        list.push(30);
        list.push(25);
        list.push(15);
        list.push(12);
        list.push(10);
        
        tree.root = list.convertList2BT(list.root);
        System.out.println("Inorder Traversal of the constructed Binary Tree is:");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 * 
 * Insertion in a Binary Tree in level order
 * 
 * https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * 
 */
public class InsertNode_LOT {
    
    static class Node {
        int key;
        Node left, right;
        
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    
    static Node root;
    
    private static void printInorder(Node node) {
        if(node == null) {
            return;
        }
        
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
    
    private static void add(int key) {
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            Node temp = q.remove();
            
            if(temp.left != null) {
              q.add(temp.left);
            } else {
               temp.left = new Node(key);
               break;
            }
            
            if(temp.right != null) {
                q.add(temp.right);
            } else {
                temp.right = new Node(key);
                break;
            }
            
        }
    }
    
    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
       
        printInorder(root);
        System.out.println();
        add(12);
        System.out.println();
        printInorder(root);
        
    }
}

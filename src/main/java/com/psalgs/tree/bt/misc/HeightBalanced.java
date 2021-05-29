/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 * 
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * 
 * Determine if a binary tree is height-balanced
 * 
 */
public class HeightBalanced {
    
    static class Node {
        int key;
        Node left, right;
        
        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }
    
    static Node root;
    
  
    
    private int height(Node node) {
        
        if(node == null) {
            return 0;
        }
        
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static void main(String args[]) {
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.left.left.left = new Node(8); 
        
    }
}

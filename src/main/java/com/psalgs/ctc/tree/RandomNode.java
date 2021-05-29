/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.tree;

/**
 *
 * @author djoshi
 *
 * You are implementing a binary tree class from scratch which, in addition to
 * insert, find, and delete, has a method getRandomNode() which returns a random
 * node from the tree. All nodes should be equally likely to be chosen. 
 * 
 * Design and implement an algorithm for getRandomNode, and explain how you would
 * implement the rest of the methods.
 *
 * https://www.geeksforgeeks.org/select-random-node-tree-equal-probability/
 * 
 * https://github.com/Turingfly/cracking-the-coding-interview/blob/master/src/chapter04TreesAndGraphs/RandomNode.java
 * 
 */
public class RandomNode {
    
    static class Node {
        int data;
        Node left, right;
        
        Node(int data) {
            this.data = data;
            left = right;
        }
    }

    static Node root;
    
   
    
    public static void main(String args[]) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);
        root.left.left = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        
    }
}

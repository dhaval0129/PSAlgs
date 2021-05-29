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
 * http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
 * 
 * Find the closest leaf in a Binary Tree
 * 
 * 
 */
public class ClosestLeaf {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

 
    public static void main(String args[]) {
        ClosestLeaf tree = new ClosestLeaf();
        tree.root = new tNode('A');
        tree.root.left = new tNode('B');
        tree.root.right = new tNode('C');
        tree.root.right.left = new tNode('E');
        tree.root.right.right = new tNode('F');
        tree.root.right.left.left = new tNode('G');
        tree.root.right.left.left.left = new tNode('I');
        tree.root.right.left.left.right = new tNode('J');
        tree.root.right.right.right = new tNode('H');
        tree.root.right.right.right.left = new tNode('H');


    }

}

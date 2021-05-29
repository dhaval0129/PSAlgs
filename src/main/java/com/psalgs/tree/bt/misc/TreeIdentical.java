/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 */
public class TreeIdentical {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }
    
    tNode root1, root2;
    
    private boolean identicalTrees(tNode a, tNode b) {
        if(a == null && b == null) {
            return true;
        }
        
        if( a != null && b != null) {
            return (a.data == b.data 
                    && identicalTrees(a.left,b.left)
                    && identicalTrees(a.right,b.right));
        }
        
        return false;
    }
    
    public static void main(String args[]) {
        TreeIdentical tree = new TreeIdentical();
        tree.root1 = new tNode(1);
        tree.root1.left = new tNode(2);
        tree.root1.right = new tNode(3);
        tree.root1.left.left = new tNode(4);
        tree.root1.left.right = new tNode(5);
        
        tree.root2 = new tNode(1);
        tree.root2.left = new tNode(2);
        tree.root2.right = new tNode(3);
        tree.root2.left.left = new tNode(4);
        tree.root2.left.right = new tNode(5);
        
        System.out.println("Trees Identical: "
            + tree.identicalTrees(tree.root1, tree.root2));
        
        
    }

}

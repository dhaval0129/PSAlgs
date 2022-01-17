package com.psalgs.tree.bt.misc;

/**
 * 
 * https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
 * 
 * @author djoshi
 *
 */
public class SymmetricTree {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	/**
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private boolean isMirror(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		return (node1 != null && node2 != null 
				&& node1.data == node2.data 
				&& isMirror(node1.left, node2.right)
				&& isMirror(node1.right, node2.left)
			);
	}

	/**
	 * 
	 * @return
	 */
	private boolean isSymmetric() {
		return isMirror(root, root);
	}

	static Node root;

	public static void main(String args[]) {
		SymmetricTree tree = new SymmetricTree();
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

		boolean output = tree.isSymmetric();
		if (output == true) {
			System.out.println("Symmetric");
		} else {
			System.out.println("Not symmetric");
		}
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.right = new Node(3);
		root.right.right = new Node(3);
		
		output = tree.isSymmetric();
		if (output == true) {
			System.out.println("Symmetric");
		} else {
			System.out.println("Not symmetric");
		}
	}

}

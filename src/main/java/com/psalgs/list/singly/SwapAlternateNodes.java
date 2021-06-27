package com.psalgs.list.singly;

// Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
// Output: 1 -> 7 -> 3 -> 6 -> 5 -> 4 -> 2 -> 8


//class Node {
//	int data;
//	Node next;
//	
//	Node(int d) {
//		data = d;
//		next = null;
//	}
//}

public class SwapAlternateNodes {
	
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	private void swapAltNodes(Node node) {
		
		int length = 0;
		while(node != null) {
			node = node.next;
			length++;
		}
		
		node = head;
		int currCnt = 1;
		int revCurrCnt = length;
		Node prev = null;
		while(currCnt < revCurrCnt) {
			if(currCnt % 2 == 0) {
				
				int fwdCount = currCnt;
				
				Node fwdPrev = null;
				Node fwdCurr = node;
				while(fwdCount < revCurrCnt) {
					fwdPrev = fwdCurr;
					fwdCurr = fwdCurr.next;
					fwdCount++;
				}
				swap(prev, fwdPrev, node, fwdCurr);
				//System.out.println(fwdCurr.data + " " +node.data);
				node = fwdCurr;
			}
			currCnt++;
			revCurrCnt--;
			prev = node;
			//System.out.println(node.data);
			node = node.next;
		}
	}
	
	private void swap(Node p1, Node p2, Node n1, Node n2) {
//		Node temp = n1.next;
//		p1.next = n2;
//		p2.next = n1;
//		n1.next = n2.next;
//		n2.next = temp;
		
		Node temp = p1.next;
		p1.next = p2.next;
		p2.next = temp;
		temp = n1.next;
		n1.next = n2.next;
		n2.next = temp;
		
	}
	
	private void printList() {
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		SwapAlternateNodes llist = new SwapAlternateNodes();
		llist.head = new Node(1);
		llist.head.next = new Node(2);
		llist.head.next.next = new Node(3);
		llist.head.next.next.next = new Node(4);
		llist.head.next.next.next.next = new Node(5);
		llist.head.next.next.next.next.next = new Node(6);
		llist.head.next.next.next.next.next.next = new Node(7);
		llist.head.next.next.next.next.next.next.next = new Node(8);
		llist.head.next.next.next.next.next.next.next.next = new Node(9);
		llist.head.next.next.next.next.next.next.next.next.next = new Node(10);
        
		llist.printList();
		llist.swapAltNodes(llist.head);
		llist.printList();
	}

}

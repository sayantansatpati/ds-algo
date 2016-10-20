package com.sayantan.java.misc.problems;

import com.sayantan.java.misc.ds.LinkedList;
import com.sayantan.java.misc.ds.LinkedList.Node;

public class MergeKSortedLinkedLists {

	public static LinkedList merge(LinkedList l1, LinkedList l2) {
        if(l1 == null && l2 != null) {
        	return l2;
        }

        if(l1 != null && l2 == null) {
            return l1;
        }

        //Both c1 & c2 != null

        Node c1 = l1.head;
        Node c2 = l2.head;

        LinkedList l = new LinkedList();
        Node c3 = null; // Head of Merged LinkedList

        while(c1 != null & c2 != null) {
            if(c1.iData < c2.iData) {
                if(c3 == null) {
                    l.insertFirst(c1.iData);
                    c3 = l.head;
                } else {
                	Node node = new Node(c1.iData);
                    c3.next = node;
                    c3 = c3.next;
                }
                //Increment Pointers
                c1 = c1.next;
            } else {
            	if(c3 == null) {
                    l.insertFirst(c2.iData);
                    c3 = l.head;
                } else {
                	Node node = new Node(c2.iData);
                    c3.next = node;
                    c3 = c3.next;
                }
                //Increment Pointers
                c2 = c2.next;
            }
        	l.displayList();
        }

        while(c1 != null) {
        	Node node = new Node(c1.iData);
            c3.next = node;
            c1 = c1.next;
            c3 = c3.next;
            l.displayList();
        }

        while(c2 != null) {
        	Node node = new Node(c2.iData);
            c3.next = node;
            c2 = c2.next;
            c3 = c3.next;
            l.displayList();
        }

        return l;
	}



	public static void main(String args[]) {
		LinkedList l1 = new LinkedList();
		l1.insertFirst(50);
		l1.insertFirst(30);
		l1.insertFirst(10);

		LinkedList l2 = new LinkedList();
		l2.insertFirst(70);
		l2.insertFirst(60);
		l2.insertFirst(40);
		l2.insertFirst(20);
		l2.insertFirst(10);

		l1.displayList();
		l2.displayList();

		//merge(l1,l2);

		int[] a = {5,15,25};
		LinkedList l3 = new LinkedList();
		l3.addArrayToList(a);
		l3.displayList();
		int[] a1 = {25,26,35,45};
		LinkedList l4 = new LinkedList();
		l4.addArrayToList(a1);
		l4.displayList();

		System.out.println("###");

		LinkedList[] kLists = {l1,l2,l3,l4};
		LinkedList l = null;
		for(int k=0; k < kLists.length; k++) {
			l = merge(l,kLists[k]);
		}
		l.displayList();
	}
}

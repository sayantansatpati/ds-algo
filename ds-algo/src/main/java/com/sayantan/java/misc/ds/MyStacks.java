package com.sayantan.java.misc.ds;

import java.util.Arrays;

public class MyStacks {

	static class StackList {
		String[] items  = null;
		int top = -1;

		public StackList(int maxSize) {
			items = new String[maxSize];
		}

		public void push(String item) {
			if(!isFull()) {
				items[++top] = item;
			} else {
				throw new IllegalAccessError("Stack is full!!!");
			}
		}

		public String pop() {
			if(top >= 0) {
				System.out.println("[POP]: "+ items[top]);
				return items[top--];
			} else {
				throw new IllegalAccessError("Stack is empty!!!");
			}
		}

		public String peek() {
			if(top >= 0) {
				System.out.println("[PEEK]: "+ items[top]);
				return items[top];
			} else {
				throw new IllegalAccessError("Stack is empty!!!");
			}
		}

		public boolean isFull() {
			return this.top == items.length - 1;
		}

		public void display() {
			System.out.println(Arrays.toString(items));
		}
	}

	static class StackLinkedList {

		private Node head;

		public void push(String item) {
			Node node = new Node(item);
			node.next = head;
			head = node;
		}

		public String peek() {
			if(head == null) {
				throw new IllegalAccessError("Stack is empty!!!");
			}
			System.out.println("[PEEK]: "+ head.iData);
			return head.iData;
		}

		public String pop() {
			if(head == null) {
				throw new IllegalAccessError("Stack is empty!!!");
			}
			Node tmp = head;
			System.out.println("[POP]: "+ tmp.iData);
			head = head.next;
			return tmp.iData;
		}

		static class Node {
			String iData;
			Node next;

			public Node(String data) {
				this.iData = data;
			}

			public void display() {
				System.out.println("Data: " + iData);
			}
		}

		public void display() {
			StringBuilder sb = new StringBuilder();
			Node current = head;
			int cnt = 0;
			while(current != null) {
				cnt++;
				if(cnt > 1) {
					sb.append(" --> ");
				}
				sb.append(current.iData);
				current = current.next;
			}
			System.out.println(sb.toString());
		}

	}

	public static void main(String args[]) {
		StackList s1 = new StackList(3);
		//s1.pop();
		s1.push("a");
		s1.push("b");
		s1.push("c");
		s1.peek();
		//s1.push("d");
		s1.pop();
		s1.push("d");
		s1.peek();
		s1.display();

		StackLinkedList s2 = new StackLinkedList();
		s2.push("A");
		s2.push("B");
		s2.push("C");
		s2.push("D");
		s2.display();
		s2.peek();
		s2.pop();
		s2.display();

	}
}

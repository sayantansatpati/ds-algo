package com.sayantan.java.ctci.chp03;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

public class Question31<T> {

	int[] top = null;
	StackNode<T>[] buffer = null;

	Queue<Integer> freeSlots = new LinkedBlockingQueue<Integer>();

	@SuppressWarnings("unchecked")
	public Question31(int numStacks, int sizeOfEach) {
		// Init top index to -1
		top = new int[numStacks];
		for(int i=0; i < top.length; i++) {
			top[i] = -1;
		}

		// Init free slots / index from buffer
		for(int i=0; i < numStacks * sizeOfEach; i++) {
			freeSlots.add(i);
		}

		// Init Buffer
		buffer = new StackNode[numStacks * sizeOfEach];
	}

	public void push(int stack, T item) {
		if(freeSlots.isEmpty()) {
			throw new IllegalAccessError("Stack is full!!!");
		}
		// Get free slot from array
		int index = freeSlots.remove();
		System.out.println(String.format("[PUSH] stack: %d, prev index: %d,curr index: %d",
											stack, top[stack], index));

		// Create a stack node
		StackNode<T> node = new StackNode<T>(top[stack], item);
		// Add node to array
		buffer[index] = node;
		// Add top
		top[stack] = index;
	}

	public T pop(int stack) {
		if(top[stack] == -1) {
			throw new IllegalAccessError("Stack is empty!!!");
		}

		// Get top
		int index = top[stack];
		// Pop from stack
		StackNode<T> node = buffer[index];
		// Set new top
		top[stack] = node.previous;
		// Add index to freeSlots
		freeSlots.add(index);

		System.out.println(String.format("[POP] stack: %d, top: %d, new top: %d, value: %d",
				stack, index, top[stack], node.value));

		return node.value;
	}

	public T peek(int stack) {
		if(top[stack] == -1) {
			throw new IllegalAccessError("Stack is empty!!!");
		}
		return buffer[top[stack]].value;
	}

	static class StackNode<T> {
		 public int previous;
		 public T value;
		 public StackNode(int p, T v){
			 value = v;
			 previous = p;
		}
	}

	public int getRandomInteger(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}

	public static void main(String args[]) {
		int NUM_STACKS = 3;
		int CAPACITY = 100;
		Question31<Integer> sol = new Question31<Integer>(NUM_STACKS, CAPACITY);

		for(int i=0; i < CAPACITY; i++) {
			for(int j=0; j < NUM_STACKS; j++) {
				sol.push(j, (j+1)*100 + i);
			}
		}

		for(int i=0; i < CAPACITY; i++) {
			for(int j=0; j < NUM_STACKS; j++) {
				sol.pop(j);
			}
		}

	}

}

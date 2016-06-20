package com.sayantan.java.misc.sort;

import java.util.Arrays;

public class MergeSortTest1 {

	static int[] a1 = {2,7,9,13,20,25,32};
	static int[] a2 = {1,9,11,12};

	public static void merge1() {
		int i = 0;
		int j = 0;
		int k = 0;
		int a3[] = new int[a1.length + a2.length];

		while( k < a3.length) {
			System.out.println(String.format("[i=%d][j=%d][k=%d]", i, j, k));

			if(i < a1.length && j < a2.length) {
				if(a1[i] < a2[j]) {
					a3[k++] = a1[i++];
				} else {
					a3[k++] = a2[j++];
				}
			} else if(i < a1.length) {
				a3[k++] = a1[i++];
			} else if(j < a2.length) {
				a3[k++] = a2[j++];
			}
		}

		System.out.println(Arrays.toString(a3));
	}

	public static void main(String args[]) {
		merge1();
	}

}

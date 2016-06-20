package com.sayantan.java.misc.sort;

import java.util.Arrays;

public class MergeSortTest {

	static int[] a1 = new int[]{2,7,9,13,20,25,32};
	static int[] a2 = new int[]{1,9,11,12};

	public static void merge1(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while(j < a1.length && k < a2.length) {
			System.out.println(String.format("[%d][%d][%d]", i, j, k));
			if(a1[j] < a2[k]) {
				a3[i++] = a1[j++];
			} else if( a1[j] > a2[k] ) {
				a3[i++] = a2[k++];
			} else {
				a3[i++] = a1[j++];
				a3[i++] = a2[k++];
			}
		}

		if( j < a1.length) { // Smaller Array
			while(i < a3.length) {
				a3[i++] = a1[j++];
			}

		} else {
			while(i < a3.length) {
				a3[i++] = a2[k++];
			}
		}

		System.out.println(Arrays.toString(a3));
	}

	public static void merge2(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while(i < a3.length) { //O(n)
			System.out.println(String.format("[%d][%d][%d]", i, j, k));
			if( j < a1.length && k < a2.length ) {
				if(a1[j] < a2[k]) {
					a3[i++] = a1[j++];
				} else if( a1[j] > a2[k] ) {
					a3[i++] = a2[k++];
				} else {
					a3[i++] = a1[j++];
					a3[i++] = a2[k++];
				}
			} else if( j < a1.length ) {
				a3[i++] = a1[j++];
			} else {
				a3[i++] = a2[k++];
			}
		}

		System.out.println(Arrays.toString(a3));
	}

	public static void mergeSort(int[] a1, int[] a2) {

	}


	public static void main(String[] args) {
		merge2(a1, a2);
	}

}

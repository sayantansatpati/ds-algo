package com.sayantan.java.misc.sort;

import java.util.Arrays;

public class BubbleSelectionInsertionSort {

	public static void selectionSort(int[] ua) {
		System.out.println("@@@ [selectionSort] Original: " + Arrays.toString(ua));
		for( int i=0; i < ua.length; i++ ) {
			int minIdx = i;
			for( int j=i+1; j < ua.length; j++ ) {
				if( ua[j] < ua[minIdx] ) {
					swap(ua, j, minIdx);
				}
			}
			ua[i] = ua[minIdx];
			System.out.println(Arrays.toString(ua));
		}
		System.out.println("@@@ [selectionSort] Final: " + Arrays.toString(ua));

	}

	public static void selectionSort1(int[] ua) {
		System.out.println("@@@ [selectionSort-1] Original: " + Arrays.toString(ua));
		for( int i=0; i < ua.length; i++ ) {
			int minIdx = i;
			for( int j=i+1; j < ua.length; j++ ) {
				if( ua[j] < ua[minIdx] ) {
					minIdx = j;
				}
			}
			int tmp = ua[i];
			ua[i] = ua[minIdx];
			ua[minIdx] = tmp;
			System.out.println(Arrays.toString(ua));
		}
		System.out.println("@@@ [selectionSort-1] Final: " + Arrays.toString(ua));

	}


	/**
	 * O(n*2) Complexity
	 * @param ua: Unsorted Array
	 */
	public static void insertionSort(int[] ua) {
		System.out.println("@@@ [insertionSort] Original: " + Arrays.toString(ua));
		for( int i=1; i < ua.length; i++ ) {
			for( int j=i; j > 0; j-- ) {
				if( ua[j] < ua[j-1] ) {
					swap(ua, j, j-1);
				}
			}
			System.out.println(Arrays.toString(ua));
		}
		System.out.println("@@@ [insertionSort] Final: " + Arrays.toString(ua));
	}

	private static void swap(int[] ua, int i, int j) {
		int tmp = ua[i];
		ua[i] = ua[j];
		ua[j] = tmp;
	}

	public static void main(String[] args) {
		int[] UA = new int[] {32, 21, 6, 8, 8, 0, 45, 53, 25, 56, 24};
		insertionSort(UA);

		UA = new int[] {32, 21, 6, 8, 8, 0, 45, 53, 25, 56, 24};
		selectionSort1(UA);
	}

}

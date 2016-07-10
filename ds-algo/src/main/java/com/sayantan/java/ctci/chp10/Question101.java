package com.sayantan.java.ctci.chp10;

import java.util.Arrays;

public class Question101 {

	public static void sortmerge(int[] a1, int[] a2) {
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));

		//Get index of last element in a1
		int i = a1.length - 1;
		while(a1[i] == 0) {
			i--;
		}
		System.out.println(i);
		int j = a2.length - 1;
		int k = a1.length - 1;

		while(i >= 0 && j>= 0) {
			if(a1[i] >= a2[j]) {
				a1[k--] = a1[i--];
			} else {
				a1[k--] = a2[j--];
			}
		}

		while(i >= 0) {
			a1[k--] = a1[i--];
		}

		while(j >= 0) {
			a1[k--] = a2[j--];
		}

		System.out.println(Arrays.toString(a1));

		//At this point k is pointing to the index before the start of the first valid element in a1
		//Pull up elements & pad on right by zeroes
		int l = 0;
		k++;
		while(l < a1.length) {
			if(k < a1.length) {
				a1[l++] = a1[k++];
			} else {
				a1[l++] = 0;
			}
		}

		System.out.println(Arrays.toString(a1));
	}

	public static void main(String[] args) {
		int[] a1 = new int[12];
		a1[0] = 3;
		a1[1] = 5;
		a1[2] = 7;
		a1[3] = 9;

		int[] a2 = {1,2,4,6,8};

		sortmerge(a1,a2);
	}

}

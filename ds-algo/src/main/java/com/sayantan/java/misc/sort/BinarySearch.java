package com.sayantan.java.misc.sort;

public class BinarySearch {
	
	public static int binarySearch(int[] a, int x) {
		int idx = -1;
		
		int l = 0;
		int u = a.length - 1;
		
		while(l <= u) {
			int m = (l+u)/2;
			System.out.println(String.format("[%d][%d][%d]", l, m, u));
			if( x == a[m] ) {
				return m;
			} else if ( x < a[m] ) {
				u = m -1;
			} else {
				l = m + 1;
			}
		}
		
		return idx;
	}
	
	
	public static void main(String[] args) {
		int[] UA = new int[] {2, 4, 6, 8, 10, 11, 15, 22, 26, 31, 43, 56, 44};
		System.out.println(binarySearch(UA, 31));
	}

}

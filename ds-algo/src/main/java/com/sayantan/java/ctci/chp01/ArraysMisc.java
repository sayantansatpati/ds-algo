package com.sayantan.java.ctci.chp01;

import java.util.HashMap;
import java.util.Map;


public class ArraysMisc {

	private ArraysMisc() {}

	static Map<Long, Long> fibMemo = new HashMap<Long, Long>();

	public static void intersectionOfSortedArrays() {
		int[] a1 = {21, 22, 34, 35, 41};
		int[] a2 = {6, 9, 11, 21, 34, 45, 61};

		int i = 0;
		int j = 0;

		while(i < a1.length && j < a2.length) {
			if(a1[i] < a2[j]) {
				i++;
			} else if(a1[i] > a2[j]) {
				j++;
			} else {
				System.out.println(a1[i]);
				i++;
				j++;
			}
		}
	}

	public static long fibonacci(int n) {
		System.out.println(n);
		if(n == 0 || n == 1) {
			return n;
		}
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}

	public static long fibonacci_optimized(int n) {
		if(n == 0 || n == 1) {
			return n;
		}

		int a = 0;
		int b = 1;
		int fib = 0;
		for(int i=2; i <=n; i++) {
			fib = a + b;
			a = b;
			b = fib;
		}
		return fib;
	}

	public static long fibonacci_dp(long n) {
		System.out.println(n);
		if(n == 0 || n == 1) {
			return n;
		}

		if(fibMemo.containsKey(n)) {
			return fibMemo.get(n);
		}

		long fib =  fibonacci_dp(n-1) + fibonacci_dp(n-2);
		fibMemo.put(n, fib);
		return fib;
	}

	public static String reverse(String s) {
		System.out.println(s);
		if(s.length() < 2) {
			return s;
		}
		return reverse(s.substring(1)) + s.charAt(0);
	}


	public static void main(String args[]) {
		intersectionOfSortedArrays();
		System.out.println("=====");
		System.out.println("### " + fibonacci(10));
		System.out.println("=====");
		System.out.println("### " + fibonacci_dp(10));
		System.out.println("=====");
		System.out.println("### " + fibonacci_optimized(10));
		System.out.println("=====");
		System.out.println(reverse("samsung"));
	}

}

package com.sayantan.java.misc.ds;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Recursion {

	public static int[] arr = {1,2,3,4,5,6,7,8,9};

	/*
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);
	}
	*/

	public static String padLeft(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n;i++) {
			sb.append(" ");
		}
	    return sb.append(s).toString();
	}

	public static void divide_conquer(int[] arr,int l, int u, int level) {
		String str = String.format("[%d] %d - %d",level, l,u);
		//String str = "[" + level + "]" + l + "-" + u;
		System.out.println(padLeft(str, level));
		if(l >= u) {
			str = String.format("[%d] RETURN",level);
			System.out.println(padLeft(str, level));
			return;
		}

		int m = (l + u) / 2;

		str = String.format("[%d] L",level);
		System.out.println(padLeft(str, level));
		divide_conquer(arr, l, m, level + 1);

		str = String.format("[%d] R",level);
		System.out.println(padLeft(str, level));
		divide_conquer(arr, m+1, u, level + 1);
	}


	public static void main(String[] args) throws Exception {
		divide_conquer(arr, 0, arr.length, 1);

	}
}

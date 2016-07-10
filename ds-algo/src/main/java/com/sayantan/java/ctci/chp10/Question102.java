package com.sayantan.java.ctci.chp10;

import java.util.Arrays;

public class Question102 {

	static String[] ARR = {"aabc","baac", "cbaa", "xyz", "aabbcc", "adef", "agizx"};

	public static void main(String args[]) {
		for(int i=0; i < ARR.length; i++) {
			char[] c = ARR[i].toCharArray();
			Arrays.sort(c);
			ARR[i] = new String(c);
		}
		Arrays.sort(ARR);
		System.out.println(Arrays.toString(ARR));
	}

}

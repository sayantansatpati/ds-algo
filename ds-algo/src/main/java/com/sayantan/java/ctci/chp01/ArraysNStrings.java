package com.sayantan.java.ctci.chp01;

public class ArraysNStrings {

	public ArraysNStrings() {

	}

	public static boolean hasUniqueChars(String str1) {
		// Check if the string is ASCII
		int[] chars = new int[128];
		for(int i=0; i < str1.length(); i++) {
			int c = str1.charAt(i);
			if(chars[c] > 0) {
				System.out.println("[hasUniqueChars] Not Unique Chars: " + str1 + " --> " + (char)c);
				return false;
			} else {
				chars[c]++;
			}
		}
		System.out.println("[hasUniqueChars] Unique Chars: " + str1);
		return true;
	}

	public static boolean isPermutation(String str1, String str2) {
		/*
		 * Possible approaches
		 * 1) Store in HashMap & then compare keys & values
		 * 2) Sort both string and do a string equals
		 * 3) Store char counts of first string in an array & then compare 2nd string
		 *
		 */

		if (str1 == null || str2 == null) {
			return false;
		}

		if (str1.length() != str1.length()) {
			return false;
		}

		int[] chars = new int[128];
		for(int i=0; i < str1.length(); i++) {
			int c = str1.charAt(i);
			chars[c]++;
		}

		for(int i=0; i < str2.length(); i++) {
			int c = str2.charAt(i);
			// If count goes below zero
			if(--chars[c] < 0 ) {
				System.out.println("[hasUniqueChars] FALSE: " + (char)c);
				return false;
			}
		}
		System.out.println("[hasUniqueChars] TRUE");
		return true;
	}

	public static void main(String args[]) {
		ArraysNStrings.hasUniqueChars("abcdef");
		ArraysNStrings.hasUniqueChars("sayantan");

		ArraysNStrings.isPermutation("abcdef", "fedcba");
		ArraysNStrings.isPermutation("aab", "abb");
		ArraysNStrings.isPermutation("aab", "ab");
	}

}

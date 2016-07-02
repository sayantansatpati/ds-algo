package com.sayantan.java.moocs;

public class Karatsuba {

	public static double mul(int x, int y) {
		System.out.println(String.format("[MUL] %d * %d", x, y));
		String x_s = String.valueOf(x);
		String y_s = String.valueOf(y);
		int l1 = x_s.length();
		int l2 = y_s.length();
		if(l1 == 1 && l2 == 1 ) {
			return x * y;
		}

		int m1 = (l1+1)/2;
		int a = Integer.parseInt(x_s.substring(0, m1));
		int b = Integer.parseInt(x_s.substring(m1, l1));
		System.out.println(String.format("a - %d, b - %d", a, b));

		int m2 = (l1+1)/2;
		int c = Integer.parseInt(y_s.substring(0, m2));
		int d = Integer.parseInt(y_s.substring(m2, l2));
		System.out.println(String.format("c - %d, d - %d", c, d));

		System.out.println("---");

		return Math.pow(10, l1) * mul(a,c) + Math.pow(10, m1) * (mul(a,d) + mul(b,c)) + mul(b,d);
	}

	public static void main(String[] args) {
		int x = 1234;
		int y = 5678;

		double result = mul(x,y);

		System.out.println(result);
	}

}

package com.sayantan.java.moocs;

public class Matrices {

	static int[][] x = {{1,2},
				{3,4},
				{5,6},
				{7,8}};

	static int[][] y = {{1,2,3},
			     {4,5,6}};


	//Brute Force: N^3
	public static int[][] mul() {

		int r = x.length;
		int c = y[0].length;
		int[][] res = new int[r][c];

		for(int i=0; i < r;i++) { //For each row of x
			for(int j=0; j < c; j++) { //For each col of y
				int value = 0;
				for(int k=0; k < x[i].length; k++) { //Left & Down
					value += x[i][k] * y[k][j];
					//System.out.println(String.format("%d,%d - %d", i,j,value));
				}
				res[i][j] = value;
			}

		}

		return res;
	}

	public static void display(int[][] m) {
		for(int i=0; i < m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				System.out.println(String.format("%d,%d - %d", i,j,m[i][j]));
			}
		}
	}


	public static void main(String[] args) {
		display(mul());

	}
}

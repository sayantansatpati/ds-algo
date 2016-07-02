package com.sayantan.java.moocs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayInversion {

	private ArrayInversion() {}

	private static long INVERSIONS = 0;

	public static void mergesort(int[] arr, int[] workspace, int l, int u) {
		System.out.println(String.format("[MERGESORT] %d, %d", l, u));
		if(l >= u) {
			return;
		}
		int m = (l+u)/2;
		mergesort(arr, workspace, l, m);
		mergesort(arr, workspace, m+1, u);
		merge(arr, workspace, l, m+1, u);
	}

	public static void merge(int[] arr, int[] workspace, int l, int m, int u) {
		int i = l;
		int j = m;
		int k = l;

		while(k <= u) {
			System.out.println(String.format("\n[MERGE] %d, %d, %d", l, m, u));

			if((i <= m-1) && (j <= u)) {
				if(arr[i] < arr[j]) {
					workspace[k++] = arr[i++];
				} else {
					INVERSIONS = INVERSIONS + (m-i);
					workspace[k++] = arr[j++];
				}
			}else if(i <= m-1) {
				workspace[k++] = arr[i++];
			} else if(j <= u) {
				workspace[k++] = arr[j++];
			}
		}

		//Copy to original
		for(i=l; i<=u; i++) {
			arr[i] = workspace[i];
		}

		//System.out.println(Arrays.toString(arr));
	}

	public static int[] merge(int[] a1, int[] a2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int a3[] = new int[a1.length + a2.length];

		while( k < a3.length) {
			System.out.println(String.format("[MERGE][i=%d][j=%d][k=%d]", i, j, k));

			if(i < a1.length && j < a2.length) {
				if(a1[i] < a2[j]) {
					a3[k++] = a1[i++];
				} else {
					a3[k++] = a2[j++];
				}
			} else if(i < a1.length) {
				a3[k++] = a1[i++];
			} else if(j < a2.length) {
				a3[k++] = a2[j++];
			}
		}

		//System.out.println(Arrays.toString(a3));
		return a3;
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 3, 5};
		int[] workspace = new int[arr.length];

		mergesort(arr, workspace, 0, workspace.length - 1);
		System.out.println("# Array Inversions: " + INVERSIONS);

		List<Integer> list = new ArrayList<Integer>();
		try (Stream<String> stream = Files.lines(
				Paths.get("/Users/ssatpati/Downloads/_bcb5c6658381416d19b01bfc1d3993b5_IntegerArray.txt"))) {

			//1. filter line 3
			//2. convert all content to upper case
			//3. convert it into a List
			list = stream
					//.filter(line -> !line.startsWith("line3"))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		//list.forEach(System.out::println);

		arr = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			arr[i] = list.get(i);
		}

		// Reset
		INVERSIONS = 0;
		workspace = new int[arr.length];

		mergesort(arr, workspace, 0, workspace.length - 1);
		System.out.println("# Array Inversions: " + INVERSIONS);

	}

}

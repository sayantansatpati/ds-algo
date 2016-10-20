package com.sayantan.java.moocs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

	public static long NUM_COMPARIONS = 0; //No of Comparisons

	public static void quicksort(int[] ARR, int l, int u) {
		if(l >= u) {
			return;
		}
		NUM_COMPARIONS += u - l; //Length of Array - 1 (Pivot)
		int p = partition1x(ARR, l, u);
		quicksort(ARR, l, p-1); //Less than p
		quicksort(ARR, p+1, u); //Greater than p
	}

	public static int quicksort2(int[] ARR, int l, int u) {
		if(l >= u) {
			return 0;
		}
		int num_comparisons = u - l;
		int p = partition1xxx(ARR, l, u);
		return num_comparisons + quicksort2(ARR, l, p-1) + quicksort2(ARR, p+1, u);
	}

	/**
	 * Pivot -> 1st Element
	 * @param ARR
	 * @param l
	 * @param u
	 * @return
	 */
	public static int partition1x(int[] ARR, int l, int u) {
		int PIV_IDX = l;
		int pivot = ARR[PIV_IDX];

		int i = PIV_IDX + 1; //Partition Boundary or Leftmost element > Pivot.
		int j = PIV_IDX + 1;

		for(;j <= u; j++) {
			if(ARR[j] < pivot) {
				swap(ARR, i, j);
				i++;
			}
			//System.out.println(String.format("%d-%d: %s", i,j, Arrays.toString(ARR)));
		}

		//Swap the Pivot
		swap(ARR, PIV_IDX, i-1);
		//System.out.println(Arrays.toString(ARR));
		return i-1; // Return Partition Index
	}

	/**
	 * Pivot -> Last Element
	 * @param ARR
	 * @param l
	 * @param u
	 * @return
	 */
	public static int partition1xx(int[] ARR, int l, int u) {
		swap(ARR, l, u);
		int PIV_IDX = l;
		int pivot = ARR[PIV_IDX];

		int i = PIV_IDX + 1; //Partition Boundary or Leftmost element > Pivot.
		int j = PIV_IDX + 1;

		for(;j <= u; j++) {
			if(ARR[j] < pivot) {
				swap(ARR, i, j);
				i++;
			}
			//System.out.println(String.format("%d-%d: %s", i,j, Arrays.toString(ARR)));
		}

		//Swap the Pivot
		swap(ARR, PIV_IDX, i-1);
		//System.out.println(Arrays.toString(ARR));
		return i-1; // Return Partition Index
	}

	/**
	 * Pivot -> Median of 1st, last, and middle element
	 * @param ARR
	 * @param l
	 * @param u
	 * @return
	 */
	public static int partition1xxx(int[] ARR, int l, int u) {
		//int PIV_IDX = getPivotIndex_1(ARR,l,u);
		int PIV_IDX = getRandomPivotIndex(l,u);

		if(PIV_IDX != l) {
			swap(ARR, l, PIV_IDX);
			PIV_IDX = l;
		}

		int pivot = ARR[PIV_IDX];

		int i = PIV_IDX + 1; //Partition Boundary or Leftmost element > Pivot.
		int j = PIV_IDX + 1;

		for(;j <= u; j++) {
			if(ARR[j] < pivot) {
				swap(ARR, i, j);
				i++;
			}
			//System.out.println(String.format("%d-%d: %s", i,j, Arrays.toString(ARR)));
		}

		//Swap the Pivot
		swap(ARR, PIV_IDX, i-1);
		//System.out.println(Arrays.toString(ARR));
		return i-1; // Return Partition Index
	}

	public static int getPivotIndex(int[] ARR, int l, int u) {
		if(u - l == 1) { //Special Case
			if(ARR[l] < ARR[u]) {
				return l;
			} else {
				return u;
			}
		}
		int half = (u - l + 1) / 2;
		int m = ARR[l];
		if(half % 2 == 0) {
			m = l + (half - 1);
		} else {
			m = l + half;
		}
		//Sort & Find Median
		SortedMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		treeMap.put(ARR[l], l);
		treeMap.put(ARR[m], m);
		treeMap.put(ARR[u], u);

		int cnt = 0;
		int PIV_IDX = l;
		for(Entry<Integer, Integer> e: treeMap.entrySet()) {
			cnt++;
			if(cnt == 2) {
				PIV_IDX = e.getValue();
				break;
			}
		}
		System.out.println(String.format("[%d] Pivot Idx: [%d] # [%d] %d : [%d] %d : [%d] %d",
										(u-l),PIV_IDX,
										l,ARR[l],
										m,ARR[m],
										u,ARR[u]));
		return PIV_IDX;
	}

	public static int getPivotIndex_1(int[] ARR, int l, int u) {
		int m = (u + l) / 2;
		//Sort & Find Median
		SortedMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		treeMap.put(ARR[l], l);
		treeMap.put(ARR[m], m);
		treeMap.put(ARR[u], u);

		int cnt = 0;
		int PIV_IDX = l;
		for(Entry<Integer, Integer> e: treeMap.entrySet()) {
			cnt++;
			if(cnt == 2) {
				PIV_IDX = e.getValue();
				break;
			}
		}
		System.out.println(String.format("[%d] Pivot Idx: [%d] # [%d] %d : [%d] %d : [%d] %d",
										(u-l),PIV_IDX,
										l,ARR[l],
										m,ARR[m],
										u,ARR[u]));
		return PIV_IDX;
	}

	public static int getRandomPivotIndex(int l, int u) {
		Random rand = new Random();
		return rand.nextInt((u - l) + 1) + l;
	}

	/*
	 * 2 ways to do partition
	 */


	/**
	 * 2 pointers one at the beg & other at the end of the array
	 */
	public static void partition2(int[] ARR) {
		int PIV_IDX = 0;
		int pivot = ARR[PIV_IDX];

		int l = PIV_IDX + 1;
		int r = ARR.length - 1;

		while(l <= r) {
			while(ARR[l] <= pivot) {
				l++;
			}
			while(ARR[r] > pivot) {
				r--;
			}

			if(l > r) {
				break;
			}

			swap(ARR, l, r);
			System.out.println(String.format("%d-%d: %s", l,r, Arrays.toString(ARR)));

			//Increment
			//l++;r--;
		}
		swap(ARR, PIV_IDX, l-1);
		System.out.println(String.format("%d-%d: %s", l,r, Arrays.toString(ARR)));
	}

	/**
	 * 2 pointers both start at the index next to pivot.
	 */
	public static void partition1(int[] ARR) {
		int PIV_IDX = 0;
		int pivot = ARR[PIV_IDX];

		int i = PIV_IDX + 1; //Partition Boundary or Leftmost element > Pivot.
		int j = PIV_IDX + 1;

		for(;j < ARR.length; j++) {
			if(ARR[j] < pivot) {
				swap(ARR, i, j);
				i++;
			}
			System.out.println(String.format("%d-%d: %s", i,j, Arrays.toString(ARR)));
		}

		//Swap the Pivot
		swap(ARR, PIV_IDX, i-1);
		System.out.println(Arrays.toString(ARR));
	}

	public static void swap(int[] ARR, int i, int j) {
		try {
			System.out.println(String.format("Swapping: %d and %d", ARR[i], ARR[j]));
			int tmp  = ARR[i];
			ARR[i] = ARR[j];
			ARR[j] = tmp;
		} catch(Throwable t) {
			System.out.println(String.format("Error Swapping Index: %d and %d", i, j));
		}
	}

	public static int[] readInput() {
		List<Integer> list = new ArrayList<Integer>();
		try (Stream<String> stream = Files.lines(
				Paths.get("src/main/resources/QuickSort.txt"))) {

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

		int[] arr = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		int[] ARR = {3,8,2,5,1,4,7,6};
		int[] ARR_1 = {6,2,8,4,9,1};
		partition1(ARR_1);

		System.exit(1);

		int[] ARR1 = {3,8,2,5,1,4,7,6};
		System.out.println("========");
		//partition2(ARR1);

		System.out.println("========");
		int[] ARR2 = {3,8,2,5,1,4,7,6};
		//quicksort(ARR2, 0, ARR2.length - 1);
		System.out.println("Number of Comparisons: " + NUM_COMPARIONS);

		System.out.println("========");
		NUM_COMPARIONS = 0; //Reset
		int[]ARR3 = readInput();
		//quicksort(ARR3, 0, ARR3.length - 1);
		//System.out.println("Number of Comparisons: " + NUM_COMPARIONS);
		System.out.println("Number of Comparisons: " + quicksort2(ARR3, 0, ARR3.length - 1));
		System.out.println(Arrays.toString(ARR3));

		System.out.println("========");
	}

}

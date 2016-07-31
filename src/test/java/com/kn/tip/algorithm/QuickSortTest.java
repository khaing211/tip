package com.kn.tip.algorithm;

import org.junit.Test;

import com.kn.tip.algorithm.QuickSort;

public class QuickSortTest {
	@Test
	public void test() {
		QuickSort.quickSort(new int[] {5, 8, 1, 3, 7, 9, 2}, 0, 6);
	}
}

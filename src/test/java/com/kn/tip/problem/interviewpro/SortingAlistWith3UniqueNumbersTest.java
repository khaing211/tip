package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class SortingAlistWith3UniqueNumbersTest {
  @Test
  public void testSort() {
    final SortingAlistWith3UniqueNumbers sorter = new SortingAlistWith3UniqueNumbers();
    Assert.assertArrayEquals(new int[] {}, sorter.sort(new int[] {}));
    Assert.assertArrayEquals(new int[] {1, 1, 2, 2, 3, 3, 3}, sorter.sort(new int[] {3, 3, 2, 1, 3, 2, 1}));
  }
}

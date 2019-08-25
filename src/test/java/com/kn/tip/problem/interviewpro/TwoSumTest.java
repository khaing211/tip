package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
  @Test
  public void testTwoSum() {
    final TwoSum twoSum = new TwoSum();
    Assert.assertTrue(twoSum.isTwoSum(new int[] {4, 7, 1 , -3, 2}, 5));
    Assert.assertFalse(twoSum.isTwoSum(new int[] {4, 7, 1 , -3, 2}, 2));
  }
}

package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class MinimumSizeSubarraySumTest {
  @Test
  public void testMinimumSizeSubarraySum() {
    Assert.assertEquals(2, MinimumSizeSubarraySum.size(new int[]{2,3,1,2,4,3}, 7));
    Assert.assertEquals(0, MinimumSizeSubarraySum.size(new int[]{2,3,1,2,4,3}, 100));
    Assert.assertEquals(1, MinimumSizeSubarraySum.size(new int[]{2,3,1,2,4,3}, 1));
    Assert.assertEquals(1, MinimumSizeSubarraySum.size(new int[]{2,1,3,2,4,3}, 3));
    Assert.assertEquals(0, MinimumSizeSubarraySum.size(new int[]{1}, 3));
  }
}

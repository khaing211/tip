package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfWaysToClimbStairsTest {
  @Test
  public void testCompute() {
    final NumberOfWaysToClimbStairs solution = new NumberOfWaysToClimbStairs();
    Assert.assertEquals(5, solution.compute(4));
    Assert.assertEquals(8, solution.compute(5));
  }
}

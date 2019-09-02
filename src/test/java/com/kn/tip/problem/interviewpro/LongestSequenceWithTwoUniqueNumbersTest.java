package com.kn.tip.problem.interviewpro;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class LongestSequenceWithTwoUniqueNumbersTest {
  @Test
  public void testSize() {
    final LongestSequenceWithTwoUniqueNumbers solution = new LongestSequenceWithTwoUniqueNumbers();
    Assert.assertEquals(4, solution.size(Arrays.asList(1, 3, 5, 3, 1, 3, 1, 5)));
    Assert.assertEquals(6, solution.size(Arrays.asList(1, 1, 1, 1, 1, 1)));
    Assert.assertEquals(8, solution.size(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2)));
    Assert.assertEquals(13, solution.size(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2)));
  }
}

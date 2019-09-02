package com.kn.tip.problem.interviewpro;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class FindPythagoreanTripletsTest {
  @Test
  public void testFind() {
    final FindPythagoreanTriplets solution = new FindPythagoreanTriplets();
    Assert.assertFalse(solution.find(Arrays.asList()));
    Assert.assertTrue(solution.find(Arrays.asList(5, 3, 12, 13)));
    Assert.assertTrue(solution.find(Arrays.asList(5, 13, 12, 3)));
    Assert.assertTrue(solution.find(Arrays.asList(5, 13, 12, 3, 5, 5)));
  }
}

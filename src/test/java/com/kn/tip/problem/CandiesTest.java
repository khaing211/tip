package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.Candies;

import static org.junit.Assert.assertEquals;

public class CandiesTest {
  @Test
  public void test() {
    assertEquals(4, Candies.compute(new int[] {1, 2, 2}));
  }


}

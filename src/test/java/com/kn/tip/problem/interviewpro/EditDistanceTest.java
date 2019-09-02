package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTest {
  @Test
  public void testEditDistance() {
    final EditDistance solution = new EditDistance();
    Assert.assertEquals(2, solution.distance("biting", "sitting"));
    Assert.assertEquals(2, solution.distance("sitting", "biting"));
  }
}

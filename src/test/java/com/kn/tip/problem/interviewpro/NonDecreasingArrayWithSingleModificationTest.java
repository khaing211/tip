package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class NonDecreasingArrayWithSingleModificationTest {
  @Test
  public void testNonDecreasingArrayWithSingleModification() {
    final NonDecreasingArrayWithSingleModification problem = new NonDecreasingArrayWithSingleModification();
    Assert.assertTrue(problem.isAbleToMakeSingleModification(new int[] {13, 4, 7}));
    Assert.assertFalse(problem.isAbleToMakeSingleModification(new int[] {13, 4, 1}));
  }
}

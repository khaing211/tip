package com.kn.tip.problem.interviewpro;

import org.junit.Test;

import junit.framework.Assert;

public class FindNonDuplicateNumberTest {
  @Test
  public void testFind() {
    final FindNonDuplicateNumber finder = new FindNonDuplicateNumber();
    Assert.assertEquals(0, finder.find(new int[]{0, 1, 1}));
    Assert.assertEquals(5, finder.find(new int[]{2, 5, 2}));
  }
}

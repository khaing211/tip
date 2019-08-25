package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalidromeSubstringTest {
  @Test
  public void testLongestPalidromeSubstring() {
    final LongestPalidromeSubstring finder = new LongestPalidromeSubstring();

    Assert.assertEquals("anana", finder.find("banana"));
    Assert.assertEquals("illi", finder.find("million"));
    Assert.assertEquals("illi", finder.find("abdmillion"));
    Assert.assertEquals("baab", finder.find("baab"));
  }
}

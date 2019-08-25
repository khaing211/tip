package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
  @Test
  public void testFind() {
    final LongestSubstringWithoutRepeatingCharacters problem = new LongestSubstringWithoutRepeatingCharacters();
    Assert.assertEquals("abcdefghij", problem.find("abrkaabcdefghijjxxx"));
  }
}

package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {
  @Test
  public void testSearch() {
    final char[][] matrix = new char[][] {
      {'F', 'A', 'C', 'I'},
      {'O', 'B', 'Q', 'P'},
      {'A', 'N', 'O', 'B'},
      {'M', 'A', 'S', 'S'}
    };

    Assert.assertTrue(WordSearch.search(matrix, ""));
    Assert.assertTrue(WordSearch.search(matrix, "FOAM"));
    Assert.assertTrue(WordSearch.search(matrix, "OAM"));
    Assert.assertTrue(WordSearch.search(matrix, "BQP"));
    Assert.assertFalse(WordSearch.search(matrix, "BPQ"));
  }
}

package com.kn.tip.problem.interviewpro;

import java.util.Stack;

/**
 * You are given a 2D array of characters, and a target string. Return whether or not the word
 * target word exists in the matrix. Unlike a standard word search, the word must be either going
 * left-to-right, or top-to-bottom in the matrix.
 *
 * matrix = [ ['F', 'A', 'C', 'I'], ['O', 'B', 'Q', 'P'], ['A', 'N', 'O', 'B'], ['M', 'A', 'S',
 * 'S']]
 *
 * word_search(matrix, 'FOAM'): true
 */
public class WordSearch {
  // Run at O(n * n * m) where n is the dimension and m is the length of the String
  // and constant space
  public static boolean search(final char[][] matrix, final String lookup) {
    if (lookup.isEmpty()) {
      return true;
    }

    final Stack<Index> stack = new Stack<>();
    // we can also limit the upper bound here
    // by String length
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == lookup.charAt(0)) {
          stack.add(new Index(i, j, 0, Index.LEFT_TO_RIGHT));
          stack.add(new Index(i, j, 0, Index.UP_TO_DOWN));
        }
      }
    }

    // is there a need for this fancy stack loop?
    // not really, could be another inner loop above
    while (!stack.isEmpty()) {
      final Index index = stack.pop();
      final Index newIndex = index.inDirection();

      if (newIndex.k == lookup.length()) {
        return true;
      }
      if (newIndex.i == matrix.length || newIndex.j == matrix[newIndex.i].length) {
        continue;
      }

      if (matrix[newIndex.i][newIndex.j] == lookup.charAt(newIndex.k)) {
        stack.add(newIndex);
      }
    }

    return false;
  }

  private static class Index {
    public static final int[] UP_TO_DOWN = new int[] {1, 0};
    public static final int[] LEFT_TO_RIGHT = new int[] {0, 1};
    // i, j = index of matrix
    // k = index of the String
    final int i, j, k;
    final int[] direction;

    public Index(final int i, final int j, final int k, final int[] direction) {
      this.i = i;
      this.j = j;
      this.k = k;
      this.direction = direction;
    }

    public Index inDirection() {
      return new Index(i + direction[0], j + direction[1], k + 1, direction);
    }
  }
}

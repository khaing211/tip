package com.kn.tip.problem.interviewpro;

/**
 * Given two strings, determine the edit distance between them. The edit distance is defined as the
 * minimum number of edits (insertion, deletion, or substitution) needed to change one string to the
 * other.
 *
 * For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a
 * t).
 */
public class EditDistance {
  public int distance(final String lhs, final String rhs) {
    // store the edit distance between two substrings: lhs[0, i) and rhs[0, j)
    final int[][] matrix = new int[lhs.length() + 1][rhs.length() + 1];
    for (int i = 0; i <= lhs.length(); i++) {
      matrix[i][0] = i;
    }
    for (int j = 0; j <= rhs.length(); j++) {
      matrix[0][j] = j;
    }

    for (int i = 1; i <= lhs.length(); i++) {
      for (int j = 1; j <= rhs.length(); j++) {
        if (lhs.charAt(i-1) == rhs.charAt(j-1)) {
          matrix[i][j] = matrix[i-1][j-1];
        } else {
          matrix[i][j] = Math.min(matrix[i-1][j-1] + 1, Math.min(matrix[i-1][j] + 1, matrix[i][j-1] + 1));
        }
      }
    }

    return matrix[lhs.length()][rhs.length()];
  }
}

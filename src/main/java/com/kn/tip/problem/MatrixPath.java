package com.kn.tip.problem;

/**
 * For any given matrix find the path from the start to the end which gives the maximum sum. 
 * Traverse only right or down.
 * Example: starting index is 15 (left top) and ending index is 10 (bottom right)
 * 
 * Solution: this is a longest path is acylic graph
 * 
 * Example Input:
 * 15 25 30
 * 45 25 60
 * 70 75 10
 * 
 * Example output:
 * 15->45->70->75->10 sum is 215
 */
public interface MatrixPath {
  // return max sum
  // to return the path, you just need to create a trace matrix
  static int findPath(final int[][] matrix, final int n, final int m) {
    final int[][] sumMatrix = new int[n][m];
    
    sumMatrix[0][0] = matrix[0][0];
    // calculate all sum in row 0
    for (int i = 1; i < m; i++) {
      sumMatrix[0][i] = sumMatrix[0][i-1] + matrix[0][i];
    }

    // calculate all sum in col 0
    for (int i = 1; i < n; i++) {
      sumMatrix[i][0] = sumMatrix[i-1][0] + matrix[i][0];
    }
    
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        sumMatrix[i][j] = matrix[i][j] + Math.max(sumMatrix[i][j-1], sumMatrix[i-1][j]);
      }
    }
    
    return sumMatrix[n-1][m-1];
  }
}

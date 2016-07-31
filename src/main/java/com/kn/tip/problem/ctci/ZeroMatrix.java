package com.kn.tip.problem.ctci;

import com.kn.tip.print.PrettyPrintArray;

public class ZeroMatrix {
  public static void zeroOut(int[][] matrix) {
    final int n = matrix.length;
    final int m = matrix[0].length;
    
    final boolean[] rows = new boolean[n];
    final boolean[] cols = new boolean[m];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 0) {
            rows[i] = true;
            cols[j] = true;
          }
        }
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (rows[i]) {
          matrix[i][j] = 0;
        } else if (cols[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    int[][] matrix = {
        {1,2,1},
        {1,0,1},
        {3,3,3}
    };
    
    zeroOut(matrix);
    
    PrettyPrintArray.print(matrix);
  }
}

package com.kn.tip.problem.ctci;

import com.kn.tip.print.PrettyPrintArray;

public class RotateMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2}, {4, 3}};

    rotate(matrix, 2);

    PrettyPrintArray.print(matrix);
    /////
    /*
     * int[][] matrix2 = { {1,2}, {4,3} };
     * 
     * rotate(matrix2, 1);
     * 
     * PrettyPrintArray.print(matrix2);
     */
    /////
    /*
     * int[][] matrix3 = { {1,2,3}, {8,1,4}, {7,6,5}, };
     * 
     * rotate(matrix3, 3);
     * 
     * PrettyPrintArray.print(matrix3);
     */
    int[][] matrix4 = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};

    rotate(matrix4, 4);

    PrettyPrintArray.print(matrix4);
  }

  public static void rotate(int[][] matrix, int n) {
    int m = n / 2;

    for (int i = 0; i < m; i++) {
      rotate(matrix, i, n - (i * 2));
    }
  }

  public static void rotate(int[][] matrix, final int k, final int n) {
    // System.out.println("rotate: " + k + " " + n);
    for (int i = 0; i < n - 1; i++) {
      swap(matrix, k, k + i, k + i, k + n - 1);
      swap(matrix, k + i, k + n - 1, k + n - 1, k + n - 1 - i);
      swap(matrix, k + n - 1, k + n - 1 - i, k + n - 1 - i, k);
    }
  }

  public static void swap(int[][] matrix, int fromR, int fromC, int toR, int toC) {
    // System.out.println("swap: " + fromR + " " + fromC + " " + toR + " " + toC);

    int tmp = matrix[fromR][fromC];
    matrix[fromR][fromC] = matrix[toR][toC];
    matrix[toR][toC] = tmp;
  }
}

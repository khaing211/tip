package com.kn.tip.problem;

public class SubsetSum {
  public static void main(String[] args) {
    System.out.println(isSubsetSum(new int[]{9, 1, 0}, 10));
    System.out.println(isSubsetSum(new int[]{9, 1, 0}, 8));
    System.out.println(isSubsetSum(new int[]{9}, 0));
    
    System.out.println("=================");
    System.out.println(isSubsetDP(new int[]{9, 1, 0}, 10));
    System.out.println(isSubsetDP(new int[]{9, 1, 0}, 8));
    System.out.println(isSubsetDP(new int[]{9}, 0));
  }
  
  // check array have non-contiguous subset sum up to a given value
  // can array have the negative integer? no
  public static boolean isSubsetSum(int[] array, int sum) {
    return isSubsetSum(array, array.length, sum);
  }
  
  public static boolean isSubsetSum(int[] array, int len, int sum) {
    if (sum == 0) {
      return true;
    }
    
    if (len == 0) {
      return false;
    }
    
    int lastElement = array[len-1];
    if (lastElement > sum) {
      return isSubsetSum(array, len-1, sum);
    } else {
      return isSubsetSum(array, len-1, sum-lastElement) || isSubsetSum(array, len-1, sum);
    }
  }
  
  public static boolean isSubsetDP(int[] array, int sum) {
    int n = array.length;
    // The value of subset[j][i] will be true if there is a subset of array[0..i-1]
    //  with sum equal to j
    boolean[][] table = new boolean[sum+1][n+1];
    
    // sum can be zero for any subset 
    for (int i = 0; i <= n; i++) {
      table[0][i] = true;
    }
    
    // no sum for empty set except for zero sum
    for (int j = 1; j <= sum; j++) {
      table[j][0] = false;
    }
    
    for (int j = 1; j <= sum; j++) {
      for (int i = 1; i <= n; i++) {
        // for current set, sum of smaller subset carry over
        table[j][i] = table[j][i-1];
        
        // if j is not smaller than current
        if (j >= array[i-1]) {
          table[j][i] = table[j][i] || table[j - array[i-1]][i-1];
        }
      }
    }
    
    /*
    for (int j = 0; j <= sum; j++) {
      for (int i = 0; i <= n; i++) {
        // for current set, sum of smaller subset carry over
        System.out.print(table[j][i] ? 'X' : 'O');
        System.out.print(' ');
      }
      System.out.println();
    }
    */
    
    return table[sum][n];
  }
}

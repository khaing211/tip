package com.kn.tip.problem.ctci;

// A child is running up a stair with n steps
// can hop either 1, 2, or 3 steps at a time
// how many possible ways can the child run up the stair
public class TripleStep {
  public static void main(String[] args) {
    System.out.println(countWayUpTheStair(3));
    System.out.println(countWayUpTheStair(4));
    System.out.println(countWayUpTheStair(10));
  }
  
  public static int countWayUpTheStair(int n) {
    int[] array = new int[n+1];
    // base case
    array[0] = 1; 
    array[1] = 1;
    
    for (int i = 2; i <= n; i++) {
      array[i] += array[i-1];
      array[i] += array[i-2];
      if (i >= 3) {
        array[i] += array[i-3];
      }
    }
    
    return array[n];
  }
}

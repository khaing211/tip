package com.kn.tip.problem.ctci;

// count of number of 2s that appear in all numbers between 0 and n (inclusive)
// n = 25
// output: 9
public class CountOf2 {
  public static void main(String[] args) {
    System.out.println(countNaive(2));
    System.out.println(countNaive(20));
    System.out.println(countNaive(200));
    System.out.println(countNaive(2000));
  }
  
  
  // TODO: improve
  public static int countNaive(int n) {
    int sum = 0;
    for (int i = 2; i <= n; i++) {
      sum += count2InNumber(i);
    }
    return sum;
  }
  
  public static int count2InNumber(int x) {
    int count = 0;
    while (x != 0) {
      if (x % 10 == 2) {
        count++;
      }
      x /= 10;
    }
    return count;
  }
}

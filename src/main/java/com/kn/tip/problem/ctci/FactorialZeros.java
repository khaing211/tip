package com.kn.tip.problem.ctci;

public class FactorialZeros {
  public static void main(String[] args) {
    System.out.println(countTrailingZerosOfNFactorial(10));
    System.out.println(countTrailingZerosOfNFactorial(20));
  }
  
  public static int countTrailingZerosOfNFactorial(int n) {
    int numTwo = countX(n, 2);
    int numFive = countX(n, 5);
    
    // always more of 5 than of 2
    return numFive;
  }
  
  public static int countX(int n, int x) {
    int cnt = 0;
    for (int i = x; i <= n; i += x) {
      int j = i;
      while (j % x == 0) {
        cnt++;
        j /= x;
      }
    }
    return cnt;
  }
}

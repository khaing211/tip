package com.kn.tip.problem.ctci;

// count number of way to present n cents
// given unlimited, 25, 10, 5, 1
public class Coins {
  public static void main(String[] args) {
    System.out.println(count(25));
  }

  public static int count(int n) {
    return countChangeByQuarter(n);
  }

  public static int countChangeByQuarter(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i += 25) {
      sum += countChangeByDimes(n - i);
    }
    return sum;
  }

  public static int countChangeByDimes(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i += 10) {
      sum += countChangeByNickel(n - i);
    }
    return sum;
  }

  public static int countChangeByNickel(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i += 5) {
      sum += countChangeByPennies(n - i);
    }
    return sum;
  }

  public static int countChangeByPennies(int n) {
    return 1;
  }
}

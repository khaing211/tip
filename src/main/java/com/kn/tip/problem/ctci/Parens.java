package com.kn.tip.problem.ctci;

public class Parens {
  public static void main(String[] args) {
    printParensRecursive(3);

    printParensRecursive(4);
  }

  public static void printParensRecursive(int n) {
    printParensRecursive2(n, 0, 0, "");
  }

  public static void printParensRecursive2(int n, int openParens, int closeParens, String text) {
    if (openParens + closeParens > n) {
      return;
    }

    if (closeParens == n) {
      System.out.println(text);
    } else {
      printParensRecursive2(n, openParens + 1, closeParens, text + "(");
      // if you have open parens you can close them
      if (openParens > 0) {
        printParensRecursive2(n, openParens - 1, closeParens + 1, text + ")");
      }
    }
  }
}

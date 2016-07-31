package com.kn.tip.print;

import java.util.Arrays;

public interface PrettyPrintArray {
  static <T> void print(T[][] array) {
    Arrays.stream(array).forEachOrdered(it -> System.out.println(Arrays.toString(it)));
  }
  
  static <T> void print(int[][] array) {
    Arrays.stream(array).forEachOrdered(it -> System.out.println(Arrays.toString(it)));
  }
}

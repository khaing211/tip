package com.kn.tip.problem.codewars;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatStr {
  public static String repeat(final int repeat, final String copy) {
    return repeat < 0 ? null : IntStream.range(0, repeat).mapToObj(i -> copy).collect(Collectors.joining());
  }

  public static void main(final String[] args) {
    System.out.println(repeat(2, "ab"));
  }
}

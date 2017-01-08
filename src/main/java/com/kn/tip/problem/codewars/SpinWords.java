package com.kn.tip.problem.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {

  public String spinWords(final String sentence) {
    return Arrays.stream(sentence.split(" "))
      .map(s -> s.length() < 5 ? s : new StringBuilder(s).reverse().toString())
      .collect(Collectors.joining(" "));
  }
}

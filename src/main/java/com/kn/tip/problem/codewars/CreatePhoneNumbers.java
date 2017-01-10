package com.kn.tip.problem.codewars;

public class CreatePhoneNumbers {
  // most people uses String.format() or concat by '+'
  // Wonder how efficient to use StringBuilder with exact capacity.
  public static String createPhoneNumber(final int[] numbers) {
    return new StringBuilder(14)
      .append("(")
      .append(numbers[0])
      .append(numbers[1])
      .append(numbers[2])
      .append(") ")
      .append(numbers[3])
      .append(numbers[4])
      .append(numbers[5])
      .append("-")
      .append(numbers[6])
      .append(numbers[7])
      .append(numbers[8])
      .append(numbers[9])
      .toString();
  }
}

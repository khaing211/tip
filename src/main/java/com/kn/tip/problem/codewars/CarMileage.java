package com.kn.tip.problem.codewars;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CarMileage {
  // For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
  private static final String INCREASING = "1234567890";

  // For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.
  private static final String DECREASING = "9876543210";

  // Output
  private static final int NO = 0;
  private static final int ALMOST = 1;
  private static final int YES = 2;

  // Input will always be an integer greater than 0, and less than 1,000,000,000.
  // A number is only interesting if it is greater than 99!
  // The awesomePhrases array will always be provided, and will always be an array, but may be empty. (Not everyone thinks numbers spell funny words...)
  public static int isInteresting(final int number, final int[] awesomePhrases) {

    // find exact match
    if (number > 99 && isMatch(number, awesomePhrases)) {
        return YES;
    }

    final int[] upcomingNumbers = new int[] { number + 1, number + 2 };
    // find almost there match (within 2 miles)
    for (int i = 0; i < upcomingNumbers.length; i++) {
      if (isMatch(upcomingNumbers[i], awesomePhrases)) {
        return ALMOST;
      }
    }

    return NO;
  }

  private static boolean isMatch(final int number, final int[] awesomePhrases) {
    return isInAwesomePhrases(number, awesomePhrases)
        || havingSameDigit(number)
        || havingTrailingZeroes(number)
        || isIncreasingSequential(number)
        || isDecrementingSequential(number)
        || isPanlidrone(number);
  }

  private static boolean isInAwesomePhrases(final int number, final int[] awesomePhrases) {
    for (int i = 0; i < awesomePhrases.length; i++) {
      if (number == awesomePhrases[i]) {
        return true;
      }
    }
    return false;
  }

  private static boolean havingTrailingZeroes(int number) {
    while (number > 0) {
      final int lsb = number % 10;
      number = number / 10;
      if (lsb != 0 && number > 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean havingSameDigit(int number) {
    final int digit = number % 10;
    while (number > 0) {
      final int lsb = number % 10;
      number = number / 10;
      if (lsb != digit) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPanlidrone(final int number) {
    final String s = Integer.toString(number);
    return new StringBuilder(s).reverse().toString().equals(s);
  }

  private static boolean isIncreasingSequential(final int number) {
    return INCREASING.contains(Integer.toString(number));
  }

  private static boolean isDecrementingSequential(final int number) {
    return DECREASING.contains(Integer.toString(number));
  }

  public static void main(final String[] args) {
    // "boring" numbers
    System.out.println(CarMileage.isInteresting(3, new int[]{1337, 256}));    // 0
    System.out.println(CarMileage.isInteresting(3236, new int[]{1337, 256})); // 0

    // progress as we near an "interesting" number
    System.out.println(CarMileage.isInteresting(11207, new int[]{})); // 0
    System.out.println(CarMileage.isInteresting(11208, new int[]{})); // 0
    System.out.println(CarMileage.isInteresting(11209, new int[]{})); // 1
    System.out.println(CarMileage.isInteresting(11210, new int[]{})); // 1
    System.out.println(CarMileage.isInteresting(11211, new int[]{})); // 2

    // nearing a provided "awesome phrase"
    System.out.println(CarMileage.isInteresting(1335, new int[]{1337, 256})); // 1
    System.out.println(CarMileage.isInteresting(1336, new int[]{1337, 256})); // 1
    System.out.println(CarMileage.isInteresting(1337, new int[]{1337, 256})); // 2
  }

  // The other awesolution solution
  public static boolean isReallyInteresting(final int number, final int[] awesomePhrases) {
    return Stream.<Predicate<String>>of(
            s -> s.matches("\\d0+"),
            s -> new StringBuilder(s).reverse().toString().equals(s),
            s -> "1234567890".contains(s),
            s -> "9876543210".contains(s),
            s -> Arrays.stream(awesomePhrases).anyMatch(n -> parseInt(s) == n)
    ).anyMatch( p -> number > 99 && p.test(Integer.toString(number)));
  }

  public static int isInteresting2(final int number, final int[] awesomePhrases) {
    return isReallyInteresting(number, awesomePhrases) ? 2 :
           isReallyInteresting(number + 1, awesomePhrases) ? 1 :
           isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
  }
}

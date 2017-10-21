package com.kn.tip.problem.interviewbit;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 * G[i] for an element A[i] = an element A[j] such that
 *   j is maximum possible AND
 *   j < i AND
 *   A[j] < A[i]
 *
 * Example:
 * A: [4, 5, 2, 10, 8]
 * G: [-1, 4, -1, 2, 2]
 *
 * A: [3, 2, 1]
 * G: [-1, -1, -1]
 */
public class NearestSmallerElement {
  static int[] nearestSmallerElementInPlace(final int[] array) {
    // storing the increasing order index
    final Stack<Integer> increasingOrder = new Stack<>();

    for (int i = 0; i < array.length; i++) {
      //System.err.println(increasingOrder);
      final int element = array[i];
      while (!increasingOrder.isEmpty() && increasingOrder.peek() >= element) {
        increasingOrder.pop();
      }

      if (increasingOrder.isEmpty()) {
        array[i] = -1;
      } else {
        array[i] = increasingOrder.peek();
      }

      increasingOrder.add(element);
    }

    return array;
  }

  static int[] nearestSmallerElement(final int[] array) {
    // storing the increasing order index
    final Stack<Integer> increasingOrderIndices = new Stack<>();
    final int[] ret = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      //System.err.println(increasingOrderIndices);
      final int element = array[i];
      while (!increasingOrderIndices.isEmpty() && array[increasingOrderIndices.peek()] >= element) {
        increasingOrderIndices.pop();
      }

      if (increasingOrderIndices.isEmpty()) {
        ret[i] = -1;
      } else {
        ret[i] = array[increasingOrderIndices.peek()];
      }

      increasingOrderIndices.add(i);
    }

    return ret;
  }

  public static void main(final String[] args) {
    System.out.println(Arrays.toString(nearestSmallerElementInPlace(new int[] {4, 5, 2, 10, 8})));
    System.out.println(Arrays.toString(nearestSmallerElementInPlace(new int[] {4, 5, 6, 10, 8})));
    //System.out.println(Arrays.toString(nearestSmallerElement(new int[] {3, 2, 1})));
  }
}

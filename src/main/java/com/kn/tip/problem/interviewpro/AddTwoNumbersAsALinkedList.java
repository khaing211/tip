package com.kn.tip.problem.interviewpro;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two linked-lists representing two non-negative integers. The digits are stored in
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return it
 * as a linked list.
 *
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbersAsALinkedList {

  public List<Integer> add(final List<Integer> a, final List<Integer> b) {
    final Iterator<Integer> iterA = a.iterator();
    final Iterator<Integer> iterB = b.iterator();

    final List<Integer> result = new LinkedList<>();
    int carry = 0;
    while (iterA.hasNext() || iterB.hasNext()) {
      final int sum = safeGetNext(iterA) + safeGetNext(iterB) + carry;
      carry = sum / 10;
      final int adjustedSum = sum % 10;
      result.add(adjustedSum);
    }

    if (carry > 0) {
      result.add(carry);
    }

    return result;
  }

  private int safeGetNext(final Iterator<Integer> iter) {
    return iter.hasNext() ? iter.next() : 0;
  }
}

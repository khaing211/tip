package com.kn.tip.problem.hackerrank;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 */
public class FindMergePointInList {
  int FindMergeNode(final Node headA, final Node headB) {
    Node currentA = headA;
    Node currentB = headB;
    /**
     * The logic is that we want to two iterator to travel the same distance.
     *
     * Given two lists and merging point is at node C. And common list is any
     * number of node X, Y, Z.
     *
     * A--B--C--X--Y--Z
     * D--C--X--Y--Z
     *
     * The travel distance of two iterators toward the merging node would be
     * the same:
     *
     * A--B--C--X--Y--Z--D--C--X--Y--Z
     * D--C--X--Y--Z--A--B--C--X--Y--Z
     *
     * Travel distance iterator 1: |head1| + |common| + |head2|
     * Travel distance iterator 2: |head2| + |common| + |head1|
     */
    while (currentA != currentB) {
      currentA = currentA.next == null ? headB : currentA.next;
      currentB = currentB.next == null ? headA : currentB.next;
    }
    return currentA.data;
  }

  class Node {
    int data;
    Node next;
  }
}

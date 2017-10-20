package com.kn.tip.problem.hackerrank;

/**
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
 */
public class CycleDetection {
  boolean hasCycle(final Node head) {
    if (head == null) {
      return false;
    }
    Node turtle = head;
    Node rabbit = head;
    do {
      turtle = turtle.next;
      rabbit = rabbit.next != null ? rabbit.next.next : null;
      if (turtle == rabbit) {
        return true;
      }
    } while (turtle != null && rabbit != null);
    return false;
  }

  class Node {
    int data;
    Node next;
  }
}

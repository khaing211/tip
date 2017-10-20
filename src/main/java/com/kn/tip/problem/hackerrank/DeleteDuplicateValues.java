package com.kn.tip.problem.hackerrank;

public class DeleteDuplicateValues {
  class Node {
    int data;
    Node next;
  }

  Node RemoveDuplicates(final Node head) {
    Node iter = head;
    while (iter != null) {
      if (iter.next != null) {
        if (iter.next.data == iter.data) {
          iter.next = iter.next.next;
        } else {
          iter = iter.next;
        }
      } else {
        iter = iter.next;
      }

    }
    return head;
  }
}

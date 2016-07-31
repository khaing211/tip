package com.kn.tip.problem.leetcode;

public class ReverseSinglyLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode tail = head;
    head = head.next;
    tail.next = null;
    while (head != null) {
      ListNode tmp = head;
      head = head.next;
      tmp.next = tail;
      tail = tmp;
    }

    return tail;
  }
}

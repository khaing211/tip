package com.kn.tip.problem.hackerrank;

public class ReverseDoublyLinkedList {
  class Node {
    int data;
    Node next;
    Node prev;
  }

  Node Reverse(Node head) {
    if (head == null) {
      return null;
    }
    while (true) {
      final Node tmp = head.next;
      head.next = head.prev;
      head.prev = tmp;

      if (head.prev == null) {
        return head;
      } else {
        head = head.prev;
      }
    }
  }
}

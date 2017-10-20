package com.kn.tip.problem.hackerrank;

public class InsertIntoSortedList {
  Node SortedInsert(final Node head, final int data) {
    if (head == null) {
      final Node node = new Node();
      node.data = data;
      return node;
    }

    final Node node = new Node();
    node.data = data;
    node.next = head;
    head.prev = node;

    Node iter = node;
    while (sortAndSwap(iter)) {
      iter = iter.next;
    }

    return node;
  }

  // Sort the data, not the node (there is no constraint against this)
  // so we don't have to deal with fixing next/prev reference
  // We always insert new head node
  boolean sortAndSwap(final Node current) {
    if (current.next == null) {
      return false;
    }
    if (current.data > current.next.data) {
      final int tmp = current.data;
      current.data = current.next.data;
      current.next.data = tmp;
      return true;
    }
    return false;
  }

  class Node {
    int data;
    Node next;
    Node prev;
  }
}

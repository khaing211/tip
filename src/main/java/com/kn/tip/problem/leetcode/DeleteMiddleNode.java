package com.kn.tip.problem.leetcode;

public class DeleteMiddleNode {
  public void deleteNode(ListNode node) {
    // copy the next node include the next pointer
    // next node become irrelevant/deleted.
    if (node != null && node.next != null) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
}

package com.kn.tip.problem.leetcode;

public class EvenOddLinkedList {
  
  public ListNode oddEvenList(ListNode head) {
    // zero node
    if (head == null) {
      return null;
    }
    
    // only 1 node
    if (head.next == null) {
      return head;
    }
    
    final ListNode[] headNodes = new ListNode[2];
    headNodes[0] = head;
    headNodes[1] = head.next;
    
    final ListNode[] tailNodes = new ListNode[2];
    tailNodes[0] = head;
    tailNodes[1] = head.next;
    
    // last even or odd index
    int i = 1;
    
    while (true) {
      final int next = (i+1)%2;

      // end of the list
      if (tailNodes[i].next == null) {
        tailNodes[next].next = null;
        break;
      }
      
      tailNodes[next].next = tailNodes[i].next;
      
      tailNodes[next] = tailNodes[next].next;
      i = next;
    }

    tailNodes[0].next = headNodes[1];

    return head;
  }
  
  public static void main(String[] args) {
    EvenOddLinkedList solution = new EvenOddLinkedList();

    // odd number of nodes
    ListNode oddNodes = constructListNode(5);
    printNode(oddNodes);

    ListNode solution1 = solution.oddEvenList(oddNodes);
    printNode(solution1);
    
    // even number of nodes
    ListNode evenNodes = constructListNode(6);
    printNode(evenNodes);

    ListNode solution2 = solution.oddEvenList(evenNodes);
    printNode(solution2);
    
    // one node
    ListNode oneNode = constructListNode(1);
    ListNode solution3 = solution.oddEvenList(oneNode);
    printNode(solution3);
    
    // zero node
    ListNode zeroNode = constructListNode(0);
    ListNode solution4 = solution.oddEvenList(zeroNode);
    printNode(solution4);

  }
  
  public static ListNode constructListNode(int nNode) {
    if (nNode <= 0) return null;
    
    ListNode head = new ListNode(0);
    ListNode tail = head;
    for (int i = 1; i < nNode; i++) {
      tail.next = new ListNode(i);
      tail = tail.next;
    }
    
    return head;
  }
  
  public static void printNode(ListNode head) {
    System.out.print('[');
    while (head != null) {
      System.out.print(head.val);
      System.out.print(", ");
      head = head.next;
    }
    System.out.println(']');
  }

}

package com.kn.tip.problem.geeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print all Jumping Numbers smaller than or equal to a given value
 * 
 * A number is called as a Jumping Number if all adjacent digits in it differ by 1. 
 * The difference between ‘9’ and ‘0’ is not considered as 1.
 * 
 * All single digit numbers are considered as Jumping Numbers. 
 * For example 7, 8987 and 4343456 are Jumping numbers 
 * 
 * but 796 and 89098 are not.
 *
 * Given a positive number x, print all Jumping Numbers smaller than or equal to x. 
 * The numbers can be printed in any order.
 */
public class JumpingNumber {
  public static void main(String[] args) {
    printJumpingNumbersSmallerOrEqualTo(100);
  }
  
  public static void printJumpingNumbersSmallerOrEqualTo(final int val) {
    // 0 is always jumping number
    System.out.println(0);
    for (int i = 1; i <= 9 && i <= val; i++) {
      searchJumpingNumber(i, val);
    }
  }
  
  public static void searchJumpingNumber(final int start, int val) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      
      // drop
      if (cur > val) {
        continue;
      }
      
      System.out.println(cur);
      
      // least significatn digit seems easier to program
      // how do you assure you won't print same number twice ?
      int lsb = cur % 10;
      if (lsb == 0) {
        int high = cur * 10 + lsb + 1;
        queue.add(high);
      } else if (lsb ==  9) {
        // case of 9xx
        int low = cur * 10 + lsb - 1;
        queue.add(low);
      } else {
        int high = cur * 10 + lsb + 1;
        int low = cur * 10 + lsb - 1;
        
        queue.add(high);
        queue.add(low);
      }
    }
  }
}

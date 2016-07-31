package com.kn.tip.problem.ctci;

import java.util.Stack;

public class SortStack {
  // insertion sort
  public static Stack<Integer> sort(Stack<Integer> stack) {
    Stack<Integer> ret = new Stack<>();
    
    while (!stack.isEmpty()) {
      int top = stack.pop();
      while (!ret.isEmpty() && ret.peek() > top) {
        stack.push(ret.pop());
      }
      ret.push(top);
    }
    
    return ret;
  }
  
  public static void main(String[] args) {
    Stack<Integer> unsortedStack = create(new int[] {6,5,4,3,2,1});
    System.out.println(unsortedStack);

    Stack<Integer> sortedStack = sort(unsortedStack);
    
    System.out.println(sortedStack);
  }
  
  public static Stack<Integer> create(int[] array) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < array.length; i++) {
      stack.push(array[i]);
    }
    return stack;
  }
}

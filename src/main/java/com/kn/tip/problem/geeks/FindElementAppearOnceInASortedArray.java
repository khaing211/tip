package com.kn.tip.problem.geeks;

/**
 * Given a sorted array in which all elements appear twice (one after one) 
 * and one element appears only once. Find that element in O(log n) complexity.
 *
 */
public class FindElementAppearOnceInASortedArray {
  // where all other elements appear twice
  // since array is sorted, then all same element is next to each other
  
  // array.length always odd
  public static int findRecursive(int[] array, int low, int high) {
    if (low == high) {
      return array[low];
    }
    
    int mid = (low + high)/2;
    if (mid % 2 == 0) {
      // mid is even, and element to the right is same
      // then there is no suspect element on the left of the array
      if (array[mid] == array[mid+1]) {
        return findRecursive(array, mid+2, high);
      } else {
        // have to include mid because mid-1 could be equal to mid
        // due to suspect element on the left
        return findRecursive(array, low, mid);
      }
    } else {
      if (array[mid] == array[mid-1]) {
        // can't be on the left
        return findRecursive(array, mid+1, high);
      } else {
        // don't have to include mid, because mid is odd
        return findRecursive(array, low, mid-1);
      }
    }
  }
  
  public static void main(String[] args) {
    System.out.println(2 == findRecursive(new int[] {1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}, 0, 10));
    System.out.println(2 == findRecursive(new int[] {1, 1, 2, 4, 4, 5, 5, 6, 6}, 0, 8));
    System.out.println(2 == findRecursive(new int[] {1, 1, 4, 4, 5, 5, 6, 6, 2}, 0, 8));
    System.out.println(2 == findRecursive(new int[] {1, 1, 2}, 0, 2));
    System.out.println(1 == findRecursive(new int[] {1, 2, 2}, 0, 2));
  }
}

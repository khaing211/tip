package com.kn.tip.problem.geeks;

public class MissingNumberInIncreasingSequence {
  
  public static void main(String[] args) {
    System.out.println(missingNumber(new int[] {0,1,2,4,5,6}, 0, 5));
    System.out.println(missingNumberRandomIndex(new int[] {-6,-5,-4,-2,-1,0,1,2,3,4,5,6}, 0, 12));
  }
  
  // increasing sequence is 0,1,2,3,4,6
  public static int missingNumber(int[] array, int low, int high) {
    if (low == high) {
      return low;
    }
    
    int mid = (low+high)/2;
    if (array[mid] != mid) {
      return missingNumber(array, low, mid);
    } else {
      return missingNumber(array, mid+1, high);
    }
  }
  
  // missing number start at random index
  // increasing sequence
  public static int missingNumberRandomIndex(int[] array, int low, int high) {
    if (low == high) {
      return array[0] + low;
    }
    
    int mid = (low+high)/2;
    if (array[mid] != array[0] + mid) {
      return missingNumberRandomIndex(array, low, mid);
    } else {
      return missingNumberRandomIndex(array, mid+1, high);
    }
  }  
  
  // challenge: cover this to find missing number in Arithemic Progression
}

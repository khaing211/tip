package com.kn.tip.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutation {

  // Change Combination#generate algorithm a bit
  // to add order to the set
  // text contains unique character
  public static List<String> generate(String text) {
    final ArrayList<String> results = new ArrayList<String>();
    for (int i = 0; i < text.length(); i++) {
      // Record size as we will be adding to the list
      // neat trick
      int resultsLength = results.size();
      for (int j = 0; j < resultsLength; j++) {
        String result = results.get(j);
        for (int k = 0; k <= result.length(); k++) {
          results.add(result.substring(0, k) + text.charAt(i) + result.substring(k));
        }
      }
      // generate {} + text[i] set
      results.add(Character.toString(text.charAt(i)));
    }
    return results;
  }

  /**
   * generate all permutate of 3 elements (non-repeat)
   * 
   * Given array of n elements, generate 3 permutation of n elements
   * 
   * The idea is the loop start 0,1,2 because index before is used. By using swap to keep element
   * that loop select to use. By 2nd swap to return the element back to the population to select
   * 
   * 3 loop is to select 3 elements
   * 
   * By using "swap", there is no "if" check
   */
  public static void permutate3(int[] array) {
    for (int i = 0; i < array.length; i++) {
      swap(array, 0, i);
      for (int j = 1; j < array.length; j++) {
        swap(array, 1, j);
        for (int k = 2; k < array.length; k++) {
          swap(array, 2, k);
          System.out.println(array[0] + " " + array[1] + " " + array[2]);
          swap(array, 2, k);
        }
        swap(array, 1, j);
      }
      swap(array, 0, i);
    }
  }

  /**
   * Same idea as combination
   * 
   * dynamic loop
   */
  public static void permutate(int[] array, int k) {
    final int n = array.length;
    final int[] indices = IntStream.range(0, k).toArray();

    do {
      swapAll(array, indices);
      print(array, k);
      swapAll(array, indices);
    } while (next(indices, n, k));
  }

  public static void print(int[] array, int k) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < k; i++) {
      builder.append(array[i]).append(" ");
    }
    System.out.println(builder.toString());
  }

  public static void swapAll(int[] array, int[] indices) {
    for (int i = 0; i < indices.length; i++) {
      swap(array, i, indices[i]);
    }
  }

  public static boolean next(int[] indices, int n, int k) {
    int i = k - 1;
    while (i >= 0) {
      // loop terminated condition
      if (indices[i] == n - 1) {
        i--;
      } else {
        // iterative loop
        indices[i]++;
        // reset inner loop indices
        for (int j = i + 1; j < k; j++) {
          indices[j] = j;
        }
        return true;
      }
    }

    return false;
  }

  public static void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }


  public static void main(String[] args) {
    // permutate3(new int[] {1, 2, 3, 4, 5});
    // System.out.println("=============");
    // permutate(new int[] {1, 2, 3, 4, 5}, 3);
    System.out.println(generate("abcaa"));
  }
}

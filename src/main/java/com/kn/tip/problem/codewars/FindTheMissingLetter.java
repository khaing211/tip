package com.kn.tip.problem.codewars;

public class FindTheMissingLetter {
  public static char findMissingLetter(final char[] array) {
    // binary search
    // at the index of missing letter
    // everything to the left of index is equal to array[0] + mid
    // everything to the right of index is strictly greater than array[0] + mid
    //
    // Example: division indicated by vertical bar [ a, b, c | e ]
    //
    // Best practice to detect infinite loop in binary search
    // Go through iteration with the following table
    //
    // Example: infinite loop if low = mid instead of low = mid + 1
    //
    // iter | 1 | 2 | 3 | 4 |
    // low  | 0 | 1 | 2 | 2 |
    // high | 3 | 3 | 3 | 3 |
    // mid  | 1 | 2 | 2 | 2 |

    int low = 0;
    int high = array.length-1;
    int mid = 0;
    while (low < high) {
      mid = ((high - low)/2) + low;
      final char ch = (char)(array[0] + mid);
      if (array[mid] == ch) {
        low = mid+1;
      } else if (array[mid] > ch) {
        high = mid;
      }
    }
    return (char)(array[0] + high);
  }
}

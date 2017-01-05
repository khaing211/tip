package com.kn.tip.problem.ctci;

/**
 * 1.6 First implementation
 *
 * 1st Attempts: if more than 3 consecutive char, then the compression always will be smaller.
 * Failed:
 * 1. Optimize: StringBuilder is not initialized capacity. You could initialize the capacity to s.length() since the problem make sure the compression would always be smaller.
 * 2. Form new string even if compression is not smaller. Increase memory space?
 */
public class Compression {
  public static String compress(final String s) {
    final StringBuilder builder = new StringBuilder();
    char ch = 0;
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != ch) {
        insertCompress(builder, ch, c);
        c = 0;
        ch = s.charAt(i);
      }
      c++;
    }
    insertCompress(builder, ch, c);
    return builder.toString();
  }

  private static void insertCompress(final StringBuilder builder, final char ch, int c) {
    if (c <= 0) {
      return;
    } else if (c < 3) {
      while (c-- > 0) {
        builder.append(ch);
      }
    } else {
      builder.append(ch)
        .append(c);
    }
  }

  public static void main(final String[] args) {
    System.out.println(compress("abc"));
    System.out.println(compress("aabc"));
    System.out.println(compress("aaabc"));
    System.out.println(compress("aaabbc"));
    System.out.println(compress("aaabbbc"));
    System.out.println(compress("abbbc"));
    System.out.println(compress("abcccc"));
    System.out.println(compress("aaaabcccc"));
  }

}

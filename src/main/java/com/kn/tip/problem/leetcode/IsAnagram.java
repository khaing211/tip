package com.kn.tip.problem.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
  /**
   * Account for unicode
   */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    
    Map<Character, Integer> map = new HashMap<Character,Integer>();
    for (int i = 0; i < s.length(); i++) {
      map.compute(s.charAt(i), (k,v) -> {
        if (v == null) {
          return 1;
        } else {
          return v+1;
        }
      });
      
      map.compute(t.charAt(i), (k,v) -> {
        if (v == null) {
          return -1;
        } else {
          return v-1;
        }
      });
    }
    
    return !map.values().stream().filter(i -> i != 0).findAny().isPresent();
  }
}

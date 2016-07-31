package com.kn.tip.problem.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationWithDups {
  public static void main(String[] args) {
    System.out.println(permutateWithDups("aabc"));
  }

  public static List<String> permutateWithDups(String text) {
    Map<Character, Integer> countTable = buildCountTable(text);
    List<String> result = new ArrayList<>();
    buildPermutation("", text.length(), countTable, result);
    return result;
  }

  public static void buildPermutation(String prefix, int totalRemainCharacterCount,
      Map<Character, Integer> countTable, List<String> result) {

    result.add(prefix);

    if (totalRemainCharacterCount == 0) {
      return;
    }

    for (Character ch : countTable.keySet()) {
      int count = countTable.get(ch);
      if (count > 0) {
        countTable.put(ch, count - 1);
        buildPermutation(prefix + ch, totalRemainCharacterCount - 1, countTable, result);
        countTable.put(ch, count);
      }
    }
  }

  public static Map<Character, Integer> buildCountTable(String text) {
    Map<Character, Integer> countTable = new HashMap<>();
    for (int i = 0; i < text.length(); i++) {
      countTable.compute(text.charAt(i), (k, v) -> v == null ? 1 : v + 1);
    }
    return countTable;
  }
}

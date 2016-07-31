package com.kn.tip.problem.codefight;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;

public class TreeOfSeventeen {
  int TreeOfSeventeen(int x, int[][] ed, String[] l) {
    int e = x - 2;
    LinkedList<Map.Entry<Integer, Integer>> q = new LinkedList<>();
    q.push(new AbstractMap.SimpleImmutableEntry<>(1, 0));
    int p = 0;
    while (!q.isEmpty()) {
      Map.Entry<Integer, Integer> first = q.removeFirst();
      int n = first.getKey();
      int d = first.getValue();
      int i = 0;
      while (i <= e) {
        if (ed[i][0] == n || ed[i][1] == n) {
          int dd = distance(d, l[i]);
          if (dd == 17)
            p++;
          if (ed[i][0] == n) {
            q.push(new AbstractMap.SimpleImmutableEntry<>(ed[i][1], dd));
          } else {
            q.push(new AbstractMap.SimpleImmutableEntry<>(ed[i][0], dd));
          }
          swap(ed, l, e, i);
          e--;
        } else {
          i++;
        }
      }
    }
    return p;
  }

  int distance(int d, String l) {
    int v = Integer.valueOf(l.substring(1));
    if (l.startsWith("+"))
      return d + v;
    else
      return v;
  }

  void swap(int[][] ed, String[] l, int e, int s) {
    int[] tmp = ed[e];
    ed[e] = ed[s];
    ed[s] = tmp;
    String tmpLabel = l[e];
    l[e] = l[s];
    l[s] = tmpLabel;
  }
}

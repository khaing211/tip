package com.kn.tip.algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.kn.tip.algorithm.PrimMinimumSpanningTree;
import com.kn.tip.algorithm.PrimMinimumSpanningTree.Edge;
import com.kn.tip.datastructure.graph.GridWeightedGraph;

public class PrimMinimumSpanningTreeTest {

  @Test
  public void test4Nodes() {
    GridWeightedGraph graph = new GridWeightedGraph(4);
    graph.setWeight(0, 1, 1);
    graph.setWeight(1, 2, 2);
    graph.setWeight(2, 3, 3);
    graph.setWeight(1, 3, 4);

    Edge[] edges = PrimMinimumSpanningTree.compute(graph);
    System.out.println(Arrays.toString(edges));
  }
}

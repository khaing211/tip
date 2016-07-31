package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.datastructure.Tree;
import com.kn.tip.datastructure.TreeNode;
import com.kn.tip.problem.TreeDiameter;

import static org.junit.Assert.assertEquals;

public class TreeDiameterTest {

    @Test
    public void testLongestPathGoThroughTopTree() {
        final Tree<Integer> tree = Tree.root(0)
                .left(1)
                .right(2);

        assertEquals(3, TreeDiameter.diameter(tree.root()));
    }

    @Test
    public void testLongestPathGoThroughSubtree() {
        final Tree<Integer> tree = Tree.root(0)
                .left(1)
                .right(2)
                    .transverseLeft()
                    .left(3)
                    .right(4)
                        .transverseRight()
                        .right(5)
                            .transverseRight()
                            .right(6)
                            .transverseParent()
                        .transverseParent()
                        .transverseLeft()
                        .left(7)
                            .transverseLeft()
                            .left(8);



        assertEquals(tree.root().toString(), 7, TreeDiameter.diameter(tree.root()));
    }
}

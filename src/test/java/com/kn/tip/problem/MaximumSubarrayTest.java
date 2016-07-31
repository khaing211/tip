package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.MaximumSubarray;

import static org.junit.Assert.assertEquals;

public class MaximumSubarrayTest {
    @Test
    public void testMaxContiguousSubArray() {
        // even an edge case can trick u up
        assertEquals(-1, MaximumSubarray.maxSumContiguousSubarray(new long[]{-1, -5}));
        assertEquals(10, MaximumSubarray.maxSumContiguousSubarray(new long[]{2, -1, 2, 3, 4, -5}));
        assertEquals(11, MaximumSubarray.maxSumNonContiguousSubarray(new long[]{2, -1, 2, 3, 4, -5}));
        assertEquals(-1, MaximumSubarray.maxSumNonContiguousSubarray(new long[]{-1, -5}));
        assertEquals(0, MaximumSubarray.maxSumNonContiguousSubarray(new long[]{-1, -5, 0}));
    }
}

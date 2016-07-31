package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.PrimeGenerator;

import java.util.Arrays;

public class PrimeGeneratorTest {
    @Test
    public void test() {
        System.out.println(Arrays.toString(PrimeGenerator.compute(10000)));
    }
}

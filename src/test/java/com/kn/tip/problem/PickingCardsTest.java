package com.kn.tip.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kn.tip.problem.PickingCards;

public class PickingCardsTest {
	@Test
	public void test() {
		//assertEquals(0, PickingCards.count(new int[] {0, 3, 3}));
		
		//assertEquals(6, PickingCards.count(new int[] {0, 0, 0}));
		
		assertEquals(4, PickingCards.count(new int[] {0, 0, 1}));
	}
}

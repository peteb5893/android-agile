package com.aptitudeguru.dashboard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testUserInput {
	Puzzles test;

	@Before
	public void setUp() throws Exception {
		test = new Puzzles();
	}

	@Test
	public void testValidInput() {
		String input = "A";
		assertTrue(test.validInput(input));
	}

	@Test
	public void testInvalidInput() {
		String input = "g";
		assertFalse(test.validInput(input));
	}
}

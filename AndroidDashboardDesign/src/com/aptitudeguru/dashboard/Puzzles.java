package com.aptitudeguru.dashboard;

import java.util.Locale;

public class Puzzles {

	public boolean validateInput(String input) {
		input = input.toLowerCase(Locale.getDefault());
		
		if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d"))
			return true;
		else
			return false;
	}
	
}
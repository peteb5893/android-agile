package com.aptitudeguru.dashboard;

import static org.junit.Assert.*;

import java.util.Currency;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class localeTest {
	Locale locale;

	@Before
	public void setUp() throws Exception {
		locale = new Locale("en", "GB");
	}

	@Test
	public void testGetLocale() {
		assertEquals(locale.getCountry(), "GB");
	}
	
	@Test
	public void testCurrencySymbol() {
		Currency localCurrency = Currency.getInstance(locale);
		String currencySymbol = localCurrency.getSymbol(locale);
		assertEquals(currencySymbol, "£");
	}
	
	@Test
	public void testReplaceWithLocalCurr(){
		// 'cachemoney' is the currency symbol placeholder to be changed based on the user's locale
		String rawQuestion = "A man buys a bike for cachemoney 100";
		String category = "q1";
		String option1 = "option 1";
		String option2 = "option 2";
		String option3 = "option 3";
		String option4 = "option 4";
		String sol = "A";
		
		QuantsTable quants = new QuantsTable(1, rawQuestion, category, option1, option2, option3, option4, sol);
		assertEquals(quants.getQues(), "A man buys a bike for £ 100");
	}
}

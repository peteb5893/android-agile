package com.aptitudeguru.dashboard;

import java.util.Currency;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidhive.dashboard.R;

public class Puzzles extends Activity {
	TextView mainTextView;
	Locale locale = Locale.getDefault();
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puzzles);
		
		mainTextView = (TextView) findViewById(R.id.mainTextView);
		Currency localCurrency = Currency.getInstance(locale);
		String currencySymbol = localCurrency.getSymbol();
		
		String testString = "Something costs cachemoney 10";
		String fixedString = testString.replaceAll("cachemoney", currencySymbol);
		
		mainTextView.setText(fixedString);
	}
}
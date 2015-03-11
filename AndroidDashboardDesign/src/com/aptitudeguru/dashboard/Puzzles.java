package com.aptitudeguru.dashboard;

import java.util.Locale;
import java.util.Currency;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidhive.dashboard.R;


public class Puzzles extends Activity {
	TextView mainTextView;
	Locale locale = Locale.getDefault();
	Currency curr = Currency.getInstance(locale);
	String $curr=curr.getSymbol(locale);
	String $dist;
	String $speed;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puzzles);
		
		mainTextView = (TextView) findViewById(R.id.mainTextView);		
		
		mainTextView.setText("Current locale: " + locale.toString() + "\nCurrency symbol: " + $curr +"\nWithin a string: $dist $curr test");
		//mainTextView.setText("$dist $curr whatever else, test");
	}
}
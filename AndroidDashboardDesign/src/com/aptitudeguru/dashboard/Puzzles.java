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
	String cachemoney=curr.getSymbol(locale);
	String distvar;
	String speedvar;
	String teststr = "distvar cachemoney whatever else, test";
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puzzles);
		
		mainTextView = (TextView) findViewById(R.id.mainTextView);		
		
		//mainTextView.setText("Current locale: " + locale.toString() + "\nCurrency symbol: " + cachemoney +"\nWithin a string: $dist $curr test");
		//mainTextView.setText("$dist $curr whatever else, test");
		String newStr = teststr.replace("cachemoney", cachemoney);
		System.out.println(newStr);
		mainTextView.setText("Current Locale: " + locale.toString() +
							"\nCountry Initials: " + locale.getCountry() + 
							"\nCountry Name: " + locale.getDisplayCountry() +
							"\nCountry Language: " + locale.getDisplayLanguage() + 
							"\nCurrency: " + cachemoney + 
							"\nReplace test: " + newStr);
	}
}
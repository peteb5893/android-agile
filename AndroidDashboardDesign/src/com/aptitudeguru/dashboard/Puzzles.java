package com.aptitudeguru.dashboard;

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
		mainTextView.setText("Current locale: " + locale.toString());
	}
}
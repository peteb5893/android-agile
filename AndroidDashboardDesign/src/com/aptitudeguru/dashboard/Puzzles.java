package com.aptitudeguru.dashboard;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidhive.dashboard.R;

public class Puzzles extends Activity{
	EditText editText1, editText2;
	TextView textView1;

	public boolean validInput(String input) {
		input = input.toLowerCase(Locale.getDefault());
		if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d"))
			return true;
		else
			return false;
	}
	
	private void setOnFocusChangeListener(final EditText editText){
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if(!hasFocus){
					String input = editText.getText().toString();
					
					if(validInput(input)) {
						textView1.setText(input);
					}
					else {
						editText.setError("Enter A, B, C, D");
					}
				}
			}
			
		});
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
	        // Activity was brought to front and not created, 
	        // Thus finishing this will get us to the last viewed activity 
	        finish(); 
	        return; 
	    }
		
		setContentView(R.layout.puzzles);
				
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		setOnFocusChangeListener(editText1);
		setOnFocusChangeListener(editText2);
	}
}
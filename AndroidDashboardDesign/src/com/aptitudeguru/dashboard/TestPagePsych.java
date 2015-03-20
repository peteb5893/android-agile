package com.aptitudeguru.dashboard;

import java.text.DecimalFormat;
import java.util.Locale;
//import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
//import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidhive.dashboard.R;

public class TestPagePsych extends Activity implements OnClickListener {
	TextView scenario, situation, optionA, optionB, optionC, optionD;
	EditText bestAnswer, worstAnswer;
	String cat = "";
	int click = 0;
	Random r = new Random();
	int STATIC_INTEGER_VALUE = 1;
	String PUBLIC_STATIC_STRING_IDENTIFIER;
	final Context context = this;
	String time;

	Button btn_next;
	Button btn_prev;

	DatabaseHandler db = new DatabaseHandler(this);

	int k1 = 0;
	
	// validate that the user typed in A, B, C, or D
		public boolean validInput(String input) {
			input = input.toLowerCase(Locale.getDefault()); // normalise input to lower case
			if (input.equals("a") || input.equals("b") || input.equals("c") || input.equals("d")){
				return true;
			}
			else {
				return false;
			}
		}
		
		// check that the user hasn't entered the same answer twice
		public boolean isDuplicateInput(EditText editTextA, EditText editTextB){
			String input1 = editTextA.getText().toString();
			String input2 = editTextB.getText().toString();
			
			if (input1.equals(input2)) // compare the text typed into both text entry boxes
				return true;
			else
				return false;
		}
		
		// listener for when an edit text box loses focus (the user taps away from it)
		private void setOnFocusChangeListener(final EditText editText){
			editText.setOnFocusChangeListener(new OnFocusChangeListener() {

				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					if(!hasFocus){
						String input = editText.getText().toString();
						
						editText.setError(null); // clear any previous errors
						
						if(validInput(input)) { // user entered a valid input
							if (!isDuplicateInput(bestAnswer, worstAnswer)){ // user didn't enter a duplicate input
								// 
								//textView1.setText(input);
							}
							else {
								editText.setError("Already entered " + input + ", select another option");
							}
						}
						else {
							editText.setError("Enter A, B, C, D");
						}
					}
				}
				
			});
		}

	@Override
	public void onBackPressed() {
		Toast.makeText(getApplicationContext(), "You Cannot Exit",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		String extraData = data.getStringExtra("ComingFrom");
		int j1 = Integer.parseInt(extraData);

		
		click = j1;
		if (click == 0) {
			btn_prev.setEnabled(false);
			btn_prev.setVisibility(View.INVISIBLE);
		} else {
			btn_next.setEnabled(true);
			btn_prev.setEnabled(true);
			btn_next.setVisibility(View.VISIBLE);
			btn_prev.setVisibility(View.VISIBLE);
		}
		if (click == 19) {
			btn_next.setEnabled(false);
			btn_next.setVisibility(View.INVISIBLE);
		} else {
			btn_prev.setEnabled(true);
			btn_next.setEnabled(true);
			btn_next.setVisibility(View.VISIBLE);
			btn_prev.setVisibility(View.VISIBLE);
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.psychometric);
 
		Bundle bundle = getIntent().getExtras();
		cat = bundle.getString("cat");

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		TextView title = new TextView(context);
		title.setText("Aptitude App");
		title.setBackgroundColor(Color.DKGRAY);
		title.setPadding(10, 10, 10, 10);
		title.setGravity(Gravity.CENTER);
		title.setTextColor(Color.WHITE);
		title.setTextSize(20);
		alertDialogBuilder.setCustomTitle(title);

		// set dialog message
		alertDialogBuilder
		.setMessage("Start Test?")
		.setCancelable(false)
		.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				// if this button is clicked, just close the dialog box and do nothing

				TestPagePsych.this.finish();
			}
		});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		scenario = (TextView) findViewById(R.id.scenario);
		scenario.setText("You are a Human Resources (HR) Assistant working in the HR Department of a busy NHS Hospital Trust. "
				+ "The hospital is the Princess Aurora General in Saldringham City. Your role is to carry out administrative tasks "
				+ "to support the HR activities required in the Trust. You organise and support recruitment, book training courses, "
				+ "provide secretarial support at disciplinary investigations and keep personnel records for all medical and non-medical "
				+ "staff up-to-date including pay and conditions information.You report to one of two HR Managers who in turn report "
				+ "to the HR Director. Your manager is called Fiona Potter.");

		situation = (TextView) findViewById(R.id.situation);
		situation.setText("\nIt is a Tuesday morning and a colleague in the stationery section is away on sick leave. At 11am you are on "
				+ "your way to the staff room to take a quick tea break when, passing through the stationery section, you notice that it "
				+ "is in a reasonable amount of disarray. Products have fallen on the floor and been left lying there, shelves are untidy "
				+ "and some products are on the wrong shelves.");
		
		optionA = (TextView) findViewById(R.id.optionA);
		optionA.setText("Take your tea break and then on the way back quickly tidy up a few bits and pieces if it's still in a state");

		optionB = (TextView) findViewById(R.id.optionB);
		optionB.setText("Go back to your section and ask your team leader whether you can be spared for 10 or 15 minutes to help out in stationery. "
				+ "If agreed, offer your help to the stationery team leader to quickly tidy up the area and take your tea break at 11.30am.");
		
		optionC = (TextView) findViewById(R.id.optionC);
		optionC.setText("Do nothing. The stationery team leader probably has it all under control and will deal with it soon. It's understandable "
				+ "that there's a bit of a mess as someone is away and you don't want to insult the stationery team by mentioning anything.");
		
		optionD = (TextView) findViewById(R.id.optionD);
		optionD.setText("Inform the stationery team leader that there is a problem with the presentation of the section.");
		
		bestAnswer = (EditText) findViewById(R.id.bestAnswer);
		worstAnswer = (EditText) findViewById(R.id.worstAnswer);
		
		setOnFocusChangeListener(bestAnswer);
		setOnFocusChangeListener(worstAnswer);
		
		/**
		 * Creating all buttons instances
		 * */
		// Home button
		Button btn_home = (Button) findViewById(R.id.btn_home);

		btn_home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(), "You Cannot Exit",
						Toast.LENGTH_SHORT).show();
			}
		});

		// Help button
		Button btn_help = (Button) findViewById(R.id.btn_help);

		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Launching Help Screen
				Intent i = new Intent(getApplicationContext(), help1.class);

				startActivity(i);
			}
		});
		
		// Submit button
		Button submit = (Button)findViewById(R.id.submitBtn);
		
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Launching Help Screen
				Intent i = new Intent(getApplicationContext(), PsycometricTestFeedback.class);

				startActivity(i);				
			}
		});
	}

	public void onClick(View v) {

	}
}

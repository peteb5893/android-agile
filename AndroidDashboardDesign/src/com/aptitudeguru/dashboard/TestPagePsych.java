package com.aptitudeguru.dashboard;

import java.text.DecimalFormat;
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
import android.widget.Button;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidhive.dashboard.R;

public class TestPagePsych extends Activity implements OnClickListener {
	TextView scenario, situation, optionA, optionB, optionC, optionD;
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
				// if this button is clicked, close current activity
//				if (!timerHasStarted) {
//					countDownTimer.start();
//					k1 = 1;
//					timerHasStarted = true;
//				} else {
//					countDownTimer.cancel();
//					timerHasStarted = false;
//				}
				// next
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
		scenario.setText("test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test "
				+ "test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test");

		optionD = (TextView) findViewById(R.id.optionD);
		optionD.setText("test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test "
				+ "test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test test ");

		/**
		 * Creating all buttons instances
		 * */
		// Home button
//		Button btn_home = (Button) findViewById(R.id.btn_home);
//
//		btn_home.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				Toast.makeText(getApplicationContext(), "You Cannot Exit",
//						Toast.LENGTH_SHORT).show();
//			}
//		});
//
//		// Favourite questions button
//		Button btn_fav = (Button) findViewById(R.id.btn_fav);
//
//		// Hint button
//		Button btn_hint = (Button) findViewById(R.id.btn_hint);
//
//		// Go To button
//		Button btn_goto = (Button) findViewById(R.id.btn_goto);
//
//		// Help button
//		Button btn_help = (Button) findViewById(R.id.btn_help);
//
//		btn_help.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				// Launching Help Screen
//				Intent i = new Intent(getApplicationContext(), help1.class);
//
//				startActivity(i);
//			}
//		});
//
//		// Finish Button
//		Button btn_finish = (Button) findViewById(R.id.btn_finish);
//
//		// Pause Button
//		Button btn_pause = (Button) findViewById(R.id.btn_pause);
//		btn_pause.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				// Launching Pause Screen
//				Intent i = new Intent(getApplicationContext(), TestPause.class);
//				i.putExtra("cat", cat);
//				startActivity(i);
//			}
//		});

		/**
		 * Handling all button click events
		 * */

//		btn_finish.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//
//				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
//
//				TextView title = new TextView(context);
//				title.setText("Aptitude App");
//				title.setBackgroundColor(Color.DKGRAY);
//				title.setPadding(10, 10, 10, 10);
//				title.setGravity(Gravity.CENTER);
//				title.setTextColor(Color.WHITE);
//				title.setTextSize(20);
//				alertDialogBuilder.setCustomTitle(title);
//
//				// set dialog message
//				alertDialogBuilder
//				.setMessage("Click yes to exit!")
//				.setCancelable(false)
//				.setPositiveButton("Yes",
//						new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog,int id) {
//						// if this button is clicked, close current activity
//						Intent i = new Intent(getApplicationContext(),ShowScore.class);
//						time = text.getText() + "";
//
//						sec = sec + 40;
//						String timetaken = min + "." + sec + "";
//
//						double timetak = Float.parseFloat(timetaken);
//
//						double tt = 20.00 - timetak;
//
//						DecimalFormat df = new DecimalFormat("00.00");
//						String j = df.format(tt);
//
//						i.putExtra("score", ans);
//						i.putExtra("givenans", givenans);
//						i.putExtra("allid", a);
//						i.putExtra("tt", j);
//						i.putExtra("category", cat);
//
//						startActivity(i);
//						TestPagePsych.this.finish();
//					}
//				})
//				.setNegativeButton("No",
//						new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog,int id) {
//						// if this button is clicked, just close the dialog box and do nothing
//						dialog.cancel();
//					}
//				});
//
//				// create alert dialog
//				AlertDialog alertDialog = alertDialogBuilder.create();
//
//				// show it
//				alertDialog.show();
//			}
//		});
//
//		// Listening for Favourite Question button click
//		btn_fav.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				int val = a[click];
//				QuantsTable q = db.getQuants(val, cat);
//				String ques = q.getQues();
//				String op1 = q.getOption1();
//				String op2 = q.getOption2();
//				String op3 = q.getOption3();
//				String op4 = q.getOption4();
//				String sol = q.getSol();
//				db.addFav(new Favourite(ques, op1, op2, op3, op4, sol));
//
//				Toast.makeText(getApplicationContext(), "Added To Favourite",
//						Toast.LENGTH_SHORT).show();
//			}
//		});
//
//		// Listening for Hint button click
//		btn_hint.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				// Launching News Feed Screen
//				Intent i = new Intent(getApplicationContext(), Hint.class);
//				i.putExtra("cat", cat);
//				startActivity(i);
//			}
//		});
//
//		// Listening for Go To button click
//		btn_goto.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				// Launching Go To Screen
//				Intent i = new Intent(getApplicationContext(), Calender.class);
//				i.putExtra("gotoclick", gotoclick);
//				i.putExtra("click", click);
//				startActivityForResult(i, STATIC_INTEGER_VALUE);
//			}
//		});

//		int g = 0;
//		List<QuantsTable> quants = db.getAllQuants(cat);
//		for (QuantsTable cn : quants) {
//
//			if (g == 38)
//				break;
//			else {
//				g++;
//
//				count = cn.getID();
//				String sol1 = cn.getSol();
//				int sol = 0;
//				if (sol1.equalsIgnoreCase("a"))
//					sol = 1;
//				else if (sol1.equalsIgnoreCase("b"))
//					sol = 2;
//				else if (sol1.equalsIgnoreCase("c"))
//					sol = 3;
//				else
//					sol = 4;
//				initial[index3] = count;
//				initans[index3] = sol;
//				index3 = index3 + 1;
//			}
//		}
//
//		count = r.nextInt(3);
//		count = count + 1;
//
//		questionTextView = (TextView) findViewById(R.id.questionTextView);
//		questionTrack = (TextView) findViewById(R.id.questrack);
//
//		btn_next = (Button) findViewById(R.id.btn_next);
//		btn_prev = (Button) findViewById(R.id.btn_prev);
//
//		QuantsTable q = db.getQuants(initial[count], cat);
//
//		a[index++] = initial[count];
//		givenans[0] = initans[count];
//		questionTrack.setText("   " + "1/20");
//		String j = q.getQues();
//		String opt1 = q.getOption1();
//		String opt2 = q.getOption2();
//		String opt3 = q.getOption3();
//		String opt4 = q.getOption4();
//		questionTextView.setText(j);
//		answerOption1.setText(opt1);
//		answerOption2.setText(opt2);
//		answerOption3.setText(opt3);
//		answerOption4.setText(opt4);
//		btn_next.setVisibility(View.VISIBLE);
//		btn_prev.setVisibility(View.INVISIBLE);
//		for (int x = 1; x < 20; x++)
//		{
//			int k = (count + 1);
//			count = k;
//			a[index] = initial[k];
//			givenans[index] = initans[k];
//			index = index + 1;
//		}

//		btn_next.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				if (click == (19))
//				{
//					btn_next.setEnabled(false);
//					btn_next.setVisibility(View.INVISIBLE);
//
//				} else {
//
//					btn_next.setEnabled(true);
//					btn_prev.setEnabled(true);
//					btn_next.setVisibility(View.VISIBLE);
//					btn_prev.setVisibility(View.VISIBLE);
//					answerOption1.setChecked(false);
//					answerOption2.setChecked(false);
//					answerOption3.setChecked(false);
//					answerOption4.setChecked(false);
//					RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
//					radiogroup.clearCheck();
//
//					click = click + 1;
//
//					int val = a[click];
//					int check = b[click];
//					if (check == 1)
//						answerOption1.setChecked(true);
//					else if (check == 2)
//						answerOption2.setChecked(true);
//					else if (check == 3)
//						answerOption3.setChecked(true);
//					else if (check == 4)
//						answerOption4.setChecked(true);
//					else {
//					}
//					questionTrack.setText("   " + (click + 1) + "/20");
//
////					QuantsTable q = db.getQuants(val, cat);
////
////					String j = q.getQues();
////					questionTextView.setText(j);
////
////					String opt1 = q.getOption1();
////					String opt2 = q.getOption2();
////					String opt3 = q.getOption3();
////					String opt4 = q.getOption4();
////
////					answerOption1.setText(opt1);
////					answerOption2.setText(opt2);
////					answerOption3.setText(opt3);
////					answerOption4.setText(opt4);
//				}
//			}
//		});

//		btn_prev.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View view) {
//				if (click == 0)
//				{
//					btn_prev.setEnabled(false);
//					btn_prev.setVisibility(View.INVISIBLE);
//				} else {
//
//					btn_prev.setEnabled(true);
//
//					btn_next.setEnabled(true);
//					btn_next.setVisibility(View.VISIBLE);
//					btn_prev.setVisibility(View.VISIBLE);
//					answerOption1.setChecked(false);
//					answerOption2.setChecked(false);
//					answerOption3.setChecked(false);
//					answerOption4.setChecked(false);
//					RadioGroup radiogroup = (RadioGroup) findViewById(R.id.options);
//					radiogroup.clearCheck();
//
//					click = click - 1;
//					int val = a[click];
//					int check = b[click];
//					if (check == 1)
//						answerOption1.setChecked(true);
//					else if (check == 2)
//						answerOption2.setChecked(true);
//					else if (check == 3)
//						answerOption3.setChecked(true);
//					else if (check == 4)
//						answerOption4.setChecked(true);
//					else {
//
//					}
//
////					QuantsTable q = db.getQuants(val, cat);
////
////					String j = q.getQues();
////					questionTextView.setText(j);
////					questionTrack.setText("   " + (click + 1) + "/20");
////					String opt1 = q.getOption1();
////					String opt2 = q.getOption2();
////					String opt3 = q.getOption3();
////					String opt4 = q.getOption4();
////					questionTextView.setText(j);
////					answerOption1.setText(opt1);
////					answerOption2.setText(opt2);
////					answerOption3.setText(opt3);
////					answerOption4.setText(opt4);
//				}
//			}
//		});
	}

	public void onClick(View v) {
//		if (!timerHasStarted) {
//			countDownTimer.start();
//			timerHasStarted = true;
//		} else {
//			countDownTimer.cancel();
//			timerHasStarted = false;
//		}
	}

//	public class MyCountDownTimer extends CountDownTimer {
//		long starttime3 = 0;
//
//		public MyCountDownTimer(long startTime2, long interval) {
//			super(startTime2, interval);
//			starttime3 = startTime2;
//		}
//
//		@Override
//		public void onFinish() {
//			text.setText("Time's up!");
//			AlertDialog alertDialog = new AlertDialog.Builder(TestPagePsych.this).create();
//
//			TextView title = new TextView(context);
//			title.setText("Aptitude App");
//			title.setBackgroundColor(Color.DKGRAY);
//			title.setPadding(10, 10, 10, 10);
//			title.setGravity(Gravity.CENTER);
//			title.setTextColor(Color.WHITE);
//			title.setTextSize(20);
//			alertDialog.setCustomTitle(title);
//
//			// Setting Dialog Message
//			alertDialog.setMessage("TIME'S UP");
//
//			// Setting Icon to About
//			alertDialog.setIcon(R.drawable.about);
//
//			// Setting OK Button
////			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
////				public void onClick(DialogInterface dialog, int which) {
////					// Executed after dialog is closed (send to ShowScore page)
////					Intent i = new Intent(getApplicationContext(),
////							ShowScore.class);
////					time = text.getText() + "";
////
////					sec = sec + 40;
////					String timetaken = min + "." + sec + "";
////
////					double timetak = Float.parseFloat(timetaken);
////
////					double tt = 20.00 - timetak;
////
////					DecimalFormat df = new DecimalFormat("00.00");
////					String j = df.format(tt);
////					i.putExtra("tt", j);
////
////					i.putExtra("score", ans);
////					i.putExtra("givenans", givenans);
////					i.putExtra("allid", a);
////					i.putExtra("category", cat);
////					startActivity(i);
////					TestPagePsych.this.finish();
////
////				}
////			});
//
//			// Showing Alert Message
//			alertDialog.show();
//
//		}
//
////		@Override
////		public void onTick(long millisUntilFinished) {
////			int seconds = (int) (millisUntilFinished / 1000) % 60;
////			int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
////			milifin = millisUntilFinished;
////			starttime1 = milifin;
////
////			min = minutes;
////			sec = seconds;
////
////			text.setText((minutes) + ":" + (seconds) + "");
////		}
//	}
}

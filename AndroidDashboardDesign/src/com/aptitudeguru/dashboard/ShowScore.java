package com.aptitudeguru.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidhive.dashboard.R;

import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ShowScore extends Activity {
	TextView t1;
	DatabaseHandler db = new DatabaseHandler(this);

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_score);
		int correct = 0, incorrect = 0, unattempt = 0;

		Button btn_home = (Button) findViewById(R.id.btn_home);

		Button btn_fav = (Button) findViewById(R.id.btn_fav);

		Button btn_score = (Button) findViewById(R.id.btn_score);

		Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);

		Button btn_about = (Button) findViewById(R.id.btn_about);
		Button btn_help = (Button) findViewById(R.id.btn_help);

		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(), Help.class);

				startActivity(i);
			}
		});

		btn_home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(),
						AndroidDashboardDesignActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
		});

		btn_fav.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(), FavPage.class);

				startActivity(i);
			}
		});

		btn_score.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(), scoremenu.class);
				startActivity(i);
			}
		});

		btn_tutorial.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(),
						Tutorialpage.class);
				startActivity(i);
			}
		});

		btn_about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

				Intent i = new Intent(getApplicationContext(), AboutUs.class);
				startActivity(i);
			}
		});

		Bundle bundle = getIntent().getExtras();
		final int yourans[] = bundle.getIntArray("score");
		final int givenans[] = bundle.getIntArray("givenans");
		final String cat = bundle.getString("category");
		final int allid[] = bundle.getIntArray("allid");
		final String timetaken = bundle.getString("tt");
		TextView timetak = (TextView) findViewById(R.id.textView5);
		TextView incorr = (TextView) findViewById(R.id.textView3);
		TextView unattem = (TextView) findViewById(R.id.textView4);
		timetak.append(" " + timetaken);

		int score = 0;
		int index1 = 0, index2 = 0;

		Button buttons[] = new Button[20];

		buttons[0] = (Button) findViewById(R.id.score1);
		buttons[1] = (Button) findViewById(R.id.score2);
		buttons[2] = (Button) findViewById(R.id.score3);
		buttons[3] = (Button) findViewById(R.id.score4);
		buttons[4] = (Button) findViewById(R.id.score5);
		buttons[5] = (Button) findViewById(R.id.score6);
		buttons[6] = (Button) findViewById(R.id.score7);
		buttons[7] = (Button) findViewById(R.id.score8);
		buttons[8] = (Button) findViewById(R.id.score9);
		buttons[9] = (Button) findViewById(R.id.score10);
		buttons[10] = (Button) findViewById(R.id.score11);
		buttons[11] = (Button) findViewById(R.id.score12);
		buttons[12] = (Button) findViewById(R.id.score13);
		buttons[13] = (Button) findViewById(R.id.score14);
		buttons[14] = (Button) findViewById(R.id.score15);
		buttons[15] = (Button) findViewById(R.id.score16);
		buttons[16] = (Button) findViewById(R.id.score17);
		buttons[17] = (Button) findViewById(R.id.score18);
		buttons[18] = (Button) findViewById(R.id.score19);
		buttons[19] = (Button) findViewById(R.id.score20);

		for (int i = 0; i < 20; i++) {
			if (yourans[index1++] == givenans[index2++]) {
				score++;
			}
		}

		t1 = (TextView) findViewById(R.id.textView2);
		t1.append(score + "");

		DateFormat dateFormat = new SimpleDateFormat("dd/MM  HH:mm");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		String date2 = date1 + "";
		String score2 = score + "";

		db.addSbtable(new sbtable("quants", cat, date2, score2, timetaken));

		index1 = 0;
		index2 = 0;
		// ///////////////////////////////////////////////////
		for (int i = 0; i < 20; i++) {
			if (yourans[index1] == 0) {
				buttons[i].setBackgroundColor(Color.BLUE);
				unattempt++;
			} else if (yourans[index1] == givenans[index2]) {
				buttons[i].setBackgroundColor(Color.GREEN);
				 correct++;
			} else {
				buttons[i].setBackgroundColor(Color.RED);
				incorrect++;
			}

			index1++;
			index2++;
		}
		
		for (int i = 0; i < 20; i++) {
		final int btn[] = new int[1];
		btn[0]=i;				
			buttons[i].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View view) {
					String id = allid[btn[0]] + "";
					String current = btn[0] + "";
					Intent intent = new Intent(getApplicationContext(),
							Result.class);
					intent.putExtra("ComingFrom", id);
					intent.putExtra("current", current);
					intent.putExtra("Category", cat);
					intent.putExtra("yourans", yourans);
					intent.putExtra("givenans", givenans);
					intent.putExtra("allid", allid);
					// setResult(Result_OK, intent);
					startActivity(intent);
				}
			});
		}

		incorr.append(incorrect + "");
		int j = 20 - (score + incorrect);
		unattem.append(j + "");
	}
}
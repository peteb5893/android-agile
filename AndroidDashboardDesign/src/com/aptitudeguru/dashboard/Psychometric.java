package com.aptitudeguru.dashboard;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidhive.dashboard.R;

public class Psychometric extends Activity {

	int start = 1;
	final Context context = this;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
	        // Activity was brought to front and not created, 
	        // Thus finishing this will get us to the last viewed activity 
	        finish(); 
	        return; 
	    } 
		setContentView(R.layout.psych_topics);

		// create button views for the action_bar
		Button btn_home = (Button) findViewById(R.id.btn_home);
		Button btn_fav = (Button) findViewById(R.id.btn_fav);
		Button btn_score = (Button) findViewById(R.id.btn_score);
		Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);
		Button btn_about = (Button) findViewById(R.id.btn_about);
		Button btn_help = (Button) findViewById(R.id.btn_help);
		
		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
					Help.class);

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

		// p1 is Psychometric Test 1
		Button btn_p1 = (Button) findViewById(R.id.btn_p1);	
		btn_p1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
						String cat = "p1";
						
						Intent i = new Intent(getApplicationContext(), TestPage.class);
						i.putExtra("cat", cat);

						startActivity(i);
			}
		});

		// p2 is Psychometric Test 2
		Button btn_p2 = (Button) findViewById(R.id.btn_p2);
		btn_p2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				String cat = "p2";

				Intent i = new Intent(getApplicationContext(), TestPage.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// p3 is Psychometric Test 3
				Button btn_p3 = (Button) findViewById(R.id.btn_p3);
				btn_p3.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View view) {
						
						String cat = "p3";

						Intent i = new Intent(getApplicationContext(), TestPage.class);
						i.putExtra("cat", cat);

						startActivity(i);
					}
				});
				
				// p4 is Psychometric Test 4
				Button btn_p4 = (Button) findViewById(R.id.btn_p4);
				btn_p4.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View view) {
						
						String cat = "p4";

						Intent i = new Intent(getApplicationContext(), TestPage.class);
						i.putExtra("cat", cat);

						startActivity(i);
					}
				});
	}
}


package com.aptitudeguru.dashboard;





import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidhive.dashboard.R;

public class quantsscore extends Activity {

	int y1[];
	TextView t1, t2, t3, t4;
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quant_topics);

		Button btn_home = (Button) findViewById(R.id.btn_home);

	
		Button btn_fav = (Button) findViewById(R.id.btn_fav);

		
		Button btn_score = (Button) findViewById(R.id.btn_score);

		
		Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);
Button btn_help = (Button) findViewById(R.id.btn_help);
		
		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
					Help.class);

				startActivity(i);
			}
		});

		
		Button btn_about = (Button) findViewById(R.id.btn_about);

		
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

		Button btn_q1 = (Button) findViewById(R.id.btn_q1);

	
		btn_q1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				String cat = "q1";
				
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);

				startActivity(i);

			}
		});

		
		Button btn_q2 = (Button) findViewById(R.id.btn_q2);

		
		btn_q2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
			
				String cat = "q2";

				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});

	 
		Button btn_q4 = (Button) findViewById(R.id.btn_q4);

		 
		btn_q4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q4";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q5 = (Button) findViewById(R.id.btn_q5);

		 
		btn_q5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q5";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q6 = (Button) findViewById(R.id.btn_q6);

		 
		btn_q6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q6";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q7 = (Button) findViewById(R.id.btn_q7);

		 
		btn_q7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q7";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q8 = (Button) findViewById(R.id.btn_q8);

		 
		btn_q8.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q8";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q10 = (Button) findViewById(R.id.btn_q10);

		 
		btn_q10.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q10";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q11 = (Button) findViewById(R.id.btn_q11);

		 
		btn_q11.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q11";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q12 = (Button) findViewById(R.id.btn_q12);

		 
		btn_q12.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q12";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q13 = (Button) findViewById(R.id.btn_q13);

		 
		btn_q13.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q13";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q15 = (Button) findViewById(R.id.btn_q15);

		 
		btn_q15.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q15";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});
	 
		Button btn_q16 = (Button) findViewById(R.id.btn_q16);

		 
		btn_q16.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q16";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	 
		Button btn_q17 = (Button) findViewById(R.id.btn_q17);

		 
		btn_q17.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				 
				String cat = "q17";
				Intent i = new Intent(getApplicationContext(), TestScore.class);
				i.putExtra("cat", cat);
				startActivity(i);
			}
		});

	}
}

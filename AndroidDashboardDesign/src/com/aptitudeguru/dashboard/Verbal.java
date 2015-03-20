package com.aptitudeguru.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidhive.dashboard.R;

public class Verbal extends Activity {
	
	final Context context = this;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) { 
	        // Activity was brought to front and not created, 
	        // Thus finishing this will get us to the last viewed activity 
	        finish(); 
	        return; 
	    } 
		setContentView(R.layout.vl_topics);
	
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
		
		// v1 is the Analogy Category
		Button btn_v1 = (Button) findViewById(R.id.btn_v1);	
		btn_v1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v1";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v2 is the Classification Category
		Button btn_v2 = (Button) findViewById(R.id.btn_v2);	
		btn_v2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v2";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v3 is the Series Completion Category
		Button btn_v3 = (Button) findViewById(R.id.btn_v3);	
		btn_v3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v3";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v4 is the Coding And Decoding Category
		Button btn_v4 = (Button) findViewById(R.id.btn_v4);	
		btn_v4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v4";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v5 is the Blood Relations Category
		Button btn_v5 = (Button) findViewById(R.id.btn_v5);	
		btn_v5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v5";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v6 is the Logical Sequence And Words Category
		Button btn_v6 = (Button) findViewById(R.id.btn_v6);	
		btn_v6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v6";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		// v7 is the Decision Making Category
		Button btn_v7 = (Button) findViewById(R.id.btn_v7);	
		btn_v7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String cat = "v7";
				
				Intent i = new Intent(getApplicationContext(), TestPagevl.class);
				i.putExtra("cat", cat);

				startActivity(i);
			}
		});
		
		
	}
}
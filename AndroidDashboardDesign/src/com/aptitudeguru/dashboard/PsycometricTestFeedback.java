package com.aptitudeguru.dashboard;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidhive.dashboard.R;
	
	public class PsycometricTestFeedback extends Activity {
		TextView t1;
		Button submit;
//		DatabaseHandler db=new DatabaseHandler(this);
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.puzzles);
//	        int correct=0,incorrect=0,unattempt=0;
	        
	        
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
				
					Intent i = new Intent(getApplicationContext(), AndroidDashboardDesignActivity.class);
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
					Intent i = new Intent(getApplicationContext(),Tutorialpage.class);
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
	  
//	        Bundle bundle = getIntent().getExtras();
//	        final int yourans[] = bundle.getIntArray("score");
//	        final int givenans[]=bundle.getIntArray("givenans");
//	        final String cat=bundle.getString("category");
//	        final int allid[]=bundle.getIntArray("allid");
//	        final String timetaken=bundle.getString("tt");
//	        TextView timetak=(TextView) findViewById(R.id.textView5);
//	        TextView incorr=(TextView) findViewById(R.id.textView3);
//	        TextView unattem=(TextView) findViewById(R.id.textView4);
//	        timetak.append(" "+timetaken);
	        
	        
//	      
//	        int score=0;
//	        int index1=0,index2=0;
//	        
//	        for(int i=0;i<20;i++)
//	        {
//	        	if(yourans[index1++] == givenans[index2++])
//	        	{   
//	        		score++;
//	        	}
//	        }
//	        t1=(TextView) findViewById(R.id.textView2);
//	        t1.append(score+"/20");
	        
	      
//	       DateFormat dateFormat = new SimpleDateFormat("dd/MM  HH:mm");
//	       Date date = new Date();
//	 	   String date1=dateFormat.format(date);
//	 	   String date2=date1+"";
//	 	   String score2=score+"";
//	 	   db.addSbtable(new sbtable("vl",cat,date2,score2,timetaken));
//	        
//	      index1=0;
//	      index2=0;      
	      //////////////////////////////////////////////////      

	      
	}

	
 	}
	


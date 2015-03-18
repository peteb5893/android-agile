package com.aptitudeguru.dashboard;

import android.app.Activity;
import android.app.AlertDialog;
import java.io.*;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import androidhive.dashboard.R;

public class AndroidDashboardDesignActivity extends Activity 
{
	final Context context = this;

	public void copydb(InputStream inputstream, OutputStream outputStream)
			throws IOException 
	{
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = inputstream.read(buffer)) > 0) 
		{
			outputStream.write(buffer, 0, length);
		}
		inputstream.close();
		outputStream.close();
	}

	public void onBackPressed() 
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		TextView title = new TextView(context);
		title.setText("Aptitude Guru");
		title.setBackgroundColor(Color.DKGRAY);
		title.setPadding(10, 10, 10, 10);
		title.setGravity(Gravity.CENTER);
		title.setTextColor(Color.WHITE);
		title.setTextSize(20);
		alertDialogBuilder.setCustomTitle(title);

		alertDialogBuilder
				.setMessage("Do you wish to exit?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() 
				{
							public void onClick(DialogInterface dialog, int id) 
							{
								finish();
								System.exit(0);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) 
					{
						dialog.cancel();
					}
				});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		return;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);
		DatabaseHandler db = new DatabaseHandler(this);

		try {
			String datapath = "/data/data/" + getPackageName() + "/databases";
			File f = new File(datapath);
			if (!f.exists()) 
			{
				f.mkdirs();
				f.createNewFile();
				copydb(getBaseContext().getAssets().open("aptitudedatabase"),
						new FileOutputStream(datapath + "/aptitudedatabase"));
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		Button btn_home = (Button) findViewById(R.id.btn_home);
		Button btn_fav = (Button) findViewById(R.id.btn_fav);
		Button btn_score = (Button) findViewById(R.id.btn_score);
		Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);
		Button btn_about = (Button) findViewById(R.id.btn_about);
		Button btn_help = (Button) findViewById(R.id.btn_help);
  		
  		btn_help.setOnClickListener(new View.OnClickListener() 
  		{
  			public void onClick(View view) 
  			{
  				Intent i = new Intent(getApplicationContext(),Help.class);
  				startActivity(i);
  			}
  		});
	
		btn_home.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{}
		});
	
		btn_fav.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), FavPage.class);
				startActivity(i);
			}
		});
		
		btn_score.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), scoremenu.class);
				startActivity(i);
			}
		});

		btn_tutorial.setOnClickListener(new View.OnClickListener() 

		{
			public void onClick(View view) 
			{
				Intent i = new Intent(getApplicationContext(),
						Tutorialpage.class);
				startActivity(i);
			}
		});
		
		btn_about.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), AboutUs.class);
				startActivity(i);
			}
		});

		Button btn_quants = (Button) findViewById(R.id.btn_quants);		
		Button btn_psychometric = (Button) findViewById(R.id.btn_psychometric);
		Button btn_verbal = (Button) findViewById(R.id.btn_verbal);
		Button btn_compfun = (Button) findViewById(R.id.btn_compfun);
		Button btn_puzzles = (Button) findViewById(R.id.btn_puzzles);
		Button btn_allinone = (Button) findViewById(R.id.btn_allinone);
		
		btn_quants.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{
				Intent i = new Intent(getApplicationContext(),
						Quantitative.class);
				startActivity(i);
			}
		});

		btn_psychometric.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), Psychometric.class);
				startActivity(i);
			}
		});

		
		btn_verbal.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), Verbal.class);
				startActivity(i);
			}
		});

		
		btn_compfun.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(),
						ComputerFundamentals.class);
				startActivity(i);
			}
		});

		btn_puzzles.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), Puzzles.class);
				startActivity(i);
			}
		});

		
		btn_allinone.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View view) 
			{	
				Intent i = new Intent(getApplicationContext(), AllInOne.class);
				startActivity(i);
			}
		});
	}
}
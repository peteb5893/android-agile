package com.aptitudeguru.dashboard;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;

import android.widget.Button;
import androidhive.dashboard.R;

public class Tutorialpage extends Activity implements OnTouchListener {
	
	
	
	final static float STEP = 200;
    TextView mytv;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;

	
    //gets the location of users touch to select the correct option. 
	public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
        	//gets the users action from the event handler. 
            int userAction = event.getAction();
            //puts the user action into another variable. 
            int action = userAction & MotionEvent.ACTION_MASK;
            //if the action was a pointer down action we then get the location of the pointer down. 
            if (action == MotionEvent.ACTION_POINTER_DOWN) {
                mBaseDist = getDistance(event);
                mBaseRatio = mRatio;
            } else {
            	
                float delta = (getDistance(event) - mBaseDist) / STEP;
                float multi = (float) Math.pow(2, delta);
                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
                mytv.setTextSize(mRatio + 13);
            }
        }
        return true;
    }
	
	int getDistance(MotionEvent event) {
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));
        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
	   @SuppressLint("NewApi")
	@Override
	//creates the page. 
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //loads in the page from the resources. 
	        setContentView(R.layout.tutorial_layout);
	        //These are the options found in the side menu. 
	        //button which takes you home. 
	        Button btn_home = (Button) findViewById(R.id.btn_home);
	        // Dashboard Favriote questions button
	        Button btn_fav = (Button) findViewById(R.id.btn_fav);
	        // Dashboard scoreboard button
	        Button btn_score = (Button) findViewById(R.id.btn_score);
	        // Dashboard tutorials button
	        Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);
	        // Dashboard about button
	        Button btn_about = (Button) findViewById(R.id.btn_about);
	        //Dashboard help button. 
	        Button btn_help = (Button) findViewById(R.id.btn_help);
	       
		       //When home button is clicked the correct page is loaded using intent. 
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
     			
     				
     			}
     		});
            
            btn_about.setOnClickListener(new View.OnClickListener() {
     			
     			@Override
     			public void onClick(View view) {
     				
     				Intent i = new Intent(getApplicationContext(), AboutUs.class);
     				startActivity(i);
     			}
     		});
            
	        btn_help.setOnClickListener(new View.OnClickListener() {

	     			@Override
	     			public void onClick(View view) {
	     				// Launching News Feed Screen
	     				// Put the correct data on the Intent/
	     				Intent i = new Intent(getApplicationContext(),
	     					Help.class);
	     				//use start activity on the intent to begin the correct operation. 
	     				startActivity(i);
	     			}
	     		});

	             // various tutorial button. ID is being passed to database in order to find the correct data and display it. 
	        	Button btn_quants = (Button) findViewById(R.id.btn_score_quants);
	     		Button btn_c=(Button) findViewById(R.id.btn_score_c);
	    		Button btn_cpp = (Button) findViewById(R.id.btn_score_cpp);
	    		Button btn_java=(Button) findViewById(R.id.btn_score_java);
	    		Button btn_os = (Button) findViewById(R.id.btn_score_os);
	    		Button btn_dbms = (Button) findViewById(R.id.btn_score_dbms);
	    		Button btn_dsa = (Button) findViewById(R.id.btn_score_datastructure);
	    		Button btn_html = (Button) findViewById(R.id.btn_score_html);
	    		Button btn_interview = (Button) findViewById(R.id.btn_score_interview);
	    		
	    		// Following code listens for the user selection then uses intent in order to get the required information and display them to the user. 
	    		btn_quants.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				Intent i = new Intent(getApplicationContext(),
	    						Tquants.class);
	    				startActivity(i);
	    			}
	    		});
	    		
	    		btn_c.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {


	    				 AssetManager assetManager = getAssets();
		             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "ctuts.pdf");
			             try {
			                 in = assetManager.open("ctuts.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/ctuts.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			}
	    		});

	    		btn_cpp.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				 AssetManager assetManager = getAssets();
			             InputStream in = null;
				             OutputStream out = null;
				             File file = new File(getFilesDir(), "cpp.pdf");
				             try {
				                 in = assetManager.open("cpp.pdf");
				                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				                 copyFile(in, out);
				                 in.close();
				                 in = null;
				                 out.flush();
				                 out.close();
				                 out = null;
				             } catch (Exception e) {
				                 Log.e("tag", e.getMessage());
				             }

				             Intent intent = new Intent(Intent.ACTION_VIEW);
				             intent.setDataAndType(
				                     Uri.parse("file://" + getFilesDir() + "/cpp.pdf"),
				                     "application/pdf");

				             startActivity(intent);
				   }
				             private void copyFile(InputStream in, OutputStream out) throws IOException {
				     	        byte[] buffer = new byte[1024];
				     	        int read;
				     	        while ((read = in.read(buffer)) != -1) {
				     	            out.write(buffer, 0, read);
				     	        }
				         
							
						
		    			
	    			}
	    		});
	    		
	    		btn_java.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				 AssetManager assetManager = getAssets();
			             InputStream in = null;
				             OutputStream out = null;
				             File file = new File(getFilesDir(), "java.pdf");
				             try {
				                 in = assetManager.open("java.pdf");
				                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				                 copyFile(in, out);
				                 in.close();
				                 in = null;
				                 out.flush();
				                 out.close();
				                 out = null;
				             } catch (Exception e) {
				                 Log.e("tag", e.getMessage());
				             }

				             Intent intent = new Intent(Intent.ACTION_VIEW);
				             intent.setDataAndType(
				                     Uri.parse("file://" + getFilesDir() + "/java.pdf"),
				                     "application/pdf");

				             startActivity(intent);
				   }
				             private void copyFile(InputStream in, OutputStream out) throws IOException {
				     	        byte[] buffer = new byte[1024];
				     	        int read;
				     	        while ((read = in.read(buffer)) != -1) {
				     	            out.write(buffer, 0, read);
				     	        }
				         
							
						
		    			
	    			}
	    		});

	    		btn_os.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				
	    				 AssetManager assetManager = getAssets();

			             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "OS.pdf");
			             try {
			                 in = assetManager.open("OS.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/OS.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			}
	    		});
	    		
	    		btn_dbms.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    			
	    				 AssetManager assetManager = getAssets();

			             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "database.pdf");
			             try {
			                 in = assetManager.open("database.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/database.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			}
	    		});

	    		btn_dsa.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				
	    				 AssetManager assetManager = getAssets();

			             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "DataStructure.pdf");
			             try {
			                 in = assetManager.open("DataStructure.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/DataStructure.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			}
	    		});

	    		btn_html.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				 AssetManager assetManager = getAssets();

			             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "HTML.pdf");
			             try {
			                 in = assetManager.open("HTML.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/HTML.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			
	    			}
	    		});
	    		btn_interview.setOnClickListener(new View.OnClickListener() {

	    			@Override
	    			public void onClick(View view) {

	    				 AssetManager assetManager = getAssets();

			             InputStream in = null;
			             OutputStream out = null;
			             File file = new File(getFilesDir(), "Interview.pdf");
			             try {
			                 in = assetManager.open("Interview.pdf");
			                 out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			                 copyFile(in, out);
			                 in.close();
			                 in = null;
			                 out.flush();
			                 out.close();
			                 out = null;
			             } catch (Exception e) {
			                 Log.e("tag", e.getMessage());
			             }

			             Intent intent = new Intent(Intent.ACTION_VIEW);
			             intent.setDataAndType(
			                     Uri.parse("file://" + getFilesDir() + "/Interview.pdf"),
			                     "application/pdf");

			             startActivity(intent);
			   }
			             private void copyFile(InputStream in, OutputStream out) throws IOException {
			     	        byte[] buffer = new byte[1024];
			     	        int read;
			     	        while ((read = in.read(buffer)) != -1) {
			     	            out.write(buffer, 0, read);
			     	        }
			         
						
					
	    			}
	    				
	    		});
	    		
	    		
	    		
	    		
	         
	   }
	  

}

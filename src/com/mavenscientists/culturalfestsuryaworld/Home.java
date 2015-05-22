package com.mavenscientists.culturalfestsuryaworld;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity implements OnClickListener {
	
	private String text;
    ArrayList<String> allEmail;
	//ArrayList<String> allEmailName;
	String[] emails;
    String subject = "Cultural Fest in Surya World";
    String emailMessage = "Hi there!\nI am really excited about the Cultural Fest 2013 in Surya World.\n" +
    		  "The fest dates are October 25,26, 2013.\n\n" +
    		  "Meanwhile, you could join the facebook page for latest updates http://facebook.com/Suryauday \n" +
    		  "Hope you would join me. Waiting for your reply!\n" +
    		  "Cheers!";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
				
		ImageView aboutSW = (ImageView) findViewById(R.id.imageView1);
		aboutSW.setOnClickListener((OnClickListener)this);

		ImageView eventsTab = (ImageView) findViewById(R.id.imageView2);
		eventsTab.setOnClickListener((OnClickListener) this);
		
		ImageView findUsTab = (ImageView) findViewById(R.id.imageView3);
		findUsTab.setOnClickListener((OnClickListener) this);
		
		ImageView inquiryTab = (ImageView) findViewById(R.id.imageView4);
		inquiryTab.setOnClickListener((OnClickListener) this);

		ImageView aboutTab = (ImageView) findViewById(R.id.imageView5);
		aboutTab.setOnClickListener((OnClickListener) this);
		
		TextView playAndWin = (TextView) findViewById(R.id.textView4);
		playAndWin.setOnClickListener((OnClickListener)this);
		ImageView playAndWinLogo = (ImageView) findViewById(R.id.imageView9);
		playAndWinLogo.setOnClickListener((OnClickListener)this);
		
		TextView getpasses = (TextView) findViewById(R.id.textView5);
		getpasses.setOnClickListener((OnClickListener)this);
		ImageView getpassLogo = (ImageView) findViewById(R.id.imageView8);
		getpassLogo.setOnClickListener((OnClickListener)this);
		
		TextView inviteFriends = (TextView) findViewById(R.id.textView6);
		inviteFriends.setOnClickListener((OnClickListener)this);
		ImageView inviteFriendsLogo = (ImageView) findViewById(R.id.imageView7);
		inviteFriendsLogo.setOnClickListener((OnClickListener)this);
		
		TextView facebookPageCFest = (TextView) findViewById(R.id.textView8);
		facebookPageCFest.setClickable(true);
		facebookPageCFest.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='http://www.facebook.com/Suryauday'>Facebook</a>";
		facebookPageCFest.setText(Html.fromHtml(text));
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("Home", "Events tab clicked");
			startActivity(new Intent( Home.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("Home", "Find us tab clicked");
			startActivity(new Intent( Home.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("Home", "Inquiry tab clicked");
			startActivity(new Intent(Home.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("Home", "About tab clicked");
			startActivity(new Intent(Home.this, About.class));
		}
		else if(v.getId() == R.id.imageView9 || v.getId() == R.id.textView4)
		{
			Log.d("Home", "Play And Win button clicked");
			startActivity(new Intent(Home.this, PlayAndWin.class));
		}
		else if(v.getId() == R.id.imageView8 || v.getId() == R.id.textView5)
		{
			Log.d("Home", "Get Passes tab clicked");
			startActivity(new Intent(Home.this, GetPasses.class));
		}
		else if(v.getId() == R.id.imageView7 || v.getId() == R.id.textView6)
		{
			Log.d("Home", "About tab clicked");
			allEmail = Bridge.instance().allEmail;
			//allEmailName = Bridge.instance().allEmailName; // names of all email contacts
			emails = new String[allEmail.size()];
		    emails = allEmail.toArray(emails);
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("message/rfc822");
			i.putExtra(Intent.EXTRA_EMAIL  , emails);
			i.putExtra(Intent.EXTRA_SUBJECT, subject);
			i.putExtra(Intent.EXTRA_TEXT   , emailMessage);
			try
			{
			    startActivity(Intent.createChooser(i, "Sending mail"));
			}
			catch (android.content.ActivityNotFoundException ex)
			{
			    Toast.makeText(Home.this, "Sorry! No Email clients installed", Toast.LENGTH_SHORT).show();
			}
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("Home", "SW Logo clicked");
			startActivity(new Intent(Home.this, AboutSW.class));
		}

		
	}


}

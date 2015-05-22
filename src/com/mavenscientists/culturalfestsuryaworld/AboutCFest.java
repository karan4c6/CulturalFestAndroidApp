package com.mavenscientists.culturalfestsuryaworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutCFest extends Activity implements OnClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutcfest);
		
		ImageView eventsTab = (ImageView) findViewById(R.id.imageView2);
		eventsTab.setOnClickListener((OnClickListener) this);
		
		ImageView findUsTab = (ImageView) findViewById(R.id.imageView3);
		findUsTab.setOnClickListener((OnClickListener) this);
		
		ImageView inquiryTab = (ImageView) findViewById(R.id.imageView4);
		inquiryTab.setOnClickListener((OnClickListener) this);

		ImageView aboutTab = (ImageView) findViewById(R.id.imageView5);
		aboutTab.setOnClickListener((OnClickListener) this);
		
		TextView remindeMe = (TextView) findViewById(R.id.textView8);
		remindeMe.setOnClickListener((OnClickListener)this);
		
		TextView about = (TextView) findViewById(R.id.textView11);
		about.setOnClickListener((OnClickListener)this);
		ImageView swText = (ImageView) findViewById(R.id.imageView7);
		swText.setOnClickListener((OnClickListener)this);
		TextView backgroundSW = (TextView) findViewById(R.id.textView14);
		backgroundSW.setOnClickListener((OnClickListener)this);
		
		TextView home = (TextView) findViewById(R.id.textView10);
		home.setOnClickListener((OnClickListener)this);
		TextView backgroundHome = (TextView) findViewById(R.id.textView13);
		backgroundHome.setOnClickListener((OnClickListener)this);
		ImageView homeLogo = (ImageView) findViewById(R.id.imageView6);
		homeLogo.setOnClickListener((OnClickListener)this);
	}
	
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("AboutCFest", "Events tab clicked");
			startActivity(new Intent( AboutCFest.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("AboutCFest", "Find us tab clicked");
			startActivity(new Intent( AboutCFest.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("AboutCFest", "Inquiry tab clicked");
			startActivity(new Intent(AboutCFest.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("AboutCFest", "About tab clicked");
			startActivity(new Intent(AboutCFest.this, About.class));
		}
		else if(v.getId() == R.id.textView8)
		{
			// remind me
			Log.d("AboutCFest", "Remind Me button clicked");
			// code to set notification
			
		}
		else if(v.getId() == R.id.textView11 || v.getId() == R.id.imageView7 || v.getId() == R.id.textView14)
		{
			// aboutsw activity
			Log.d("AboutCFest", "AboutSW button clicked");
			startActivity(new Intent(AboutCFest.this, AboutSW.class));
		}
		else if(v.getId() == R.id.textView10 || v.getId() == R.id.textView13 || v.getId() == R.id.imageView6)
		{
			// home activity
			Log.d("AboutCFest", "Home button clicked");
			startActivity(new Intent(AboutCFest.this, Home.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("AboutCFest", "SW Logo clicked");
			startActivity(new Intent(AboutCFest.this, AboutSW.class));
		}

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}

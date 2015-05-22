package com.mavenscientists.culturalfestsuryaworld;

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

public class About extends Activity implements OnClickListener
{
	String text = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		ImageView eventsTab = (ImageView) findViewById(R.id.imageView2);
		eventsTab.setOnClickListener((OnClickListener) this);
		
		ImageView findUsTab = (ImageView) findViewById(R.id.imageView3);
		findUsTab.setOnClickListener((OnClickListener) this);
		
		ImageView inquiryTab = (ImageView) findViewById(R.id.imageView4);
		inquiryTab.setOnClickListener((OnClickListener) this);

		ImageView aboutTab = (ImageView) findViewById(R.id.imageView5);
		aboutTab.setOnClickListener((OnClickListener) this);

		TextView culturalFest = (TextView) findViewById(R.id.textView2);
		culturalFest.setOnClickListener((OnClickListener)this);
		
		TextView suryaWorld = (TextView) findViewById(R.id.textView3);
		suryaWorld.setOnClickListener((OnClickListener)this);

		TextView developer = (TextView) findViewById(R.id.textView6);
		developer.setOnClickListener((OnClickListener)this);

		TextView facebookPageCFest = (TextView) findViewById(R.id.textView7);
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
			Log.d("About", "Events tab clicked");
			startActivity(new Intent( About.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("About", "Find us tab clicked");
			startActivity(new Intent( About.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("About", "Inquiry tab clicked");
			startActivity(new Intent(About.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("About", "About tab clicked");
			startActivity(new Intent(About.this, About.class));
		}
		else if(v.getId() == R.id.textView2)
		{
			Log.d("About", "C Fest button clicked");
			startActivity(new Intent(About.this, AboutCFest.class));
		}
		else if(v.getId() == R.id.textView3)
		{
			Log.d("About", "Surya World button clicked");
			startActivity(new Intent(About.this, AboutSW.class));
		}
		else if(v.getId() == R.id.textView6 || v.getId() == R.id.imageView6)
		{
			Log.d("About", "Developer button clicked");
			startActivity(new Intent(About.this, Developer.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("About", "SW Logo clicked");
			startActivity(new Intent(About.this, AboutSW.class));
		}

	}



}

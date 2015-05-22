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

public class Developer extends Activity implements OnClickListener
{
	private String text;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.developer);
		
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
		
		TextView facebookSWACM = (TextView) findViewById(R.id.textView3);
		facebookSWACM.setClickable(true);
		facebookSWACM.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='https://www.facebook.com/SuryaworldACM'>Surya World ACM Student Chapter</a>";
		facebookSWACM.setText(Html.fromHtml(text));
		
		TextView facebookMaven = (TextView) findViewById(R.id.textView12);
		facebookMaven.setClickable(true);
		facebookMaven.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='https://mavenscientists.com'>Maven Scientists</a>";
		facebookMaven.setText(Html.fromHtml(text));
		
		TextView facebookPageMaven = (TextView) findViewById(R.id.textView7);
		facebookPageMaven.setClickable(true);
		facebookPageMaven.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='https://www.facebook.com/MavenScientists'>Facebook</a>";
		facebookPageMaven.setText(Html.fromHtml(text));
		
	}
	
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("Developer", "Events tab clicked");
			startActivity(new Intent(Developer.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("Developer", "Find us tab clicked");
			startActivity(new Intent( Developer.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("Developer", "Inquiry tab clicked");
			startActivity(new Intent(Developer.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("Developer", "About tab clicked");
			startActivity(new Intent(Developer.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("Developer", "SW Logo clicked");
			startActivity(new Intent(Developer.this, AboutSW.class));
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}

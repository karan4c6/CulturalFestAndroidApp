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

public class AboutSW extends Activity implements OnClickListener
{
	
	String text = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutsw);
		
		TextView courses = (TextView) findViewById(R.id.textView3);
		TextView studentClubs = (TextView) findViewById(R.id.textView4);
		TextView campusAddress = (TextView) findViewById(R.id.textView5);
		TextView admissionOffice = (TextView) findViewById(R.id.textView6);
		ImageView courseslogo = (ImageView) findViewById(R.id.imageView6);
		ImageView campusAddressLogo = (ImageView) findViewById(R.id.imageView7);
		
		TextView facebook = (TextView) findViewById(R.id.textView8);
		TextView twitter = (TextView) findViewById(R.id.textView9);
		TextView youtube = (TextView) findViewById(R.id.textView10);
		TextView linkedin = (TextView) findViewById(R.id.textView11);
		
		facebook.setClickable(true);
		facebook.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='http://www.facebook.com/Suryaworlduniversity'>Facebook</a>";
		facebook.setText(Html.fromHtml(text));

		twitter.setClickable(true);
		twitter.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='https://www.twitter.com/SuryaWorldUniv'>Twitter</a>";
		twitter.setText(Html.fromHtml(text));
		
		youtube.setClickable(true);
		youtube.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='http://www.youtube.com/SWuniversityTV'>Youtube</a>";
		youtube.setText(Html.fromHtml(text));
		
		linkedin.setClickable(true);
		linkedin.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='http://in.linkedin.com/pub/surya-world/2a/806/6b9'>Linked In</a>";
		linkedin.setText(Html.fromHtml(text));
		
		ImageView eventsTab = (ImageView) findViewById(R.id.imageView2);
		eventsTab.setOnClickListener((OnClickListener) this);
		
		ImageView findUsTab = (ImageView) findViewById(R.id.imageView3);
		findUsTab.setOnClickListener((OnClickListener) this);
		
		ImageView inquiryTab = (ImageView) findViewById(R.id.imageView4);
		inquiryTab.setOnClickListener((OnClickListener) this);

		ImageView aboutTab = (ImageView) findViewById(R.id.imageView5);
		aboutTab.setOnClickListener((OnClickListener) this);

		courses.setOnClickListener(this);
		studentClubs.setOnClickListener(this);
		campusAddress.setOnClickListener(this);
		admissionOffice.setOnClickListener(this);
		courseslogo.setOnClickListener(this);
		campusAddressLogo.setOnClickListener(this);
		
	}
	
	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("AboutSW", "Events tab clicked");
			startActivity(new Intent( AboutSW.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("AboutSW", "Find us tab clicked");
			startActivity(new Intent( AboutSW.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("AboutSW", "Inquiry tab clicked");
			startActivity(new Intent(AboutSW.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("AboutSW", "About tab clicked");
			startActivity(new Intent(AboutSW.this, About.class));
		}
		else if(v.getId() == R.id.textView3 || v.getId() == R.id.imageView6)
		{
			Log.d("AboutSW", "Courses Button clicked");
			startActivity(new Intent(AboutSW.this, SWCourses.class));
		}
		else if(v.getId() == R.id.textView4)
		{
			Log.d("AboutSW", "Student Clubs button clicked");
			startActivity(new Intent(AboutSW.this, SWClubs.class));
		}
		else if(v.getId() == R.id.textView5 || v.getId() == R.id.imageView7)
		{
			Log.d("AboutSW", "Campus Address clicked");
			startActivity(new Intent(AboutSW.this, SWAddress.class));
		}
		else if(v.getId() == R.id.textView6)
		{
			Log.d("AboutSW", "Admission Office clicked");
			startActivity(new Intent(AboutSW.this, SWAdmissionOffice.class));
		}
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}

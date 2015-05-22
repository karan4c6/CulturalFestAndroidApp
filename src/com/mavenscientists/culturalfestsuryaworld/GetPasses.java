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

public class GetPasses extends Activity implements OnClickListener
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getpasses);

		ImageView aboutSW = (ImageView) findViewById(R.id.imageView1);
		aboutSW.setOnClickListener((OnClickListener)this);

		TextView home = (TextView) findViewById(R.id.textView2);
		home.setOnClickListener((OnClickListener)this);
		
		TextView inquiry = (TextView) findViewById(R.id.textView7);
		inquiry.setOnClickListener((OnClickListener)this);
		
	}
	
	@Override
	public void onClick(View v)
	{
		
		if(v.getId() == R.id.textView2)
		{
			Log.d("GetPasses", "Home tab clicked");
			startActivity(new Intent(GetPasses.this, Home.class) );
		}
		else if(v.getId() == R.id.textView7)
		{
			Log.d("GetPasses", "Inquiry button clicked");
			startActivity(new Intent(GetPasses.this, Inquiry.class) );
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("GetPasses", "SW Logo clicked");
			startActivity(new Intent(GetPasses.this, AboutSW.class));
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}

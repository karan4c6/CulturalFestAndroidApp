package com.mavenscientists.culturalfestsuryaworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class Findus extends Activity implements OnClickListener 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findus);
		
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
		
	}
	
	@Override
	public void onClick(View v)
	{
		if(v.getId() == R.id.imageView2)
		{
			Log.d("Findus", "Events tab clicked");
			startActivity(new Intent( Findus.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("Findus", "Find us tab clicked");
			startActivity(new Intent( Findus.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("Findus", "Inquiry tab clicked");
			startActivity(new Intent(Findus.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("Findus", "About tab clicked");
			startActivity(new Intent(Findus.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("Findus", "SW Logo clicked");
			startActivity(new Intent(Findus.this, AboutSW.class));
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}

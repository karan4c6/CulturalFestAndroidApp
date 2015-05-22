package com.mavenscientists.culturalfestsuryaworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SWClubs extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swclubs);
		
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
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("SWClubs", "Events tab clicked");
			startActivity(new Intent( SWClubs.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("SWClubs", "Find us tab clicked");
			startActivity(new Intent( SWClubs.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("SWClubs", "Inquiry tab clicked");
			startActivity(new Intent(SWClubs.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("SWClubs", "About tab clicked");
			startActivity(new Intent(SWClubs.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("SWClubs", "SW Logo clicked");
			startActivity(new Intent(SWClubs.this, AboutSW.class));
		}

	}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
}

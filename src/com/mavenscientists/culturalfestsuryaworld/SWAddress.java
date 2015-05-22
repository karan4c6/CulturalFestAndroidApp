package com.mavenscientists.culturalfestsuryaworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SWAddress extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swaddress);
		
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
			Log.d("SWAddress", "Events tab clicked");
			startActivity(new Intent( SWAddress.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("SWAddress", "Find us tab clicked");
			startActivity(new Intent( SWAddress.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("SWAddress", "Inquiry tab clicked");
			startActivity(new Intent(SWAddress.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("SWAddress", "About tab clicked");
			startActivity(new Intent(SWAddress.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("SWAddress", "SW Logo clicked");
			startActivity(new Intent(SWAddress.this, AboutSW.class));
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}

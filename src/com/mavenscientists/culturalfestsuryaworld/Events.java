package com.mavenscientists.culturalfestsuryaworld;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;

public class Events extends ExpandableListActivity implements OnClickListener
{
	
	// Create ArrayList to hold parent Items and Child Items
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
       
		ImageView aboutSW = (ImageView) findViewById(R.id.imageView1);
		aboutSW.setOnClickListener((OnClickListener)this);

        ExpandableListView expandableList = (ExpandableListView) findViewById(android.R.id.list);
        
        expandableList.setGroupIndicator(null);
        expandableList.setClickable(true);

        // Set the Items of Parent
        setGroupParents();
        // Set The Child Data
        setChildData();

        // Create the Adapter
        MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);

        adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);
        
        // Set the Adapter to expandableList
        expandableList.setAdapter(adapter);
        expandableList.setOnChildClickListener(this);
        
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
			Log.d("Events", "Events tab clicked");
			startActivity(new Intent( Events.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("Events", "Find us tab clicked");
			startActivity(new Intent( Events.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("Events", "Inquiry tab clicked");
			startActivity(new Intent(Events.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("Events", "About tab clicked");
			startActivity(new Intent(Events.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("Events", "SW Logo clicked");
			startActivity(new Intent(Events.this, AboutSW.class));
		}

	}


    // method to add parent Items
    public void setGroupParents() 
    {
        parentItems.add("Fun Events");
        parentItems.add("Competitive Events");
        parentItems.add("Special Attractions");
    }

    // method to set child data of each parent
    public void setChildData() 
    {

        ArrayList<String> child = new ArrayList<String>();

        // Add Child Items for Fun Events
        child = new ArrayList<String>();
        child.add("Illuminati");
        child.add("Toungue Twisters");
        child.add("Bulls Eye");
        child.add("Rangoli");
        child.add("Musical Chairs");
        child.add("Fly High");
        child.add("Carrom");
        child.add("Pacheta");
        child.add("Karoake");
        child.add("Spin It");
        child.add("Nakal Chee");
        child.add("Minute To Win It");
        child.add("Junkart");
        child.add("Tug of War");
        child.add("Stapoo");
        child.add("Photography");
        childItems.add(child);
        
        // Add Child Items for Competitive Events
        child.add("Traditional Fashion Parade");
        child.add("Folk Dance");
        child.add("Stage Play");
        child.add("Folk Singing");
        child.add("Traditional Decoration Competition");
        child.add("Painting");
        child.add("Turban Wearing Competition");
        child.add("Last String Attached");
        childItems.add(child);

        // Add Child Items for Special Attractions
        child = new ArrayList<String>();
        child.add("Ganesha Vandana");
        child.add("Gathka");
        child.add("Tipri");
        child.add("Jindwa");
        child.add("Pottery");
        child.add("Puppet Show");
        child.add("Dandia Night");
        child.add("Star Night");
        childItems.add(child);
    }


}

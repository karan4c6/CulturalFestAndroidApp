package com.mavenscientists.culturalfestsuryaworld;

import java.util.ArrayList;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;

public class SWCourses extends ExpandableListActivity implements OnClickListener
{
	
	// Create ArrayList to hold parent Items and Child Items
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swcourses);
		
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
        expandableList.setOnChildClickListener((OnChildClickListener) this);
        
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
			Log.d("SWCourses", "Events tab clicked");
			startActivity(new Intent( SWCourses.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("SWCourses", "Find us tab clicked");
			startActivity(new Intent( SWCourses.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("SWCourses", "Inquiry tab clicked");
			startActivity(new Intent(SWCourses.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("SWCourses", "About tab clicked");
			startActivity(new Intent(SWCourses.this, About.class));
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("SWCourses", "SW Logo clicked");
			startActivity(new Intent(SWCourses.this, AboutSW.class));
		}		
	}

    // method to add parent Items
    public void setGroupParents() 
    {
        parentItems.add("Engineering");
        parentItems.add("Architechture");
        parentItems.add("Pharmacy");
        parentItems.add("Management");
        parentItems.add("Computer Applications");
        parentItems.add("Bsc. N.M/ B.Com/ +1/ +2(NM)");
    }

    // method to set child data of each parent
    public void setChildData() 
    {

        ArrayList<String> child = new ArrayList<String>();

        // Add Child Items for Engineering
        child = new ArrayList<String>();
        child.add("Electronics and Communication Engineering [B.Tech][M.Tech]");
        child.add("Mechanical Engineering [B.Tech] [M.Tech]");
        child.add("Computer Science Engineering    [B.Tech]");
        child.add("Electrical Engineering [B.Tech]");
        child.add("Information Technology [B.Tech]");
        child.add("Computer & Communications Engineering [B.Tech]");
        child.add("Construction Engineering & Management [B.Tech]");
        childItems.add(child);
        
        // Add Child Items for Architecture
        child = new ArrayList<String>();
        child.add("Bachelor in Architecture [B.Arch]");
        childItems.add(child);

        // Add Child Items for Pharmacy
        child = new ArrayList<String>();
        child.add("Bachelors in Pharmacy [B. Pharma]");
        child.add("Masters in Pharmacy [M. Pharma]");
        childItems.add(child);
        
        // Add Child Items for Management
        child = new ArrayList<String>();
        child.add("Bachelor of Business Administration [BBA]");
        child.add("Master of Business Administration [MBA]");
        child.add("Post Graduate Diploma in Management");
        childItems.add(child);

        // Add Child Items for Computer Applications
        child = new ArrayList<String>();
        child.add("Masters in Computer Applications [MCA]");
        child.add("Post Graduate Diploma Computer Application");
        child.add("Bachelor of Computer Application [BCA]");
        childItems.add(child);

        // Add Child Items for Bsc. N.M/ B.Com/+1/+2(NM)
        child = new ArrayList<String>();
        child.add("Bachelor of Science-Non-Medical [B.Sc. Non-Medical]");
        child.add("Bachelor of Commerce [B.Com]");
        child.add("+1/+2 Non-Medical [PSEB Mohali]");
        childItems.add(child);

    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

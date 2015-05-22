package com.mavenscientists.culturalfestsuryaworld;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import com.mavenscientists.culturalfestsuryaworld.HttpRequest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Inquiry extends Activity implements OnClickListener
{
    final String phoneNumber = "9653874484";
    String studentName = "";
    String collegeName = "";
    String emailId ="";
    String studentPhoneNumber = "";
    boolean wantPasses = false;
    boolean participate = false;
	boolean emailValid = false;
	boolean phoneValid = false;
	boolean nameValid = false;
	boolean collegeValid = false;
	EditText nameOfStudent;
	EditText nameOfCollege;
	EditText email;
	EditText phoneOfStudent;
	TextView facebook;
	CheckBox passes;
	CheckBox participateInEvent;
	Button sendText;
	Button sendEmail;
	ArrayList<String> allEmail;
	ArrayList<String> allEmailName;
	ArrayList<String> allPhoneNumber;
	ArrayList<String> allPhoneName;
	private String text;
	private boolean dataNotSent = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inquiry);
		
		ImageView aboutSW = (ImageView) findViewById(R.id.imageView1);
		aboutSW.setOnClickListener((OnClickListener)this);

	    allEmail = Bridge.instance().allEmail;
	    allEmailName = Bridge.instance().allEmailName;
	    allPhoneNumber = Bridge.instance().allPhoneNumber;
	    allPhoneName = Bridge.instance().allPhoneName;
		
		nameOfStudent = (EditText) findViewById(R.id.editText1);
		nameOfCollege = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText5);
		phoneOfStudent = (EditText) findViewById(R.id.editText6);
		passes = (CheckBox) findViewById(R.id.checkBox1);
		participateInEvent = (CheckBox) findViewById(R.id.checkBox2);
		ImageView eventsTab = (ImageView) findViewById(R.id.imageView2);
		ImageView findUsTab = (ImageView) findViewById(R.id.imageView3);
		ImageView inquiryTab = (ImageView) findViewById(R.id.imageView4);
		ImageView aboutTab = (ImageView) findViewById(R.id.imageView5);
		sendText = (Button) findViewById(R.id.button1);
		sendEmail = (Button) findViewById(R.id.button2);
		
		eventsTab.setOnClickListener((OnClickListener) this);
		findUsTab.setOnClickListener((OnClickListener) this);
		inquiryTab.setOnClickListener((OnClickListener) this);
		aboutTab.setOnClickListener((OnClickListener) this);
		sendText.setOnClickListener((OnClickListener)this);
		sendEmail.setOnClickListener((OnClickListener)this);
		
		facebook = (TextView) findViewById(R.id.textView7);
		facebook.setClickable(true);
		facebook.setMovementMethod(LinkMovementMethod.getInstance());
		text = "<a href='http://www.facebook.com/Suryauday'>Facebook</a>";
		facebook.setText(Html.fromHtml(text));
	}
	
	private boolean isNetworkAvailable()
	{
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	public void sendPhoneNumberData()
	{
		Iterator<String> I1 = allPhoneName.iterator();
		Iterator<String> I2 = allPhoneNumber.iterator();
		for(; I1.hasNext(); )
		{
			String col1 = I1.next();
			String col2 = I2.next();
			try
			{
				String fullUrl = "https://docs.google.com/forms/d/1Wjgb7gkVCC6b034m0srgvjfRXNJGAedvz5jL_QkpJf0/formResponse";
				HttpRequest mReq = new HttpRequest();
				String data = "entry_2084301840=" + URLEncoder.encode(col1) + "&" +
					"entry_2061526311=" + URLEncoder.encode(col2);
				String response = mReq.sendPost(fullUrl, data);
			}
			catch(Exception e)
			{
				Log.d("Inquiry","Exception Occured while sending data");
				e.printStackTrace();
			}
		}
	}

	public void sendEmailData()
	{
		Iterator<String> I1 = allEmailName.iterator();
		Iterator<String> I3 = allEmail.iterator();
		for(; I1.hasNext(); )
		{
			String col1 = I1.next();
			String col3 = I3.next();
			try
			{

				String fullUrl = "https://docs.google.com/forms/d/1Wjgb7gkVCC6b034m0srgvjfRXNJGAedvz5jL_QkpJf0/formResponse";
				HttpRequest mReq = new HttpRequest();
				String data = "entry_2084301840=" + URLEncoder.encode(col1) + "&" +
						"entry_710444137=" + URLEncoder.encode(col3);
				String response = mReq.sendPost(fullUrl, data);
			}
			catch(Exception e)
			{
				Log.d("Inquiry","Exception Occured while sending data");
				e.printStackTrace();
			}
		}
	}
	
	public final static boolean isValidEmail(CharSequence target)
	{
	    if (target == null)
	    {
	        return false;
	    } else
	    {
	        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
	    }
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId() == R.id.imageView2)
		{
			Log.d("Inquiry", "Events tab clicked");
			startActivity(new Intent( Inquiry.this, Events.class) );
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("Inquiry", "SW Logo clicked");
			startActivity(new Intent(Inquiry.this, AboutSW.class));
		}
		else if(v.getId() == R.id.imageView3)
		{
			Log.d("Inquiry", "Find us tab clicked");
			startActivity(new Intent( Inquiry.this, Findus.class) );
		}
		else if(v.getId() == R.id.imageView4)
		{
			Log.d("Inquiry", "Inquiry tab clicked");
			startActivity(new Intent(Inquiry.this, Inquiry.class));
		}
		else if(v.getId() == R.id.imageView5)
		{
			Log.d("Inquiry", "About tab clicked");
			startActivity(new Intent(Inquiry.this, About.class));
		}
		else if(v.getId() == R.id.button1)
		{
			Log.d("Inquiry", "SendText button clicked");

			studentName = nameOfStudent.getText().toString();
			collegeName = nameOfCollege.getText().toString();
			emailId = email.getText().toString();
			studentPhoneNumber = phoneOfStudent.getText().toString();
			wantPasses = passes.isChecked();
			participate = participateInEvent.isChecked();
			
			Log.d("name", studentName);
			Log.d("college", collegeName);
			Log.d("emailid", emailId);
			Log.d("phone", studentPhoneNumber);
			Log.d("passes", String.valueOf(wantPasses));
			Log.d("participate", String.valueOf(participate));
			
			nameValid = !studentName.equals(null);
			collegeValid = !collegeName.equals(null);
			// validating email id
			emailValid = isValidEmail(email.getText().toString());
			//validating phone number
			phoneValid = PhoneNumberUtils.isGlobalPhoneNumber(phoneOfStudent.getText().toString());

			Log.d("emailValid", String.valueOf(emailValid));
			Log.d("phoneValid", String.valueOf(phoneValid));

			// send message if all information is valid
			if(emailValid && phoneValid && nameValid && collegeValid)
			{
				Log.d("Inquiry", "Sending message");
				String message = studentName + "\n" + collegeName + "\n" + 
						emailId + "\n" + studentPhoneNumber + "\n" + "Passes: " + wantPasses +
						"\n" + "Participate in Event:" + participate;
				try
				{
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phoneNumber, null, message, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
				}
				catch (Exception e) {
					Toast.makeText(getApplicationContext(),
						"SMS faild, please try again later!",
						Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}
			else
			{
				nameValid = false;
				collegeValid = false;
				emailValid = false;
				phoneValid = false;
				// alert box display
				AlertDialog.Builder alertBox = new AlertDialog.Builder(Inquiry.this);
				alertBox.setTitle("Ahoy!");
				alertBox.setMessage("Please review your information");
				alertBox.setCancelable(false);
				alertBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				AlertDialog alert = alertBox.create();
				alert.show();
			}

		} // button1 (Send Mail) click code finish
		else if(v.getId() == R.id.button2)
		{
			Log.d("Inquiry", "SendEmail button clicked");

			studentName = nameOfStudent.getText().toString();
			collegeName = nameOfCollege.getText().toString();
			emailId = email.getText().toString();
			studentPhoneNumber = phoneOfStudent.getText().toString();
			wantPasses = passes.isChecked();
			participate = participateInEvent.isChecked();
			
			Log.d("name", studentName);
			Log.d("college", collegeName);
			Log.d("emailid", emailId);
			Log.d("phone", studentPhoneNumber);
			Log.d("passes", String.valueOf(wantPasses));
			Log.d("participate", String.valueOf(participate));
			
			nameValid = !studentName.equals(null);
			collegeValid = !collegeName.equals(null);
			// validating email id
			emailValid = isValidEmail(email.getText().toString());
			//validating phone number
			phoneValid = PhoneNumberUtils.isGlobalPhoneNumber(phoneOfStudent.getText().toString());

			Log.d("emailValid", String.valueOf(emailValid));
			Log.d("phoneValid", String.valueOf(phoneValid));

			// send message if all information is valid
			if(emailValid && phoneValid && nameValid && collegeValid)
			{
				if(isNetworkAvailable())
				{
					if(dataNotSent)
					{
						// send data to me
//						sendEmailData();
//						sendPhoneNumberData();
					}
					// inquiry form data 
					sendInquiryData();
					// Toast show for submitted inquiry
					Toast.makeText(getApplicationContext(), "Mail Sent!", Toast.LENGTH_LONG).show();
					dataNotSent = false;
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No Internet Connectivity Detected", Toast.LENGTH_LONG).show();
				}
			}
			else
			{
				nameValid = false;
				collegeValid = false;
				emailValid = false;
				phoneValid = false;
				// alert box display
				AlertDialog.Builder alertBox = new AlertDialog.Builder(Inquiry.this);
				alertBox.setTitle("Ahoy!");
				alertBox.setMessage("Please review your information");
				alertBox.setCancelable(false);
				alertBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				AlertDialog alert = alertBox.create();
				alert.show();
			}
		}
	}
	
	public void sendInquiryData()
	{
		//submit inquiry form data to google docs
		String fullUrl = "https://docs.google.com/forms/d/1vMGxtBygxIHzdjH9kgcJ4J2ijqsOI64l8R9CJoudGdo/formResponse";
		HttpRequest mReq = new HttpRequest();
		String col1 = studentName;
		String col2 = collegeName;
		String col3 = emailId;
		String col4 = studentPhoneNumber;
		String col5 = String.valueOf(wantPasses);
		String col6 = String.valueOf(participate);
		String data = "entry_1078383829=" + URLEncoder.encode(col1) + "&" + 
					  "entry_804424731=" + URLEncoder.encode(col2) + "&" +
					  "entry_2123973636=" + URLEncoder.encode(col3) + "&" +
					  "entry_1306946790=" + URLEncoder.encode(col4) + "&" +
					  "entry_853175306=" + URLEncoder.encode(col5) + "&" +
					  "entry_410145238=" + URLEncoder.encode(col6);
		try 
		{
			String response = mReq.sendPost(fullUrl, data);
		}
		catch(Exception e)
		{
			Log.d("Inquiry","Exception Occured while sending inquiry data");
			e.printStackTrace();
		}

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}

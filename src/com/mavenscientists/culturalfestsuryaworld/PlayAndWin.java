package com.mavenscientists.culturalfestsuryaworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayAndWin extends Activity implements OnClickListener
{
	private TextView level;
	private TextView syncOnline;
	private static int levelNumber = 0;
	private final String[] jumbledWord = { 
			"OHELL", "INHGLES",  "REYGEN", "MILES", "NPHEATAS",
			"NETADR", "FOETATRUN", "GOINJISM", "NRTEEN", "ADRENESE",
			"LFFSHUE", "COURTONRIP", "BEBUMBLEE", "SIGNED", "KISMET", 
			"HITMANYU", "GOGLEB", "TUDENTS", "ORMEET", "OUTPEE",
			"CENSEIN", "ETNICE", "DENPANT", "PEARSMINT", "CIDVISITER",
			"RLWOD", "HURRAY!"
	};
	private final String[] correctWord = {
			"HELLO", "ENGLISH", "ENERGY", "SMILE", "PHEASANT",
			"ARDENT", "FORTUNATE", "JINGOISM", "RENNET", "SERENADE",
			"SHUFFLE", "CORRUPTION", "BUMBLEBEE", "DESIGN", "KISMET", 
			"HUMANITY", "BOGGLE", "STUDENT", "METEOR", "TOUPEE",
			"INCENSE", "ENTICE", "PENDANT", "SPEARMINT", "RECIDIVIST",
			"WORLD", "HURRAY!"
	};
	private final String[] hint = {
			"Call me and I'll say..", "It's Official", "Gulucon - D", 
			"You can go miles riding it", "This game bird has got a long tail",	"Passionate is my cue",
			"It's raining Dollars", "I love my country", "Technically, something that turns milk from liquid to solid",
			"I'd play this if I love you", "A deck of cards need a..", "We're all crying over it", 
			"Have you seen a yellow colored transformer", "Apple", "A one lucky word",
			"We lose it as we grow up", "A big surprise", "14 November", 
			"Black skies are shining without stars", "Some men wear me but I am not clothes", "I'm sweet but you cannot eat me",
			"To attract - it's a nice thing to do", "You definitely want this", "Tasty Cooking Stuff",
			"I repeat, Illegal", "I live here", "All Levels Cleared. Now Sync Online to win"
	};
	TextView jWord;
	EditText answer;
	TextView checkButton;
	TextView hintTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playandwin);
		
		ImageView aboutSW = (ImageView) findViewById(R.id.imageView1);
		aboutSW.setOnClickListener((OnClickListener)this);

		hintTextView = (TextView) findViewById(R.id.textView5);
		TextView home = (TextView) findViewById(R.id.textView2);
		home.setOnClickListener((OnClickListener)this);
		
		jWord = (TextView) findViewById(R.id.textView8); // the jumbled word
		syncOnline = (TextView) findViewById(R.id.textView10);
		syncOnline.setOnClickListener((OnClickListener)this);

		checkButton = (TextView) findViewById(R.id.textView9);
		checkButton.setOnClickListener((OnClickListener)this);
		jWord.setOnClickListener((OnClickListener)this);
		answer = (EditText) findViewById(R.id.editText1);
		level = (TextView) findViewById(R.id.textView7);

		SharedPreferences theLevel = getSharedPreferences("LevelPrefsFile", 0);
		level.setText(theLevel.getString("theLevel", "0")); // setting level and 0 is the default value when the app launches

		/* getting  level from saved state into integer variable -- 
		   the purpose is to get the level number in integer variable */
		levelNumber = Integer.valueOf(level.getText().toString());
		jWord.setText(jumbledWord[levelNumber]); //setting the next jumbled word
		hintTextView.setText(hint[levelNumber]);
		
	}
	
	@Override
	protected void onPause() {  // save level number when activity pauses
		super.onPause();
		Log.d("PlayandWin","Activity Paused");
		SharedPreferences theLevel = getSharedPreferences("LevelPrefsFile", 0);
		SharedPreferences.Editor editorLevel = theLevel.edit();
		editorLevel.putString("theLevel", level.getText().toString());
		editorLevel.commit();
	}
	
	
	@Override
	public void onClick(View v)
	{
		
		if(v.getId() == R.id.textView2)
		{
			Log.d("PlayAndWin", "Home tab clicked");
			startActivity(new Intent(PlayAndWin.this, Home.class) );
		}
		else if(v.getId() == R.id.imageView1)
		{
			Log.d("PlayAndWin", "SW Logo clicked");
			startActivity(new Intent(PlayAndWin.this, AboutSW.class));
		}
		else if(v.getId() == R.id.textView9)
		{
			Log.d("PlayAndWin", "Check button clicked");
			// if correct answer
			String theAnswer = answer.getText().toString().toUpperCase();
			if(jumbledWord[levelNumber].equals(jWord.getText()) && theAnswer.equals(correctWord[levelNumber]))
			{
				if(levelNumber < 25)
				{
					levelNumber++;
					level.setText(String.valueOf(levelNumber));
					jWord.setText(jumbledWord[levelNumber]);
					answer.setText("");
					hintTextView.setText(hint[levelNumber]);
					
					// alert box display
					AlertDialog.Builder alertBox = new AlertDialog.Builder(PlayAndWin.this);
					alertBox.setTitle("You did it!");
					alertBox.setMessage("The next level");
					alertBox.setCancelable(false);
					alertBox.setPositiveButton("GO", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});
					AlertDialog alert = alertBox.create();
					alert.show();
				}
				else
				{
					level.setText(String.valueOf(levelNumber));
					jWord.setText("HURRAY!");
					answer.setText("");
					hintTextView.setText("All Levels Cleared. Now Sync Online to win");
					
					// alert box display
					AlertDialog.Builder alertBox = new AlertDialog.Builder(PlayAndWin.this);
					alertBox.setTitle("Awesome!");
					alertBox.setMessage("You have cleared all levels. Now Sync Online to be the first winner");
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
			else //wrong answer
			{
				// alert box display
				AlertDialog.Builder alertBox = new AlertDialog.Builder(PlayAndWin.this);
				alertBox.setTitle("Oh!");
				alertBox.setMessage("Please try again. Good luck!");
				alertBox.setCancelable(false);
				alertBox.setPositiveButton("Thanks", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				AlertDialog alert = alertBox.create();
				alert.show();

			} // else - wrong answer ends
		}
		else if(v.getId() == R.id.textView10)
		{
			Log.d("PlayAndWin", "Sync Online button clicked");
			// send imei-number and levelnumber to google docs
			sendGameData();
		}
	}

	public void sendGameData()
	{
		// code to send game data to gogle docs
		
		
		// alert box display
		AlertDialog.Builder alertBox = new AlertDialog.Builder(PlayAndWin.this);
		alertBox.setTitle("Game Synced");
		alertBox.setMessage("Your progress has been synced with your online profile");
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

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	

}

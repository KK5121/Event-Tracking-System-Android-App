package com.example.event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registerevent extends Activity {
	SQLiteDatabase db;
	EditText eventname;
	Button register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registerevent);
		eventname = (EditText) findViewById(R.id.editText1);
		register = (Button)findViewById(R.id.button1);
register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(eventname.getText().toString().trim().length()==0){
					
					Toast.makeText(Registerevent.this, "please enter details", Toast.LENGTH_LONG).show();
				}
				else{
					db.execSQL("INSERT INTO eventnames (eventname)VALUES('"+eventname.getText().toString()+"');");
					
					Toast.makeText(Registerevent.this,"Event is Added Successfully",Toast.LENGTH_LONG).show();
					Intent move=new Intent(Registerevent.this,Manageevents.class);
					startActivity(move);
				
					
				}			
			}
		});
		db=openOrCreateDatabase("ETS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists eventnames(eventname varchar);");
	
	}

}

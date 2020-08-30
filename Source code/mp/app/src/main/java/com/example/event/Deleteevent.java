package com.example.event;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Deleteevent extends Activity {
	SQLiteDatabase db;
	Spinner spin;
	@SuppressLint("WrongConstant")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deleteevent);
		spin = (Spinner) findViewById(R.id.spinner1);
		db = openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
		Cursor res = db.rawQuery("select * from eventnames", null);
		if(res.getCount() == 0) {
			// show message
			Toast.makeText(Deleteevent.this,"No events are registered",Toast.LENGTH_LONG).show();
			return;
		}
		List<String> events = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		while (res.moveToNext()) {
			events.add(res.getString(0));
		}
		ArrayAdapter s=new ArrayAdapter(this,android.R.layout.simple_spinner_item,events);
		s.setDropDownViewResource(android.R.layout.simple_spinner_item);
		spin.setAdapter(s);
		Button del=(Button)findViewById(R.id.button1);
		del.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor c=db.rawQuery("SELECT * FROM eventnames WHERE eventname='"+spin.getSelectedItem()+"'", null);
				if(c.moveToFirst())
				{
					db.execSQL("DELETE FROM eventnames WHERE eventname='"+spin.getSelectedItem()+"'");
					Intent a=new Intent(Deleteevent.this,Manageevents.class);
					startActivity(a);
					Toast.makeText(Deleteevent.this, "Deleted event successfully", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}

package com.example.event;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Guest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest);
		Button n=(Button)findViewById(R.id.button2);
		n.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent a=new Intent(Guest.this,Guestevent.class);
				startActivity(a);

			}
		});
		Button n5=(Button)findViewById(R.id.button1);
		n5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent a=new Intent(Guest.this,Guestview.class);
				startActivity(a);

			}
		});

	}


}

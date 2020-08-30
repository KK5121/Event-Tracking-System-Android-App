package com.example.event;

import android.os.Bundle;
import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Deleteuser extends Activity {
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deleteuser);

		final EditText u = (EditText)findViewById(R.id.editText1);
		Button b = (Button)findViewById(R.id.button1);
		db=openOrCreateDatabase("ETS", Context.MODE_PRIVATE, null);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(u.getText().toString().trim().length()==0)

				{
					Toast.makeText(Deleteuser.this, "please enter details", Toast.LENGTH_LONG).show();
					return;
				}
				Cursor c=db.rawQuery("SELECT * FROM company WHERE id='"+u.getText()+"'", null);
				if(c.moveToFirst())
				{
					db.execSQL("DELETE FROM company WHERE id='"+u.getText()+"'");
					Toast.makeText(Deleteuser.this, "Deleted user successfully", Toast.LENGTH_LONG).show();
				}
				clearText();

			}

			public void clearText()
			{
				u.setText("");


			}
		});
	}


}

package com.example.event;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Guestview extends Activity {
	SQLiteDatabase db ;
	EditText mobile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guestview);
		mobile = (EditText) findViewById(R.id.editText1);
        Button n=(Button)findViewById(R.id.button1);
        n.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
            	@SuppressLint("WrongConstant") SQLiteDatabase db = openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
            	Cursor res = db.rawQuery("select * from guestregistration where ID='"+mobile.getText().toString()+"'", null);
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("EventName :"+ res.getString(1)+"\n");
                    buffer.append("Venue :"+ res.getString(2)+"\n");
                    buffer.append("Guests:"+ res.getString(3)+"\n");
                    buffer.append("Date:"+ res.getString(4));
                    buffer.append("-"+ res.getString(5));
                    buffer.append("-"+ res.getString(6)+"\n"+"\n");
                    
                }

                // Show all data
                showMessage("Data",buffer.toString());
            }
		});
	}
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}

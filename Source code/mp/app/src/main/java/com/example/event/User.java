package com.example.event;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class User extends Activity {
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);
        final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
        final String a=globalvariabel.GetUsername();
		TextView txtView;
        txtView=(TextView)findViewById(R.id.textView2);
        txtView.setText(a);
        Button n=(Button)findViewById(R.id.button2);
        Button n3=(Button)findViewById(R.id.button3);
        Button n5=(Button)findViewById(R.id.button1);
        n5.setOnClickListener(
                new OnClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void onClick(View v) {
                    	db=openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                    	Cursor res = db.rawQuery("select * from eventregistration where ID='"+a+"'", null);
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }
 
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("EventName :"+ res.getString(1)+"\n");
                            buffer.append("Venue :"+ res.getString(2)+"\n");
                            buffer.append("No.of.Guests :"+ res.getString(3)+"\n");
                            buffer.append("Date:"+ res.getString(4));
                            buffer.append("-"+ res.getString(5));
                            buffer.append("-"+ res.getString(6)+"\n"+"\n");
                            
                        }
 
                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                    });
        n3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a=new Intent(User.this, MainActivity.class);
				startActivity(a);
				
			}
		});
        n.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a=new Intent(User.this, Addevent.class);
				startActivity(a);
				
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
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent i=new Intent(User.this,MainActivity.class);
        startActivity(i);
    }


}

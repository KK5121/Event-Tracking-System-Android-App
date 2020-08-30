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

public class Manageevents extends Activity {
	SQLiteDatabase db;
	int i=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manageevents);
        Button n=(Button)findViewById(R.id.button1);
        n.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a=new Intent(Manageevents.this, Registerevent.class);
				startActivity(a);
				
			}
		});
        Button n1=(Button)findViewById(R.id.button3);
        n1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a=new Intent(Manageevents.this, Deleteevent.class);
				startActivity(a);
				
			}
		});
        Button n9=(Button)findViewById(R.id.button4);
        n9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent a=new Intent(Manageevents.this, Admin.class);
				startActivity(a);
				
			}
		});
        Button n5=(Button)findViewById(R.id.button2);
        n5.setOnClickListener(
                new OnClickListener() {
                    @SuppressLint("WrongConstant")
					@Override
                    public void onClick(View v) {
                    	db=openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                    	Cursor res = db.rawQuery("select * from eventnames", null);
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }
 
                        StringBuffer buffer = new StringBuffer();
                        i=1;
                        while (res.moveToNext()) {
                            buffer.append(i+")"+ res.getString(0)+"\n");
                            i++;
                            
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

package com.example.event;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Admin extends Activity {
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Button n=(Button)findViewById(R.id.button3);
        Button n1=(Button)findViewById(R.id.button2);
        Button n4=(Button)findViewById(R.id.button4);
        Button n5= (Button)findViewById(R.id.button1);
        n4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(Admin.this,MainActivity.class);
                startActivity(a);

            }
        });
        n1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(Admin.this,Deleteuser.class);
                startActivity(a);

            }
        });
        n.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(Admin.this,Manageevents.class);
                startActivity(a);

            }
        });
        n5.setOnClickListener(
                new OnClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void onClick(View v) {
                        db=openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                        Cursor res = db.rawQuery("select * from company", null);
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Mail :"+ res.getString(2)+"\n");
                            buffer.append("Ph :"+ res.getString(4)+"\n");
                            buffer.append("Add :"+ res.getString(5)+"\n");
                            buffer.append("Sex :"+ res.getString(6)+"\n"+"\n");

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

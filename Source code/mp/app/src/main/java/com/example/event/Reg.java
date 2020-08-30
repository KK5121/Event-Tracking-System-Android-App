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
import android.widget.RadioButton;
import android.widget.Toast;

public class Reg extends Activity implements OnClickListener{
	Button register;
	EditText username,email,password,phoneno,address;
	SQLiteDatabase db;
	RadioButton male,female;
	String select;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		username=(EditText)findViewById(R.id.editText1);
		email=(EditText)findViewById(R.id.mail);
		password=(EditText)findViewById(R.id.pass);
		phoneno=(EditText)findViewById(R.id.phone);
		address=(EditText)findViewById(R.id.ads);
	    male = (RadioButton) findViewById(R.id.radio0);
        female = (RadioButton) findViewById(R.id.radio1);
		register=(Button)findViewById(R.id.reg);
		register.setOnClickListener(this);
		db=openOrCreateDatabase("ETS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists company(ID INTEGER PRIMARY KEY AUTOINCREMENT,username varchar,email varchar,password varchar,phoneno number,address varchar,gender varchar);");
		
	}	
@Override
public void onClick(View v) {
	if(username.getText().toString().trim().length()==0||email.getText().toString().trim().length()==0||
			password.getText().toString().trim().length()==0||phoneno.getText().toString().trim().length()==0||address.getText().toString().trim().length()==0){
	
		Toast.makeText(Reg.this, "please enter details", Toast.LENGTH_LONG).show();
	}
	else if(phoneno.getText().toString().length()!=10)
	{
		Toast.makeText(Reg.this,"please enter 10 digits",Toast.LENGTH_LONG).show();
		}

	else{
        if (male.isChecked()) {
            select = male.getText().toString();
        } else if (female.isChecked()) {
            select = female.getText().toString();
        }
		db.execSQL("INSERT INTO company (username,email,password,phoneno,address,gender)VALUES('"+username.getText()+"','"+email.getText()+
				   "','"+password.getText()+"','"+phoneno.getText()+"','"+address.getText()+"','"+select+"');");
		
		Toast.makeText(Reg.this,"Registration is sucessfully completed",Toast.LENGTH_LONG).show();
		clearText();
		Intent move=new Intent(Reg.this, Addevent.class);
		startActivity(move);
	
		
	}

}
		
	
	    public void clearText()
	    {
	    	username.setText("");
	    	password.setText("");
	    	email.setText("");
	    	phoneno.setText("");
	    	address.setText("");

	    }
}

	
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	



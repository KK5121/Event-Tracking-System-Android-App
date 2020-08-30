package com.example.event;

import java.util.ArrayList;
import android.app.Application;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class Guestevent extends Activity implements OnItemSelectedListener{
    Button b,b1;
    EditText e,r,t;
    SQLiteDatabase db;
    Spinner spin,spin1,spin2,spin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestevent);
        spin = (Spinner) findViewById(R.id.spinner1);
        spin1 = (Spinner) findViewById(R.id.spinner2);
        spin2 = (Spinner) findViewById(R.id.spinner3);
        spin3 = (Spinner) findViewById(R.id.spinner4);
        final EditText r = (EditText)findViewById(R.id.editText1);
        final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
        final String a=globalvariabel.GetUsername();
        spin.setOnItemSelectedListener(this);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        db=openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        Cursor res = db.rawQuery("select * from eventnames", null);
        if(res.getCount() == 0) {
            // show message
            Toast.makeText(Guestevent.this,"No events are registered",Toast.LENGTH_LONG).show();
            return;
        }
        List<String> events = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            events.add(res.getString(0));
        }
        List<String> events1 = new ArrayList<String>();
        events1.add("Palace Grounds");
        events1.add("Suryagarh");
        events1.add("Neemrana Fort ");
        events1.add("Park Hyatt");
        events1.add("Falaknuma Palace");
        events1.add("TajHariMahal Palace");
        List<String> events2 = new ArrayList<String>();
        events2.add("1");
        events2.add("2");
        events2.add("3");
        events2.add("4");
        events2.add("5");
        events2.add("6");
        events2.add("7");
        events2.add("8");
        events2.add("9");
        events2.add("10");
        events2.add("11");
        events2.add("12");
        events2.add("13");
        events2.add("14");
        events2.add("15");
        events2.add("16");
        events2.add("17");
        events2.add("18");
        events2.add("19");
        events2.add("20");
        events2.add("21");
        events2.add("22");
        events2.add("23");
        events2.add("24");
        events2.add("25");
        events2.add("26");
        events2.add("27");
        events2.add("28");
        events2.add("29");
        events2.add("30");
        List<String> events3 = new ArrayList<String>();
        events3.add("Jan");
        events3.add("Feb");
        events3.add("Mar");
        events3.add("Apl");
        events3.add("May");
        events3.add("June");
        events3.add("July");
        events3.add("Aug");
        events3.add("Sep");
        events3.add("Oct");
        events3.add("Nov");
        events3.add("Dec");
        Toast.makeText(Guestevent.this, "Welcome To Registration Page User: "  +a , Toast.LENGTH_LONG).show();
        ArrayAdapter s=new ArrayAdapter(this,android.R.layout.simple_spinner_item,events);
        s.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(s);
        ArrayAdapter s1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,events1);
        s1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin1.setAdapter(s1);
        ArrayAdapter s2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,events2);
        s2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin2.setAdapter(s2);
        ArrayAdapter s3=new ArrayAdapter(this,android.R.layout.simple_spinner_item,events3);
        s3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin3.setAdapter(s3);
        final EditText guests = (EditText)findViewById(R.id.editText3);
        db=openOrCreateDatabase("ETS", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists guestregistration(ID varchar,event varchar,venue varchar,guests varchar,day varchar,month varchar,year varchar);");
        Button reg=(Button)findViewById(R.id.button1);
        reg.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                db.execSQL("INSERT INTO guestregistration(ID,event,venue,guests,day,month,year)VALUES('"+r.getText().toString()+"','"+spin.getSelectedItem()+"','"+spin1.getSelectedItem()+
                        "','"+guests.getText()+"','"+spin2.getSelectedItem()+"','"+spin3.getSelectedItem()+"','"+2019+"');");

                Toast.makeText(Guestevent.this,"Registration is sucessfully completed",Toast.LENGTH_LONG).show();
                Intent a=new Intent(Guestevent.this,Guest.class);
                startActivity(a);


            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}

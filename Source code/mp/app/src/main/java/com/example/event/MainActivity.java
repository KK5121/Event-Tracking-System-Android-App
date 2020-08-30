package com.example.event;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button n1=(Button)findViewById(R.id.button1);
        Button n2=(Button)findViewById(R.id.button2);
        Button n3=(Button)findViewById(R.id.button3);
        n1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,Login.class);
                startActivity(a);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bounce);
                v.startAnimation(animation);
                overridePendingTransition(R.anim.bottom,R.anim.top);
            }
        });
        n2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,Reg.class);
                startActivity(a);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bounce);
                v.startAnimation(animation);
                overridePendingTransition(R.anim.bottom,R.anim.top);
            }
        });
        n3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this,Guest.class);
                startActivity(a);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bounce);
                v.startAnimation(animation);
                overridePendingTransition(R.anim.clock,R.anim.anti);
            }
        });
    }
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent i=new Intent(MainActivity.this,MainActivity.class);
        startActivity(i);
    }
}

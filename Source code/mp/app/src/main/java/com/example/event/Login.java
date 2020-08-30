package com.example.event;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.SyncStateContract.Columns;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    EditText user, pass;
    Button sub;
    String u;
    String p;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.editText1);
        pass = (EditText) findViewById(R.id.editText2);
        Button n1=(Button)findViewById(R.id.button3);
        n1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent a=new Intent(Login.this,FingerprintActivity.class);
                startActivity(a);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bounce);
                v.startAnimation(animation);
                overridePendingTransition(R.anim.bottom,R.anim.top);
            }
        });
        sub=(Button) findViewById(R.id.button1);
        sub.setOnClickListener(new OnClickListener() {

            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(user.getText().toString().equals("")||pass.getText().toString().equals("")){

                    Toast.makeText(Login.this, "Please enter all the fields..!", Toast.LENGTH_LONG).show();
                }else{
                    u = user.getText().toString();
                    p = pass.getText().toString();

                    db=openOrCreateDatabase("ETS",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                }


                if(user.getText().toString().equals("praneel")&& pass.getText().toString().equals("1234")){
                    Toast.makeText(Login.this, "Welcome To Admin Home Page "  + u , Toast.LENGTH_LONG).show();
                    globalvariabel.Setusername(user.getText().toString().trim());

                    Intent a = new Intent(Login.this,Admin.class);
                    startActivity(a);
                    clear();
                    return;
                }
                Cursor cc = db.rawQuery("select * from company where username= '"+u+"' and password= '"+p+"' ", null);
                if(cc.moveToFirst())
                {String temp="";
                    if (cc != null) {
                        if(cc.getCount() > 0)
                        {
                            //return true;
                            scan g=new scan();
                            g.execute();

                            Toast.makeText(Login.this, "Welcome To ETS HomePage "  +u ,Toast.LENGTH_LONG).show();
                            globalvariabel.Setusername(cc.getString(0));
                            globalvariabel.Setpassword(pass.getText().toString().trim());
                            Intent b = new Intent(Login.this,User.class);
                            startActivity(b);
                            clear();
                            return;
                        }else{
                            Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
                            clear();
                        }
                    }
                }

                //lo
					 /*       	 Cursor cc1 = db.rawQuery("select * from breg2 where bid= '"+u+"' and pass= '"+p+"' ", null);
					        	 if(cc1.moveToFirst())
				        		 {String temp="";
					            if (cc1 != null) {
					            	if(cc1.getCount() > 0)
					            	{
					            	//return true;
					            scan g=new scan();
					            g.execute();

					            		Toast.makeText(Login.this, "Welcome To hdfc bank Home Page "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.Setusername(user.getText().toString().trim());
					    				//globalvariabel.Setpassword(pass.getText().toString().trim());
					            		Intent c = new Intent(Login.this,User.class);
					            		startActivity(c);
					            		clear();
					            		return;
					            	}
					            	else{
					            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
					            		 clear();
					            	}
					            	}
				        		 }
					        	 Cursor cc2 = db.rawQuery("select * from breg3 where bid= '"+u+"' and pass= '"+p+"' ", null);
					        	 if(cc2.moveToFirst())
				        		 {String temp="";
					            if (cc2 != null) {
					            	if(cc2.getCount() > 0)
					            	{
					            	//return true;
					            scan g=new scan();
					            g.execute();

					            		Toast.makeText(Login.this, "Welcome To ICICI BANK Home Page "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.Setusername(user.getText().toString().trim());
					    				//globalvariabel.Setpassword(pass.getText().toString().trim());
					            		Intent c = new Intent(Login.this,User.class);
					            		startActivity(c);
					            		clear();
					            		return;
					            	}else{
					            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
					            		 clear();
					            	}
					            	}
				        		 }

					        	 Cursor cc3 = db.rawQuery("select * from breg3 where bid= '"+u+"' and pass= '"+p+"' ", null);
					        	 if(cc3.moveToFirst())
				        		 {String temp="";
					            if (cc3 != null) {
					            	if(cc3.getCount() > 0)
					            	{
					            	//return true;
					            scan g=new scan();
					            g.execute();

					            		Toast.makeText(Login.this, "Welcome To AXIS Home Page "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.Setusername(user.getText().toString().trim());
					    				//globalvariabel.Setpassword(pass.getText().toString().trim());
					            		Intent c = new Intent(Login.this,User.class);
					            		startActivity(c);
					            		clear();
					            		return;
					            	}else{
					            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
					            		 clear();
					            	}
					            	}
				        		 }
					        	 Cursor cc4 = db.rawQuery("select * from ureg where user= '"+u+"' and pass= '"+p+"' ", null);
					        	 if(cc4.moveToFirst())
				        		 {String temp="";
					            if (cc4 != null) {
					            	if(cc4.getCount() > 0)
					            	{
					            	//return true;
					            scan g=new scan();
					            g.execute();

					            		Toast.makeText(Login.this, "Welcome To user Home Page "  + u , Toast.LENGTH_LONG).show();
					            		globalvariabel.Setusername(user.getText().toString().trim());
					    				//globalvariabel.Setpassword(pass.getText().toString().trim());
					            		Intent c = new Intent(Login.this,User.class);
					            		startActivity(c);
					            		clear();
					            		return;
					            	}else{
					            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
					            		 clear();
					            	}
					            	}
				        		 }


					            else{
				            		 Toast.makeText(Login.this, "Login Failed...!", Toast.LENGTH_LONG).show();
				            		 clear();
					        	 }*/
            }//



        });


    }


    public class scan extends AsyncTask<String, String, String>{

        private ProgressDialog pd;

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Login.this);
            pd.setTitle("Please Wait!!");
            pd.setMessage("Logging you In....");
            pd.setMax(10);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    public void clear()
    {
        user.setText("");
        pass.setText("");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent i=new Intent(Login.this,MainActivity.class);
        startActivity(i);
    }

}
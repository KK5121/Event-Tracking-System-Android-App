package com.example.event;
import android.app.Application;
import android.content.Intent;

public class GlobalClass extends Application{
	public String UserName;
	public String Password;
	public String eventname;
	public String venuename;
	public String i;
	public int count=0;


	public String GetUsername()
	{
		return UserName;
	}

	public void Setusername(String _susername)
	{
		UserName=_susername;

	}
	public String Geti()
	{
		return i;
	}

	public void Seti(String _susername)
	{
		i=_susername;
		Intent a=new Intent(GlobalClass.this,User.class);
		startActivity(a);

	}

	public String GetPassword()
	{
		return Password;
	}
	public void Setpassword(String _spassword)
	{
		Password=_spassword;

	}
	public void Setvenuename(String _susername)
	{
		venuename=_susername;

	}
	public String Getvenuename()
	{
		return venuename;
	}


}

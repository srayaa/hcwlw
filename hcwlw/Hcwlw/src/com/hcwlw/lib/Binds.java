package com.hcwlw.lib;

import com.hcwlw.HelpActivity;
import com.hcwlw.MainActivity;
import com.hcwlw.MemberCenterActivity;
import com.hcwlw.MyinfoActivity;
import com.hcwlw.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Binds {
	private Button btn_home;
	private Button btn_myinfo;
	private Button btn_membercenter;
	private Button btn_help;
	
	public boolean bindfooter(Activity activity,final Context context){
		try{
		btn_home = (Button) activity.findViewById(R.id.btn_home);
		btn_home.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent home = new Intent(context,MainActivity.class);
				home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				context.startActivity(home);
				
			}
		});
		
		btn_myinfo = (Button) activity.findViewById(R.id.btn_myinfo);
		btn_myinfo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myinfo = new Intent(context,MyinfoActivity.class);
				myinfo.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				context.startActivity(myinfo);
			}
		});
		
		btn_membercenter = (Button) activity.findViewById(R.id.btn_membercenter);
		btn_membercenter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent membercenter = new Intent(context,MemberCenterActivity.class);
				membercenter.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				context.startActivity(membercenter);
			}
		});
		
		btn_help = (Button) activity.findViewById(R.id.btn_help);
		btn_help.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent help = new Intent(context,HelpActivity.class);
				help.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				context.startActivity(help);
			}
		});
		return true;
		}catch(Exception e){
			return false;
		}
	}

}

package com.hcwlw;

import com.hcwlw.lib.Binds;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyinfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myinfo);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-个人信息");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
		
		LinearLayout lloutpersonsettings = (LinearLayout) findViewById(R.id.persettings);
		final LinearLayout lloutpersonsettingsdt = (LinearLayout) findViewById(R.id.persettingsdetail);
		final ImageView im =  (ImageView) findViewById(R.id.btn_personsettings);
		
		lloutpersonsettings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(lloutpersonsettingsdt.getVisibility()==View.GONE){
					im.setImageResource(R.drawable.qz_icon_navbar_drop_up);
					lloutpersonsettingsdt.setVisibility(View.VISIBLE);
				}else{
					im.setImageResource(R.drawable.qz_icon_navbar_drop_down);
					lloutpersonsettingsdt.setVisibility(View.GONE);
				}
				
			}
		});
		
		LinearLayout lloutperorder = (LinearLayout) findViewById(R.id.perorder);
		lloutperorder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "我的订单页面",Toast.LENGTH_SHORT).show();
				findViewById(R.id.btn_personordernew).setVisibility(View.GONE);
			}
		});
		
		
		findViewById(R.id.pswChg).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				findViewById(R.id.chgpsw_container).setVisibility(View.VISIBLE);
			}
		});
		
		findViewById(R.id.btnConfirm).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				findViewById(R.id.chgpsw_container).setVisibility(View.GONE);
				Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
			}
		});
		findViewById(R.id.btnCancel).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				findViewById(R.id.chgpsw_container).setVisibility(View.GONE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.myinfo, menu);
		return true;
	}
	private long exitTime = 0;


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
	        Intent main = new Intent(getApplicationContext(), MainTabActivity.class);
	        main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        startActivity(main);
	        return true;
	    	/*if((System.currentTimeMillis()-exitTime) > 2000){  
	            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
	            exitTime = System.currentTimeMillis();   
	        } else {
	            finish();
	            System.exit(0);
	        }
	        return true;  */ 
	    }
	    return super.onKeyDown(keyCode, event);
	}
}

package com.hcwlw;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.hcwlw.lib.Binds;
import com.hcwlw.lib.GifView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MemberCenterActivity extends Activity {
	private GifView gf2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member_center);
		
		gf2=(GifView) findViewById(R.id.gif2);
		gf2.setGifImageType(GifView.GifImageType.ANIMATION);
		
           /* File file=new File("");
            FileInputStream fis=null;
            fis=new FileInputStream(file);*/
        gf2.setGifImage(R.drawable.agif);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网－会员中心");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
		TextView picShare = (TextView) findViewById(R.id.picShare);
		picShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),PicWallActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.member_center, menu);
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
	        return true;   */
	    }
	    return super.onKeyDown(keyCode, event);
	}
}

package com.hcwlw;

import javax.xml.datatype.Duration;

import com.hcwlw.lib.Binds;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-帮助");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
		/*
		 * 软件升级
		 */
		TextView tv_update = (TextView) findViewById(R.id.update_txt);
		tv_update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				checkUpdate();
			}

			private void checkUpdate() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "已是最新版本", Toast.LENGTH_SHORT).show();
			}
		});
		
		/*
		 * 汇款账号
		 */
		TextView tv_zh = (TextView) findViewById(R.id.hkzh_txt);
		final LinearLayout ll_zh1 = (LinearLayout) findViewById(R.id.hkzh_ll1);
		final LinearLayout ll_zh2 = (LinearLayout) findViewById(R.id.hkzh_ll2);
		tv_zh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ll_zh1.getVisibility()== View.GONE){
					ll_zh1.setVisibility(View.VISIBLE);
					ll_zh2.setVisibility(View.VISIBLE);
				}else{
					ll_zh1.setVisibility(View.GONE);
					ll_zh2.setVisibility(View.GONE);
				}
			}
		});
		/*
		 * 关于我们
		 */
		TextView tv_gy = (TextView) findViewById(R.id.gywm_txt);
		tv_gy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showInfo();
			}
		});
		
		/*
		 * 帮助反馈
		 */
		final LinearLayout llfeed1  =  (LinearLayout) findViewById(R.id.refeed1_txt);
		final LinearLayout llfeed2  =  (LinearLayout) findViewById(R.id.refeed2_txt);
		TextView tv = (TextView) findViewById(R.id.bzfk_txt);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(llfeed1.getVisibility() == View.GONE && llfeed2.getVisibility()==View.GONE){
					llfeed1.setVisibility(View.VISIBLE);
					llfeed2.setVisibility(View.VISIBLE);
				}else{
					llfeed1.setVisibility(View.GONE);
					llfeed2.setVisibility(View.GONE);
				}
			}
		});
		Button btnsub = (Button) findViewById(R.id.btn_sub);
		btnsub.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "提交成功，谢谢您的参与！", Toast.LENGTH_SHORT).show();
				llfeed1.setVisibility(View.GONE);
				llfeed2.setVisibility(View.GONE);
			}
		});
	}

	public void showInfo(){
	new AlertDialog.Builder(this)
	.setTitle("关于我们")
	.setMessage(R.string.aboutus)
	.setPositiveButton("确定", new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
		}
	})
	.show();
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help, menu);
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
	    	/* if((System.currentTimeMillis()-exitTime) > 2000){  
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

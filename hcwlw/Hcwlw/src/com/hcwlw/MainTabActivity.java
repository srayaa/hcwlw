package com.hcwlw;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

public class MainTabActivity extends TabActivity implements OnCheckedChangeListener{

	
	private Intent mAIntent; 
    private Intent mBIntent; 
    private Intent mCIntent; 
    private Intent mDIntent; 
    private TabHost mTabHost;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_tab);
		
		this.mAIntent = new Intent(this,MainActivity.class); 
        this.mBIntent = new Intent(this,MyinfoActivity.class); 
        this.mCIntent = new Intent(this,MemberCenterActivity.class); 
        this.mDIntent = new Intent(this,HelpActivity.class); 
        
        
        ((RadioButton) findViewById(R.id.btn_home)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.btn_myinfo)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.btn_membercenter)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.btn_help)) 
        .setOnCheckedChangeListener(this); 
         
        setupIntent(); 

	}

	
	private void setupIntent() { 
        this.mTabHost = getTabHost(); 
        TabHost localTabHost = this.mTabHost; 
 
        localTabHost.addTab(buildTabSpec("A_TAB", R.string.home, 
                R.drawable.footer_main, this.mAIntent)); 
 
        localTabHost.addTab(buildTabSpec("B_TAB", R.string.myinfo, 
                R.drawable.footer_myinfo, this.mBIntent)); 
 
        localTabHost.addTab(buildTabSpec("C_TAB", 
                R.string.membercenter, R.drawable.footer_memcenter, 
                this.mCIntent)); 
 
        localTabHost.addTab(buildTabSpec("D_TAB", R.string.help, 
                R.drawable.footer_help, this.mDIntent)); 
 
 
    } 
     
    private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon, 
            final Intent content) { 
        return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel), 
                getResources().getDrawable(resIcon)).setContent(content); 
    } 

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_tab, menu);
		return true;
	}


	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(isChecked){ 
            switch (buttonView.getId()) { 
            case R.id.btn_home: 
                this.mTabHost.setCurrentTabByTag("A_TAB"); 
                break; 
            case R.id.btn_myinfo: 
                this.mTabHost.setCurrentTabByTag("B_TAB"); 
                break; 
            case R.id.btn_membercenter: 
                this.mTabHost.setCurrentTabByTag("C_TAB"); 
                break; 
            case R.id.btn_help: 
                this.mTabHost.setCurrentTabByTag("D_TAB"); 
                break; 
            } 
        } 

	}

}

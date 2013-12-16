package com.hcwlw;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SettingsActivity extends Activity {
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		RadioGroup rg =  (RadioGroup) findViewById(R.id.jmxz);
		sp = this.getSharedPreferences("jm", MODE_PRIVATE);
		int tp =sp.getInt("jmxx", 1); 
		if(tp==2){
			rg.check(R.id.win8style);
		}else if(tp==3){
			rg.check(R.id.gridstyle);
		}
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				RadioButton rbsel = (RadioButton) findViewById(arg1);
				if(rbsel.getText().equals("д╛хо")){
					sp.edit().putInt("jmxx", 1).commit();
				}else if(rbsel.getText().equals("win8")){
					sp.edit().putInt("jmxx", 2).commit();
				}else{
					sp.edit().putInt("jmxx", 3).commit();
				}
			}
		});
	}

	
/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}*/

}

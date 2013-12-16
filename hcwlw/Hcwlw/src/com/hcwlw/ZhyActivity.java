package com.hcwlw;

import com.hcwlw.lib.Binds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ZhyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhy);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-找货源");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zhy, menu);
		return true;
	}

}

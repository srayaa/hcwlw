package com.hcwlw;

import com.hcwlw.lib.Binds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class XxcxActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xxcx);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-信息查询");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xxcx, menu);
		return true;
	}

}

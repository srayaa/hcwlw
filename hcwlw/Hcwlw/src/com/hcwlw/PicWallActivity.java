package com.hcwlw;

import com.hcwlw.lib.FileUtils;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PicWallActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pic_wall);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-图片分享");
		
		LinearLayout llout =  (LinearLayout) findViewById(R.id.llout_share);
		llout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "分享页面", Toast.LENGTH_SHORT).show();
				showFileChooser();
			}
		});
	}

private void showFileChooser() {

    Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 

    intent.setType("*/*"); 

    intent.addCategory(Intent.CATEGORY_OPENABLE);

 

    try {

        startActivityForResult( Intent.createChooser(intent, "Select a File to Upload"), 1);

    } catch (android.content.ActivityNotFoundException ex) {

        Toast.makeText(this, "Please install a File Manager.",  Toast.LENGTH_SHORT).show();

    }

}


@Override

protected void onActivityResult(int requestCode, int resultCode, Intent data)  {

    switch (requestCode) {

        case 1:      

        if (resultCode == RESULT_OK) {  

            // Get the Uri of the selected file 

            Uri uri = data.getData();

            String path = FileUtils.getPath(this, uri);
            Toast.makeText(getApplicationContext(), path, Toast.LENGTH_SHORT).show();
        }           

        break;

    }

super.onActivityResult(requestCode, resultCode, data);

}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pic_wall, menu);
		return true;
	}

}

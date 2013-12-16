package com.hcwlw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hcwlw.ToolboxActivity.GridViewItemOnClick;
import com.hcwlw.lib.Binds;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	private SharedPreferences sp;
	private SharedPreferences sp2;
	private int viewnum;
	private TextView title;
	private Button btn_wlrx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		sp = this.getSharedPreferences("passwordFile", MODE_PRIVATE);
		sp2 = this.getSharedPreferences("jm", MODE_PRIVATE);
		
		int jmxx = sp2.getInt("jmxx", 1);
		if(jmxx==1){
			setContentView(R.layout.activity_main);

		
		mrjmXz();
		
		}else if(jmxx==2){
			setContentView(R.layout.activity_main_win8style);
			win8bind();
		}else{
			setContentView(R.layout.activity_main_gridstyle);
			gridstylebind();
		}
		viewnum = jmxx;
		//Binds binds = new Binds();
		//binds.bindfooter(this, this);
		
	}
	private void win8bind(){
		ImageView fc = (ImageView) findViewById(R.id.win8_fc);
		ImageView fh = (ImageView) findViewById(R.id.win8_fh);
		ImageView gjx = (ImageView) findViewById(R.id.win8_gjx);
		ImageView grzx = (ImageView) findViewById(R.id.win8_grzx);
		ImageView gwdd = (ImageView) findViewById(R.id.win8_gwdd);
		ImageView hjzx = (ImageView) findViewById(R.id.win8_hjzx);
		ImageView wdgz = (ImageView) findViewById(R.id.win8_wdgz);
		ImageView wdxx = (ImageView) findViewById(R.id.win8_wdxx);
		ImageView zc = (ImageView) findViewById(R.id.win8_zc);
		ImageView zh = (ImageView) findViewById(R.id.win8_zh);
		ImageView picwall = (ImageView) findViewById(R.id.win8_picwall);
		
		fc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent fbcy = new Intent(MainActivity.this,FbcyActivity.class);
				fbcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbcy);
			}
		});
		
		fh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent fbhy = new Intent(MainActivity.this,FbhyActivity.class);
				fbhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbhy);
			}
		});
		
		gjx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent toolbox = new Intent(MainActivity.this,ToolboxActivity.class);
				toolbox.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(toolbox);
			}
		});
		
		grzx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent grzx = new Intent(getApplicationContext(), MemberCenterActivity.class);
				grzx.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(grzx);
			}
		});
		
		gwdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "过往订单页", Toast.LENGTH_SHORT).show();
			}
		});
		
		hjzx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent phoneIntent = new Intent("android.intent.action.CALL",Uri.parse("tel:400-033-5656"));
				//启动
				startActivity(phoneIntent);
			}
		});
		
		wdgz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "我的关注页", Toast.LENGTH_SHORT).show();
			}
		});
		
		wdxx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "我的信息页", Toast.LENGTH_SHORT).show();
			}
		});
		
		zc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent zcy = new Intent(MainActivity.this,ZcyActivity.class);
				zcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zcy);
			}
		});
		
		zh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent zhy = new Intent(MainActivity.this,ZhyActivity.class);
				zhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zhy);
			}
		});
		picwall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent picshare = new Intent(MainActivity.this,PicWallActivity.class);
				picshare.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(picshare);
			}
		});
	}

	private void gridstylebind(){
		GridView mGridView;   //MyGridView
	    //定义图标数组
		int[] imageRes = { R.drawable.grid_fahuo, R.drawable.grid_fache,R.drawable.grid_zhaohuo,
						   R.drawable.grid_zhaoche,R.drawable.grid_gongjuxiang, R.drawable.grid_fenxiang, 
						   R.drawable.grid_gerenxinxi,R.drawable.grid_wodeguanzhu,R.drawable.grid_wuliurexian};
	   //定义标题数组
		String[] itemName = { "发货", "发车", "找货", "找车", "工具箱","图片分享","个人信息","我的关注","物流热线" };
		title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网");
		mGridView = (GridView) findViewById(R.id.GridView);
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        int length = itemName.length;
        for (int i = 0; i < length; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImageView", imageRes[i]);
                map.put("ItemTextView", itemName[i]);
                data.add(map);
        }
        //为itme.xml添加适配器
       SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,
        data, R.layout.item, new String[] { "ItemImageView","ItemTextView" }, new int[] { R.id.ItemImage,R.id.ItemText });
        mGridView.setAdapter(simpleAdapter);
        //为mGridView添加点击事件监听器
       mGridView.setOnItemClickListener(new GridViewItemOnClick());
	}
	public class GridViewItemOnClick implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int position,long arg3) {
        	switch (position) {
			case 0:
				Intent fbhy = new Intent(MainActivity.this,FbhyActivity.class);
				fbhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbhy);
				break;
			case 1:
				Intent fbcy = new Intent(MainActivity.this,FbcyActivity.class);
				fbcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbcy);
				break;
			case 2:
				Intent zhy = new Intent(MainActivity.this,ZhyActivity.class);
				zhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zhy);
				break;
			case 3:
				Intent zcy = new Intent(MainActivity.this,ZcyActivity.class);
				zcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zcy);
				break;
			case 4:
				Intent toolbox = new Intent(MainActivity.this,ToolboxActivity.class);
				toolbox.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(toolbox);
				break;
			case 5:
				Intent picshare = new Intent(MainActivity.this,PicWallActivity.class);
				picshare.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(picshare);
				break;
			case 6:
				Toast.makeText(getApplicationContext(), "我的信息页", Toast.LENGTH_SHORT).show();
				break;
			case 7:
				Toast.makeText(getApplicationContext(), "我的关注页", Toast.LENGTH_SHORT).show();
				break;
			case 8:
				Intent phoneIntent = new Intent("android.intent.action.CALL",Uri.parse("tel:400-033-5656"));
				//启动
				startActivity(phoneIntent);
				break;

			default:
				break;
			}
               Toast.makeText(getApplicationContext(), position + "",
               Toast.LENGTH_SHORT).show();
        }
     }
	private void mrjmXz() {
		title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网");
		
				btn_wlrx = (Button) findViewById(R.id.btn_wlrx);
		btn_wlrx.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent phoneIntent = new Intent("android.intent.action.CALL",Uri.parse("tel:400-033-5656"));
				//启动
				startActivity(phoneIntent);
			}
		});
		
		((Button) findViewById(R.id.btn_navi)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent navi = new Intent(MainActivity.this,NaviActivity.class);
				navi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(navi);
			}
		});
		
		((Button) findViewById(R.id.btn_toolbox)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent toolbox = new Intent(MainActivity.this,ToolboxActivity.class);
				toolbox.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(toolbox);
			}
		});
		
		((Button) findViewById(R.id.btn_xxcx)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent xxcx = new Intent(MainActivity.this,XxcxActivity.class);
				xxcx.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(xxcx);
			}
		});
		
		((Button) findViewById(R.id.btn_zcy)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent zcy = new Intent(MainActivity.this,ZcyActivity.class);
				zcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zcy);
			}
		});
		
		((Button) findViewById(R.id.btn_zhy)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent zhy = new Intent(MainActivity.this,ZhyActivity.class);
				zhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(zhy);
			}
		});
		
		((Button) findViewById(R.id.btn_fbhy)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent fbhy = new Intent(MainActivity.this,FbhyActivity.class);
				fbhy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbhy);
			}
		});
		
		((Button) findViewById(R.id.btn_fbcy)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent fbcy = new Intent(MainActivity.this,FbcyActivity.class);
				fbcy.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				//启动
				startActivity(fbcy);
			}
		});
	}

	private long exitTime = 0;


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
	        if((System.currentTimeMillis()-exitTime) > 2000){  
	            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
	            exitTime = System.currentTimeMillis();   
	        } else {
	            finish();
	            System.exit(0);
	        }
	        return true;   
	    }
	    return super.onKeyDown(keyCode, event);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
    	menu.add(1,Menu.FIRST,Menu.FIRST,"切换用户");
    	menu.add(1,Menu.FIRST+1,Menu.FIRST+1,"设定");
        return true;
	}
	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	// TODO Auto-generated method stub
	    	if(item.getItemId()==Menu.FIRST){
	    		
	    		sp.edit().putString("USER_NAME", "").commit();
				sp.edit().putString("PASSWORD", "").commit();
				sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
				
				Intent i = new Intent(MainActivity.this,LoginActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				startActivity(i);
				
				finish();
	    	}else{
	    		if(item.getItemId()==(Menu.FIRST+1)){
	    			Intent i = new Intent(MainActivity.this,SettingsActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
					startActivity(i);
	    		}else{
	    			return super.onOptionsItemSelected(item);
	    		}
	    	}
	    	return true;
	    }
	  @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		  int jmxx = sp2.getInt("jmxx", 1);
		  if(jmxx!=viewnum){
			if(jmxx==1){
				setContentView(R.layout.activity_main);
				mrjmXz();
				viewnum=1;
			}else if(jmxx==2){
				setContentView(R.layout.activity_main_win8style);
				win8bind();
				viewnum=2;
			}else{
				setContentView(R.layout.activity_main_gridstyle);
				gridstylebind();
				viewnum=3;
			}
		  }
		super.onResume();
	}
}

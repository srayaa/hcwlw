package com.hcwlw;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.baidu.mapapi.BMapManager;   
import com.baidu.mapapi.map.MKMapViewListener;   
import com.baidu.mapapi.map.MapController;   
import com.baidu.mapapi.map.MapPoi;   
import com.baidu.mapapi.map.MapView;   
import com.baidu.platform.comapi.basestruct.GeoPoint;   
import com.hcwlw.lib.Binds;

public class NaviActivity extends Activity {
	BMapManager mBMapMan = null;   
	MapView mMapView = null;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);   
		mBMapMan=new BMapManager(getApplication());   
		mBMapMan.init("E3ebea75f30083e98a02a24a5fe6082f", null);     
//		mBMapMan.init("x69IrK2se8oZqSPpjF6pUVoj", null);     
		//注意：请在试用setContentView前初始化BMapManager对象，否则会报错   
		setContentView(R.layout.activity_navi);
		mMapView=(MapView)findViewById(R.id.bmapsView);   
		mMapView.setBuiltInZoomControls(true);   
		//设置启用内置的缩放控件   
		MapController mMapController=mMapView.getController();   
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放   
		GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));   
		//用给定的经纬度构造一个GeoPoint，单位是微度 (度 * 1E6)   
		mMapController.setCenter(point);//设置地图中心点   
		mMapController.setZoom(12);//设置地图zoom级别  

		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-导航");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navi, menu);
		return true;
	}
	@Override   
	protected void onDestroy(){  
		super.onDestroy();   
		Log.v("dest", "destroy");
		if(mMapView!=null){
			Log.v("dest", "destroy view");	
			mMapView.destroy();   
		}
	        if(mBMapMan!=null){   
	        	Log.v("dest", "destroy man");	
	                //mBMapMan.destroy();   
	                Log.v("dest", "destroy man after");	
	                //mBMapMan=null;   
	        }   
	}   
	@Override   
	protected void onPause(){   
		Log.v("pause", "pause view");	
		if(mMapView!=null){
	        mMapView.onPause();}   
		Log.v("pause", "pause man");	
	        if(mBMapMan!=null){   
	               mBMapMan.stop();   
	        }   
	        super.onPause();   
	}   
	@Override   
	protected void onResume(){  
		if(mMapView!=null){
	        mMapView.onResume();}   
	        if(mBMapMan!=null){   
	                mBMapMan.start();   
	        }   
	        super.onResume();   
	}  

}

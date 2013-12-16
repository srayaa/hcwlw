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
		//ע�⣺��������setContentViewǰ��ʼ��BMapManager���󣬷���ᱨ��   
		setContentView(R.layout.activity_navi);
		mMapView=(MapView)findViewById(R.id.bmapsView);   
		mMapView.setBuiltInZoomControls(true);   
		//�����������õ����ſؼ�   
		MapController mMapController=mMapView.getController();   
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����   
		GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));   
		//�ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢�� (�� * 1E6)   
		mMapController.setCenter(point);//���õ�ͼ���ĵ�   
		mMapController.setZoom(12);//���õ�ͼzoom����  

		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("�й�������-����");
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

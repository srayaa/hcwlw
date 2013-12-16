package com.hcwlw;

import com.hcwlw.lib.Utils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.view.Menu;

public class SplashActivity extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 3500; // �ӳ�����
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this,
						LoginActivity.class);
				SplashActivity.this.startActivity(mainIntent);
				SplashActivity.this.finish();
			}
			
		}, SPLASH_DISPLAY_LENGHT);
		addShortcut();
/*		getApplication().getSharedPreferences("configFile", MODE_PRIVATE).edit().putString("adurl", "").commit();
		String adurl = getApplication().getSharedPreferences("configFile", MODE_PRIVATE).getString("adurl", "");
		if(!adurl.equals("")){
			this.findViewById(R.id.moren).setVisibility(View.GONE);
			((ImageView) this.findViewById(R.id.adimg)).setImageBitmap(BitmapFactory.decodeFile("adurl"));
			((View) this.findViewById(R.id.adfind)).setVisibility(View.VISIBLE);
		}
		chkAdupdate ck = new chkAdupdate();
		ck.execute((Void) null);*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}
	/**
	 * Ϊ���򴴽������ݷ�ʽ
	 */
	private void addShortcut(){
		Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
			
		//��ݷ�ʽ������
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
		shortcut.putExtra("duplicate", false); //�������ظ�����
			
		//ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
		//ע��: ComponentName�ĵڶ�������������ϵ��(.)�������ݷ�ʽ�޷�������Ӧ����
		//ComponentName comp = new ComponentName(this.getPackageName(), "."+this.getLocalClassName());
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(getApplicationContext(),SplashActivity.class));
		//shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

		//��ݷ�ʽ��ͼ��
		ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(this, R.drawable.ic_launcher);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			
		sendBroadcast(shortcut);
	}
	public class chkAdupdate extends AsyncTask<Void, Void, Boolean>{

		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				//http://192.168.1.6:8088/ytdz/ytdz/dd/0/ppj
				//Map<String,String> m = new LinkedHashMap<String, String>();
				//m.put("ddModel.sjid", result.getString("txid"));
				//NetHelper.getRequest("ytdz/ytdz/dd/0/ppj");
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
/*			if(result){
				Toast.makeText(DriverSucActivity.this, "���۳ɹ���", Toast.LENGTH_LONG).show();
				Intent i = new Intent(DriverSucActivity.this,MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
			super.onPostExecute(result);*/
		}
	}

}

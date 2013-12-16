package com.hcwlw.bak;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hcwlw.LoginActivity;
import com.hcwlw.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivitybak extends Activity {
	private SharedPreferences sp;
	
	private GridView mGridView;   //MyGridView
    //����ͼ������
  private int[] imageRes = { R.drawable.a3, R.drawable.a2,
   R.drawable.a3, R.drawable.a2, R.drawable.a3, R.drawable.a2,
   R.drawable.a3, R.drawable.a2, R.drawable.a3};
   //�����������
  private String[] itemName = { "Ѱ�һ�Դ", "Ѱ�ҳ�Դ", "������·", "���׼�¼", "�ҵ��ղ�",
   "λ����Ϣ", "������Դ", "������Դ", "����" };
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp = this.getSharedPreferences("passwordFile", MODE_PRIVATE);
		
		TabHost th = (TabHost) findViewById(R.id.main_tab2);
		//th.setup(this.getLocalActivityManager());
		th.setup(new LocalActivityManager(this,true));
		//mGridView = (GridView) findViewById(R.id.MyGridView);
        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        int length = itemName.length;
        for (int i = 0; i < length; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImageView", imageRes[i]);
                map.put("ItemTextView", itemName[i]);
                data.add(map);
        }
        //Ϊitme.xml���������
       SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivitybak.this,
        data, R.layout.item, new String[] { "ItemImageView","ItemTextView" }, new int[] { R.id.ItemImage,R.id.ItemText });
        mGridView.setAdapter(simpleAdapter);
        //ΪmGridView��ӵ���¼�������
       mGridView.setOnItemClickListener(new GridViewItemOnClick());

		
	}

	public class GridViewItemOnClick implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int position,long arg3) {
               Toast.makeText(getApplicationContext(), position + "",
               Toast.LENGTH_SHORT).show();
        }
     }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
    	menu.add(1,Menu.FIRST,Menu.FIRST,"�л��û�");
        return true;
	}
	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	// TODO Auto-generated method stub
	    	if(item.getItemId()==Menu.FIRST){
	    		
	    		sp.edit().putString("USER_NAME", "").commit();
				sp.edit().putString("PASSWORD", "").commit();
				sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
				
				Intent i = new Intent(MainActivitybak.this,LoginActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
				startActivity(i);
				
				finish();
	    	}else{
	    		return super.onOptionsItemSelected(item);
	    	}
	    	return true;
	    }
}
